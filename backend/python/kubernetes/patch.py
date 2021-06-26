from kubernetes import client, config


config.load_kube_config()
config.load_incluster_config()

obj = client.CustomObjectsApi().get_namespaced_custom_object("apps", "v1", "default", "statefulsets", "redis-middleware")

body= {
    "metadata": {
        "annotations":{
            "key1": None,   # 删除key
            "key2": "value3" # 无key则新增， 有key则更新value
        }
    }

}
# 默认使用strategic merge patch
resp = client.CustomObjectsApi().patch_namespaced_custom_object("apps", "v1", "default", "statefulsets", "redis-middleware", body=body)

print(resp)
