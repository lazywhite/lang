'''
yum -y install ceph-common
or 
pip install python-cephlibs
'''
import Rados

cluster = rados.Rados(conffile="./ceph.conf")
cluster.connect()
print cluster.version()
print cluster.get_cluster_stats()

