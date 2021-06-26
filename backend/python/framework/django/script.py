import os
import sys
import django

sys.path.insert(0, '/Users/white/cmdb')
os.environ.setdefault("DJANGO_SETTINGS_MODULE", "mysite.settings")
django.setup()


from op_script.models import Script
for i in Script.objects.all():
    print i.name
~
