## pip install jsonpath

import jsonpath

## jsonobj是通过json.loads()解析出的数据
jsonobj ={
    "state":1,
    "message":"success",
    "content":{
        "data":{
            "allCitySearchLabels":{
                "A":[{"id":105795,"name":"中国澳门特别行政区"},
                     {"id":671,"name":"安庆"},
                     {"id":601,"name":"鞍山"}
                     ]
                }
            }
        }
}
# 从根节点开始，匹配name节点
citylist = jsonpath.jsonpath(jsonobj,'$..name')

print(citylist)
