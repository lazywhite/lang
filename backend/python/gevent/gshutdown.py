import gevent
import signal

def run_forever():
    gevent.sleep(10000)

gevent.signal(signal.SIGQUIT, gevent.shutdown)
thread = gevent.spawn(run_forever)

thread.join()
