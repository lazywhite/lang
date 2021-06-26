#!/usr/bin/env python
import pika

credentials = pika.PlainCredentials("root", "root")
connection = pika.BlockingConnection(pika.ConnectionParameters(
        host='localhost',credentials=credentials ))

channel = connection.channel()

channel.queue_declare(queue='rpc_queue')

def fib(n):
    if n <= 1:
        return n
    else:
        return fib(n-1) + fib(n-2)

def on_request(ch, method, props, body):
    n = int(body)

    print " [.] fib(%s)"  % (n,)
    response = fib(n)

    ch.basic_publish(exchange='',
                     routing_key=props.reply_to,
                     properties=pika.BasicProperties(correlation_id = \
                                                     props.correlation_id),
                     body=str(response))
    ch.basic_ack(delivery_tag = method.delivery_tag)

channel.basic_qos(prefetch_count=1)
channel.basic_consume(on_request, queue='rpc_queue')

print " [x] Awaiting RPC requests"
channel.start_consuming()
