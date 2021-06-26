#!/usr/bin/python2.6
import pika

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))

channel = connection.channel()

channel.queue_declare(queue='hello')

print 'waiting for message, Ctrl-c to exit'

def callback(ch, method, properties, body):
    print '[x] Received %r' % (body,)
    print (ch, method, properties)

channel.basic_consume(callback, queue='hello', no_ack=True)

channel.start_consuming()
