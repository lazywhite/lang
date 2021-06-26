import time
from resty import PathDispatcher
from wsgiref.simple_server import make_server



_hello_resp = ''''\
    <html> <head> <title>Hello {name}</title> </head>
    <body> <h1>Hello {name}!</h1> </body> </html>
    '''

_localtime_resp = '''\
<?xml version="1.0"?>
<time>
<year>{t.tm_year}</year>
<month>{t.tm_mon}</month>
<day>{t.tm_mday}</day>
<hour>{t.tm_hour}</hour>
<minute>{t.tm_min}</minute>
<second>{t.tm_sec}</second>
</time>'''

def hello_world(environ, start_response):
    start_response('200 ok', [('Content-type', 'text/html')])
    params = environ['params']
    resp = _hello_resp.format(name=params.get('name'))
    yield resp.encode('utf-8')

def localtime(environ, start_response):
    start_response('200 ok', [('Content-type', 'text/html')])
    resp = _localtime_resp.format(t=time.localtime())
    yield resp.encode('utf-8')



dispatcher = PathDispatcher()
dispatcher.register('GET', '/hello', hello_world)
dispatcher.register('GET', '/localtime', localtime)


httpd = make_server('', 3000, dispatcher)
print('Serving on port 3000')

httpd.serve_forever()
