from blinker import signal



def subscriber(sender):
    print 'Got a signal sent by %r' % sender


ready = signal('ready')
#ready.connect(subscriber, sender=processor_b)
#ready.connect(subscriber, sender=processor_b)



#send_data = signal('send-data')
#@send_data.connect
#def receive_data(sender, **kw):
#    print "Caugth signal from %r, data %r" % (sender, kw)
#    return 'received'

#result = send_data.send('anonymous', abc=123, m={'k1':'v1'})


