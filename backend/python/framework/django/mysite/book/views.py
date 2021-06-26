# -*- coding: utf-8 -*-
from django.contrib.auth.decorators import login_required
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from django.http import HttpResponseRedirect, HttpResponse, StreamingHttpResponse
from django.shortcuts import render
from .forms import UploadFileForm, BookForm, AuthorForm
from .helper import handle_uploaded_file, file_iterator, commit_callback
from .models import Book, Author
from django.utils.translation import activate, ugettext as _

from django.contrib import messages
from django.core import serializers
from django.db import transaction


def index(request):
    form = UploadFileForm(request.POST, request.FILES)
    LANGUAGE_CODE = request.LANGUAGE_CODE
    activate(LANGUAGE_CODE)
    return render(request, 'book/index.html', locals())


#@login_required
def list_book(request):
    book_list = Book.objects.all()
    paginator = Paginator(book_list, 10)
    page = request.GET.get('page')
    try:
        books = paginator.page(page)
    except PageNotAnInteger:
        books = paginator.page(1)
    except EmptyPage:
        books = paginator.page(paginator.num_pages)

    return render(request, 'book/list_book.html', {'books': books})


def upload_file(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            for i in request.FILES.iteritems():
                print i.count(), i.index()
            handle_uploaded_file(request.FILES['file'])
            return HttpResponseRedirect('/book/')
    else:
        form = UploadFileForm()
    return render(request, 'book/upload.html', {'form': form})

@transaction.atomic
def upload_book(request):
    if request.method == 'GET':
        form = BookForm()
        return render(request, 'book/upload_book.html', {'form':form})
    if request.method == 'POST':
        book_form = BookForm(request.POST)
        if book_form.is_valid():
            book_form.save()
#            a = 100 / 0  #代码抛出异常, 事务失败
            return HttpResponse("good")

@transaction.atomic
def add_author(request):
    if request.method == 'GET':
        form = AuthorForm()
        return render(request, 'book/add_author.html', locals())
    if request.method == 'POST':
        author_form = AuthorForm(request.POST)
        if author_form.is_valid(): # will check name unique
            author_form.save()
            return HttpResponse('Author added')
        else:
            print author_form.errors.as_data()
            form = AuthorForm()
            messages.warning(request, 'Author exists')  
            return render(request, "book/add_author.html", locals())

def list_author(request):
    transaction.set_autocommit(False, using="default")
    if request.method == 'GET':
        authors = Author.objects.all()
        return render(request, "book/list_author.html", locals())

def all_book(request):
    data = serializers.serialize("json", Book.objects.all(), fields=('name',))
    return HttpResponse(data)


def download(request):
    transaction.on_commit(commit_callback)  
    file_name = request.GET.get("filename")
    filename = "/Users/white/local/" + file_name
    response = StreamingHttpResponse(file_iterator(filename))
    response["Content-Type"] = "application/octet-stream"
    response["Content-Disposition"] = "attachment;filename={0}".format(file_name)
    return response

