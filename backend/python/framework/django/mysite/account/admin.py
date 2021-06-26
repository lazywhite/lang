# -*- coding: utf-8 -*-
from django.contrib import admin
from guardian.admin import GuardedModelAdmin

from .models import UserProfile


@admin.register(UserProfile)
class UserProfileAdmin(GuardedModelAdmin):
    list_display = (u'id', u'user', u'mobile', u'nickname')
    list_filter = ('user',)
