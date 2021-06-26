from datetime import datetime

c = datetime.today().date()
d = datetime.strftime(c, '%Y-%m-%d %H:%M:%S')
a = '2015-10-01 00:00:00'
b = datetime.strptime(a, '%Y-%m-%d %H:%M:%S')
print type(d), d
print type(b), b

## get timestamp from datetime
import time
dt = datetime(2017, 03, 21)
print time.mktime(dt.timetuple())


## get datetime from timestamp
datetime.fromtimestamp(1506311238)



a =  timedelta(hours=8)
## timedelta(days=8)
## timedelta(minutes=8)
## timedelta(seconds=8)
## timedelta(8) # 默认为day
#a = timedelta(days=2, hours=10)
#b = timedelta(days=2.5, minutes=50)

a.total_seconds()

# get week id from datetime
a.isocalendar() # (year, week id, week day)
