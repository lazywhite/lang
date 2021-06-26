from django.conf import settings


class StackOverflowMiddleware(object):
    def __init__(self, get_response):
        self.get_response = get_response

    def __call__(self, request):
        response = self.get_response(request)
        return response

    def process_exception(self, request, exception):
        if settings.DEBUG:
            print exception.__class__.__name__
            print exception.message
        return None
