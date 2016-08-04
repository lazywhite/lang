```
1. npm install -g oss-sync
2. mkdir oss_sync; cd oss_sync
3. touch .oss-sync.json  


{
    "source": "/data/xdb_upload/xdb",
    "dest": "xdb",
    "accessKeyId": "",
    "secretAccessKey": "",
    "endpoint": "http://oss-cn-hangzhou-internal.aliyuncs.com",
    "bucket": "bktest",
    "incrementalMode": "false"
}

4. osync -f

```