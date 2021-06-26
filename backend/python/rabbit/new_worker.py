import pika
import time

connection=pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

channel = connection.channel()

channel.queue_declare(queue='task_queue', durable=True)

print('[x] Waiting for message')

def callback(ch, method, properties, body):
    print('Received %r' % body)
    time.sleep(3)
    print('Done')
    ch.basic_ack(delivery_tag=method.delivery_tag)

channel.basic_qos(prefetch_count=1)
channel.basic_consume(callback, queue='task_queue', consumer_tag="hehe")

channel.start_consuming()
