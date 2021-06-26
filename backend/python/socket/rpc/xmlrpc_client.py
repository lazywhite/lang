import xmlrpclib
import sys
import os

proxy = xmlrpclib.ServerProxy('http://localhost:9000')

try:
    dir_name = sys.argv[1]
    print proxy.list_contents(dir_name)
    #proxy.run('echo "hello">>/tmp/haha')
except:
    print 'Usage: python %s dir_name' % os.path.basename(sys.argv[0])
