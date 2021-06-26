from django.shortcuts import render
from .tasks import *
from django.http import HttpResponse

# Create your views here.

def index(request):
    r = add.delay(4, 4)
    return HttpResponse(r.get())
