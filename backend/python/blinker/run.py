from signalib import ready
from receiver import ready_receiver
import pdb


class Sender(object):
    def __init__(self, signal, name):
        self.name = name
        self.signal = signal

    def send(self, *args, **kwargs):
        self.signal.send(*args, **kwargs)

    def __repr__(self):
        return '<Sender %s>' % self.name

A = Sender(ready, 'user A')
B = Sender(ready, 'user B')


ready.connect(ready_receiver, sender=A)

#B.send('some message')
#A.send('some message')


