from __future__ import unicode_literals

from django.db import models
from django.contrib.auth.models import User
from django.db.models.signals import post_save

class UserProfile(models.Model):
    user = models.OneToOneField(User, unique=True, verbose_name="User", related_name="profile")
    mobile = models.CharField(max_length=20)
    nickname = models.CharField(max_length=20, null=False, default="guest")
    portrait = models.ImageField(upload_to='img/', null=False, default='media/img/guest.jpg')


    def __str__(self):
        return self.nickname

    def __unicode__(self):
        return self.nickname



class MyUser(User):
    class Meta:
        proxy = True
        ordering = ["last_name", "username"]

    def do_something(self):
        print "proxy demo"
