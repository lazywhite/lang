import threading
import time

'''
优雅的手动停止线程
'''


def run(arg):
    t = threading.currentThread()
    while not getattr(t, "stopped", False):
        print ("working on %s" % arg)
        time.sleep(1)

    # do cleanup job
    # close file, release lock
    print("Stopping as you wish.")


def main():
    t = threading.Thread(target=run, args=("task",))
    t.setDaemon(True)
    t.start()
    time.sleep(5)
    t.stopped = True
    t.join() # 必须
    time.sleep(5)
    print 'main exit'

if __name__ == "__main__":
    main()

