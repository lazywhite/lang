# -*- coding: utf-8 -*-
from django.conf import settings
from django.conf.urls import url
from django.conf.urls.static import static
from django.contrib.auth import views as auth_views

from . import views

app_name = 'account'
urlpatterns = [
        url(r'^login/$', auth_views.login, {"template_name": "account/login.html"}, name="login"),
        url(r'^logout/$', auth_views.logout, {"next_page": "/account/login/"},  name="logout"), #不设置next_page, 会渲染logged_out.html
        url(r'^signup/$', views.signup, name="signup"),
        url(r'^profile/$', views.profile,  name="profile"),
        url(r'^image_upload/$', views.image_upload,  name="image_upload"),
        url(r'^test/$', views.test, name="test"),
        url(r'^json/$', views.json, name="json"),
        url(r'^export/csv/$', views.export_users_csv, name="export_users_csv"),
        url(r'^export/xls/$', views.export_users_xls, name="export_users_xls"),
        ]

if settings.DEBUG:
        urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
