$ pip install gunicorn
$ cat myapp.py
def app(environ, start_response):
	data = b"Hello, World!\n"
	start_response("200 OK", [
		("Content-Type", "text/plain"),
		("Content-Length", str(len(data)))
	])
	return iter([data])
$ gunicorn -w 4 myapp:app

# integrate with Django
gunicorn --env DJANGO_SETTINGS_MODULE=myproject.settings myproject.wsgi

