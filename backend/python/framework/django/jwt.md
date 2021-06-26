## Usage
```
pip install djangorestframework
pip install djangorestframework-jwt

http://getblimp.github.io/django-rest-framework-jwt/


开启view jwt认证
    from rest_framework.decorators import api_view, permission_classes
    from rest_framework.permissions import IsAuthenticated

    @api_view(['GET'])
    @permission_classes((IsAuthenticated, ))
    def view(request):
        pass

```



## Get Token
```
curl -X POST -d "username=admin&password=adminP@ssword" http://localhost:8000/api-token-auth/


$ curl -X POST -H "Content-Type: application/json" -d '{"username":"admin","password":"password123"}' http://localhost:8000/api-token-auth/

{"token":"<token>"}
```

## Use Token
  
```
curl -H "Authorization: JWT <your_token>" http://localhost:8000/protected-url/
```

## Refresh Token
```
curl -X POST -H "Content-Type: application/json" -d '{"token":"<token>"}' http://localhost:8000/api-token-refresh/
```

## Verify Token
```
curl -X POST -H "Content-Type: application/json" -d '{"token":"<token>"}' http://localhost:8000/api-token-verify/
```
