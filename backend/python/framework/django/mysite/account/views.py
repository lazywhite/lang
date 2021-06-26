# -*- coding: utf-8 -*-
from django.conf.urls import url
from django.contrib.auth import authenticate, login
from django.contrib.auth.decorators import login_required, permission_required
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from django.db import transaction
from django.http import HttpResponse, JsonResponse
from django.shortcuts import render, render_to_response, redirect
import csv
import xlwt

from account.forms import SignUpForm, UserProfileForm


@login_required
def profile(request):
    return render(request, "account/profile.html", locals())


@login_required
def test(request):
    if not request.session.get("session_key"):
        request.session["session_key"] = "good"
    response = render(request, 'account/test.html', locals())
    response.set_cookie("cookie_key", "cookie_value")
    return response



@login_required
def json(request):
    users = User.objects.all().values("username", "is_active", "is_staff")
    data = list(users)
    return JsonResponse(data, safe=False) ### 序列化object, 必须添加safe=False



def export_users_csv(request):
    response = HttpResponse(content_type='text/csv')
    response['Content-Disposition'] = 'inline; filename="users.csv"'

    writer = csv.writer(response)
    writer.writerow(['Username', 'First name', 'Last name', 'Email address'])

    users = User.objects.all().values_list('username', 'first_name', 'last_name', 'email')
    for user in users:
        writer.writerow(user)

    return response

@permission_required("change_group")
def export_users_xls(request):
    response = HttpResponse(content_type='application/ms-excel')
    response['Content-Disposition'] = 'attachment; filename="users.xls"'

    wb = xlwt.Workbook(encoding='utf-8')
    ws = wb.add_sheet('Users')

    # Sheet header, first row
    row_num = 0

    font_style = xlwt.XFStyle()
    font_style.font.bold = True

    columns = ['Username', 'First name', 'Last name', 'Email address', ]

    for col_num in range(len(columns)):
        ws.write(row_num, col_num, columns[col_num], font_style)

    # Sheet body, remaining rows
    font_style = xlwt.XFStyle()

    rows = User.objects.all().values_list('username', 'first_name', 'last_name', 'email')
    for row in rows:
        row_num += 1
        for col_num in range(len(row)):
            ws.write(row_num, col_num, row[col_num], font_style)

    wb.save(response)
    return response


@transaction.atomic
def signup(request):
    if request.method == 'POST':
        form1 = SignUpForm(request.POST)
        form2 = UserProfileForm(request.POST)
        if form1.is_valid() and form2.is_valid():
            form1.save()
            username = form1.cleaned_data.get('username')
            raw_password = form1.cleaned_data.get('password1')
            user = authenticate(username=username, password=raw_password)
            login(request, user)
            profile = form2.save(commit=False)
            profile.user = user
            profile.save()
            return redirect('account:profile')
    else:
        form1 = SignUpForm()
        form2 = UserProfileForm()
    return render(request, 'account/signup.html', {'form1': form1, 'form2':form2})


@transaction.atomic(using='default')
def image_upload(request):
    if request.method == 'POST':
        form = UserProfileForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('account:profile')
    else:
        form = UserProfileForm()
    return render(request, 'account/image_upload.html', {'form': form})