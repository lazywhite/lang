from django.conf.urls import url
from . import views

app_name = 'book'
urlpatterns = [
        url(r'^$', views.index, name="index"),
        url(r'^upload/$', views.upload_file, name="upload"),
        url(r'^upload_book/$', views.upload_book, name="upload_book"),
        url(r'^add_author/$', views.add_author, name="add_author"),
        url(r'^list_book/$', views.list_book, name="list_book"),
        url(r'^list_author/$', views.list_author, name="list_author"),
        url(r'^all_book/$', views.all_book, name="all_book"),
        url(r'^download$', views.download, name="download"),
        ]
