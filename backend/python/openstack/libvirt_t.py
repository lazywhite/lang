#!/usr/bin/env python
import libvirt
import sys

# open a connection to hypervisor
conn = libvirt.open('qemu:///system')
if conn ==  None:
    print 'failed to open connection to hypervisor'
    sys.exit(1)

dom = conn.listDomainsID()
for id in dom:
    vm_id = conn.lookupByID(id)
    vm_name = vm_id.name()
    vm_uuid = vm_id.UUIDString()
    vm_info = vm_id.info()
    if vm_info[0] == 1:
        print vm_name,vm_uuid,vm_info[0],vm_info[3]

conn.close()
