## Introduction
use lua to make nginx an app server  
## Installation on Mac
```
brew install pcre
brew install openssl

tar xf openresty-1.11.2.2.tar.gz
./configure --prefix=/usr/local/openresty --with-cc-opt="-I/usr/local/opt/openssl/include/ -I/usr/local/opt/pcre/include/" --with-ld-opt="-L/usr/local/opt/openssl/lib/ -L/usr/local/opt/pcre/lib/" --with-http_drizzle_module --with-http_postgres_module --with-http_iconv_module --with-lua_resty_mysql --with-lua_resty_redis -j8 
make install 

```
## Usage
```
mkdir work_dir
cd work_dir
mkdir logs conf

/path/to/openresty -p `pwd` -c conf/nginx.conf

/path/to/openresty -s reload
```
## Configuration
```
worker_processes  1;
error_log logs/error.log;
events {
    worker_connections 1024;
}
http {
    server {
        listen 8080;
        location / {
        default_type text/html;
        set $template_root html/templates;
            root html;
            content_by_lua '
            local template = require "resty.template"
            template.render("view.html", { message = "Hello, World!" })
            ';
        }
    }
}
```  
## Tools
```
./opm get bungle/lua-resty-template #enable lua template support

```
