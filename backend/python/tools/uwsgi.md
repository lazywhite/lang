## installation
pip install uwsgi

## uwsgi.ini
```
[uwsgi]
chdir=/deploy/dashboard
module=dashboard.wsgi:application
master=True
pidfile=/tmp/dashboard.pid
vacuum=True
max-requests=5000
daemonize=/var/log/dashboard.log
socket=dashboard.sock
processes=10
threads=10
env=DJANGO_SETTINGS_MODULE=dashboard.settings
```

## nginx_uwsgi.conf
```


upstream frontend{
    server localhost:85;
}


server {
    listen       80 default_server;
    server_name  _;
    charset     utf-8;

    keepalive_timeout 600;
    proxy_connect_timeout 500;
    proxy_send_timeout 500;
    proxy_read_timeout 500;

    location ^~ /account/ {
        try_files $uri @app;
    }
    location ^~ /zabbix/ {
        try_files $uri @app;
    }

    location ^~ /admin/ {
        try_files $uri @app;
    }
    location ^~ /frontend/ {
        proxy_pass http://frontend;
    }
    location @app {
        include uwsgi_params;
        uwsgi_pass unix:///deploy/dashboard/dashboard.sock;
       }
}

```
## Usage
```
uwsgi --ini uwsgi.ini # 启动
uwsgi --reload /path/to/pid # 重启

kill -9 pid | kill -HUP pid
```

## Logging
```
默认日志会打印在stdout/stderr, 使用--logto <file.log> 或者 --daemonize <file.log>

```
