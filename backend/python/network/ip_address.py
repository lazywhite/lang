# -*- coding: utf-8 -*-
import ipaddress

a = '192.168.0.1/20'
b = '192.168.0.10/20'
start = ipaddress.IPv4Interface(unicode(a))
end = ipaddress.IPv4Interface(unicode(b))

net = start.network

'''
只有相同类型的IPv4Address可以比较, IPv4Interface不能与IPv4Address比较
'''
ip_list = [str(ip) for ip in net.hosts() if ip >= start.ip and ip <= end.ip]
print ip_list

