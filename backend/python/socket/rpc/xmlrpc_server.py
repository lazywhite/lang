from SimpleXMLRPCServer import SimpleXMLRPCServer
import logging, os
logging.basicConfig(level=logging.DEBUG)
server = SimpleXMLRPCServer(('localhost', 9000), logRequests=True)

def list_contents(dir_name):
    logging.debug('list_contents %s', dir_name)
    return os.listdir(dir_name)

def run(args):
    logging.debug('run system command %s', args)
    return os.system(args)

server.register_function(list_contents)
server.register_function(run)



try:
    print 'Use Ctrl+C to exit'
    server.serve_forever()
except KeyboardInterrupt:
    print 'Exiting'
