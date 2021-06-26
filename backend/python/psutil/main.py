# get process and system information by psutil module
import psutil
import datetime

cpu = psutil.cpu_times()
logical_cpu_count =  psutil.cpu_count()
phy_cpu_count =  psutil.cpu_count(logical=False)
mem = psutil.virtual_memory()
disk_partition = psutil.disk_partitions()
disk_usage = psutil.disk_usage('/')
disk_io = psutil.disk_io_counters(perdisk=True)
net_io = psutil.net_io_counters(pernic=True)
users = psutil.users()
boot_time = psutil.boot_time()

pid_list = psutil.get_pid_list()
process_list = psutil.get_process_list()
print 'logical cpu number: ', logical_cpu_count
print 'physical cpu number: ', phy_cpu_count
print 'user cpu usage: ', cpu.user
print 'system cpu usage: ', cpu.system
print
print 'total memory: ', mem.total 
print 'free memory: ', mem.free
print

print 'disk partition info: ', disk_partition
print 'disk usage: ', disk_usage
print 'disk io status: ' , disk_io
print

print 'NICs: ' , net_io.keys()
print
print 'users: ',  users
print
print 'boot time: ', datetime.datetime.fromtimestamp(boot_time)
print
print 'process list: ', [psutil.Process(i).name() for i in pid_list]

