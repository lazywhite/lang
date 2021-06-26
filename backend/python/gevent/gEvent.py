import gevent
from gevent.event import Event

evt = Event()

def setter():
    print('wait for me, I have to do sth')
    gevent.sleep(3)
    print("ok, I'm done")
    evt.set()


def waiter():
    print("I'll wait for you")
    evt.wait()
    print("it's about time")



def main():
    gevent.joinall([
        gevent.spawn(setter),
        gevent.spawn(waiter),
        gevent.spawn(waiter),
        gevent.spawn(waiter),
        gevent.spawn(waiter),
        gevent.spawn(waiter)
    ])

if __name__ == '__main__':
    main()
