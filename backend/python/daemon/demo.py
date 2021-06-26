'''
install
    pip install python-daemon
    python demo.py

daemon debug
    log = open(file, 'a+)
    daemon.DaemonContext(stdin=sys.stdin, stdout=log, stderr=log)
'''
from __future__ import print_function
import time
import daemon

def loop():
    while True:
        with open('/Users/white/aa.log', 'wt') as f:
            print('adkfj', file=f)
            time.sleep(1)

        
if __name__ == '__main__':
    with daemon.DaemonContext():
        loop()
