# -*- coding: utf-8 -*-
#
# Copyright © 2017 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.

"""
线程的线程
"""

from __future__ import print_function
from threading import Thread
import time

def father():

    def child(name):
        while True:
            print('print by %s' % name)
            time.sleep(1)
        
    t1 = Thread(target=child, args=("t1", )) 
    t2 = Thread(target=child, args=("t2", )) 

    t1.start()
    t2.start()

    t1.join()
    t2.join()

def main():
    thread = Thread(target=father, args=()) 
    thread.start()
    thread.join()

if __name__ == '__main__':
    main()
