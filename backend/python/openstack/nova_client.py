# -*- coding: utf-8 -*-
'''
keystoneauth1==3.2.0
python-novaclient==9.1.1
python-keystoneclient==3.13.0
'''
from novaclient.client import Client
from os_config import *
from keystoneauth1 import loading, session



loader = loading.get_plugin_loader("password")
#auth = loader.load_from_options(auth_url=OS_AUTH_URL, username=OS_USERNAME, password=OS_PASSWORD, project_id=OS_PROJECT_ID, project_domain_name = OS_PROJECT_NAME, user_domain_name=OS_USER_DOMAIN_NAME)
#auth = loader.load_from_options(auth_url=OS_AUTH_URL, username=OS_USERNAME, password=OS_PASSWORD, project_domain_name = OS_PROJECT_NAME, user_domain_name=OS_USER_DOMAIN_NAME)
auth = loader.load_from_options(auth_url=OS_AUTH_URL, username=OS_USERNAME, password=OS_PASSWORD, project_id = OS_PROJECT_ID)


session = session.Session(auth=auth)
nova = Client("2", session=session)


print nova.flavors.list()
#print nova.hypervisors.findall()


hypervisor_all = nova.hypervisor_stats.statistics()

print 'mem total: ', hypervisor_all.memory_mb
print 'mem_used: ', hypervisor_all.memory_mb_used

print 'disk_free: ', hypervisor_all.disk_available_least  # 磁盘总量
print 'disk_total: ', hypervisor_all.free_disk_gb ## 可用磁盘


print 'vcpu total: ', hypervisor_all.vcpus
print 'vcpu used: ', hypervisor_all.vcpus_used

print 'vms running: ', hypervisor_all.running_vms
print 'hypervisor total: ', hypervisor_all.count #物理机总量

