import pika
## durable=True ensure queue is persistant, delivery_mode=2 ensure
## message is persistant
## by default, ack is required 
## by default, message delivery algorithm is round-robin

connection = pika.BlockingConnection(
                            pika.ConnectionParameters(host='localhost'))

channel = connection.channel()
channel.queue_declare(queue='task_queue', durable=True)

message = 'hello xxx'

channel.basic_publish(exchange='',
                    routing_key='task_queue',
                    body=message,
                    properties=pika.BasicProperties(delivery_mode=2)
                    )

print('[x] sent %r' % (message,))
connection.close()



