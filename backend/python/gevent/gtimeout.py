import gevent
import traceback

timer = gevent.Timeout(2)


def wait(timer):
    print('running in greenlet')
    timer.start()
    gevent.sleep(20)

try:
    gevent.spawn(wait, timer).join()
    gevent.spawn(wait, timer).join()

except:
    traceback.print_exc()
    print('could not complete')


