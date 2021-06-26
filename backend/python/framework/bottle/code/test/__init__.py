from peewee import Model, CharField, IntegerField
from bottle import Bottle, request, response, template, redirect
import bottle_session
import bottle_redis
import bottle_peewee
import redis
#from bottle_config import config

#TODO: load config from config file

app = Bottle()

#app.install(config)
#app.config.load_config('config.ini')
#print app.config

session_plugin = bottle_session.SessionPlugin(cookie_lifetime=600)

redis_plugin = bottle_redis.RedisPlugin()
conn_pool = redis.ConnectionPool(host='localhost', port=6379)

session_plugin.connection_pool = conn_pool
redis_plugin.redisdb = conn_pool

peewee_plugin = bottle_peewee.PeeweePlugin("mysql://root:root@localhost:3306/test")

app.install(session_plugin)
app.install(redis_plugin)
app.install(peewee_plugin)

@app.route('/login', method='POST')
def login(session):
    postbody = request.body.read()
    print postbody
    username = request.forms.get("username")
    password = request.forms.get("password")
    user = User.get(User.name==username)
    if user and (user.password == password):
        session['username'] = username
        response.set_cookie("key", "value")
        redirect('/login')
    else:
        return "password not correct"

@app.route('/login', method='GET')
def login(session):
    username = session.get('username')
    if username:
        redirect('/user')
    else:
        return template('login')

@app.route('/logout', method='GET')
def logout(session):
    del(session['username'])
    redirect("/login")


@app.route('/user')
def user(session):
    username = session.get('username')
    if not username:
        redirect("/login")
    else:
        return template('user', name=username)


class User(Model):
    class Meta(object):
        pass
        database = peewee_plugin.proxy
    
    id = IntegerField()
    name = CharField()
    password = CharField()
