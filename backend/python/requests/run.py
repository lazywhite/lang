import requests
import json


url = "http://localhost:6000/v1"

data = {
    "template": "sample",
    "templateInput": {
        "stsName": "redis-0",
        "stsNamespace": "default",
        "cpuRequestLevel": "low",
     }
}
        

'''
1.  requests.post(url, data=data)
    flask: request.form[]
2.  requests.post(url, json=data)
    flask: request.get_json()
'''
