## 一、Template
```
Using the template system in Python is a three-step process:

1. You configure an Engine.
2. You compile template code into a Template.
3. You render the template with a Context.
```
## 二、Model
### 2.1 Model Meta
```
class Meta:
    abstract = True # define as "abstract base class"
    app_label = 'myapp' # declare which app it belong to
    db_table = 'music_album' # define table name, use lowercase name for MySQL, 
                            # for Oracle, django will shorten table name and turn 
                            # them uppercase, use quoted name to prevent this 
                            # like db_table = '"name_left_in_lower"'
    db_tablespace  # used when backend database support tablespace
    default_manager_name
    default_related_name
    get_latest_by = 'order_data' # default field to use in latest() and earliest() methods
    managed = True   # whether django will be in charge of the lifecycle of this Models
    proxy = True  # use in "proxy model"
    verbose_name = u'中文'   # human readable name
    verbose_name_plural = 'stories' #复数名称
```
### 2.2 Model conclusion
```
每个model映射到数据库的一张表
每个model自动包含一个主键字段 id = models.AutoField(primary_key=True), 除非其他的字段属性中包含primary_key
让django管理model, 需要将app配置在INSTALLED_APPS中

```
### 2.3 Model 继承
前提: 父类必须继承django.db.models.Model  
一. 抽象父类, 不创建任何table, 只是用来定义子类的公共属性   

  
```
    class Meta:
        abstract = True
```
  
二. 继承类  
  
```
class Place(models.Model):
    name = models.CharField(max_length=50)
    address = models.CharField(max_length=80)

class Restaurant(Place):
    serves_hot_dogs = models.BooleanField(default=False)
    serves_pizza = models.BooleanField(default=False)

两个model均会产生真实的表, Restaurant表会包含name, address两个OneToOneField字段
```
   
三. 代理类   

```
class Person(models.Model):
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=30)

class NewManager(models.Manager):
    pass

class MyPerson(Person):
    objects = NewManager() ## 替换默认的model manager
    class Meta:
        proxy = True

    def do_something(self):
        pass
```

## 三、URL dispatch
1. To capture a value from the URL, just put parenthesis around it.  
2. There’s no need to add a leading slash, because every URL has that. For example, it’s ^articles, not ^/articles.  
3. The 'r' in front of each regular expression string is optional but recommended. It tells Python that a string is “raw” – that nothing in the string should be escaped. See Dive Into Python’s explanation.  
4. named regular-expression groups is (?P<name>pattern)  

## 四、Localization
###4.1 install gettext tool
```
brew install gettext
brew link --force gettext
rehash # makemessage will find "msguniq" command
```
### 4.2 get browser language
```
MIDDLEWARE_CLASSES = (
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.locale.LocaleMiddleware',
    'django.middleware.common.CommonMiddleware',
    # other middleware ...
)

browser_locale = request.LANGUAGE_CODE
```
### 4.3 usage
```
1. use translation in template file
from django.template import Context
locale = request.LANGUAGE_CODE 
context = Context({'LANGUAGE_CODE':locale})
return render_to_response('local/index.html', context=context )

{% load i18n %}
{% trans "Welcome" %}
2. use translation in python file
from django.utils.translation import ugettext as _, activate
activate(browser_locale)
return HttpResponse(_("Welcome"))

3. mkdir polls/locale
4. django-admin makemessages -l zh -e html 
        -l: locale name
        -e: extension name, default is 'html' 'txt', could be 'xml'
        # run this command in "project root" or "app dir", 
5. django-admin compilemessages

```
### 4.4 settings.py
```
LOCALE_PATHS :a list of directories where django look for translation files
USE_I18N = True # 开启国际化支持
LANGUAGE_CODE = 'en' # global locale setting

USE_L10N = False # whether localized formatting of data should be enabled
```

## 五、Topic
### 1. migrations
```
python manage.py makemigrations polls # create migration files with ID
./manage.py sqlmigrate polls 0001
./manage.py migrate # actually do the migration

mysql> drop table snippets;
mysql> delete from django_migrations where app='snippets';
bash> rm -rf snippets/migrations

如果之前的migrations数据丢失， 可以将models恢复到老的状态， 然后migrate --fake
最后添加新的model定义
```
### 2. django ipython shell
```
pip install django-extensions
INSTALLED_APPS.append('django_extensions')
python manage.py shell_plus [ --<type> ] (bython > ipython > pure)

mysite/settings.py
    SHELL_PLUS_PRE_IMPORTS = (
            ('polls.models', '*'),
            ('django.utils', 'timezone'),
            )

    SHELL_PLUS_DONT_LOAD = ['<app_name>', '<app_name>']

# 打印执行的sql
    python manage.py shell_plus --print-sql
    or 
    SHELL_PLUS_PRINT_SQL = True
```
### 7. django cache
```
type
    memcached
    redis
    database cache table
    filesystem cache
    local memory cache
    dummy cache
```
### 8. manage.py and django-admin
```
python manage.py startproject <pro_name>
python manage.py startapp <app_name>
python manage.py runserver [<ip>:<poort>]

"django-admin" is a command line tool,  "manage.py" does the same thing as "django-admin"
but take care of a few things for you
1. put your project's package on sys.path
2. sets the "DJANGO_SETTINGS_MODULE" environment variable pointing to "settings.py"

```

### 9. ManyToMany field all objects
```
a.mtm.all()
```
### 10. template filter and tag
```
filter: {{ var|length }}
tag: {% if %}  
```
### 11. django-apps
[django-bootstrap3](https://github.com/dyve/django-bootstrap3)
[django-rest-jwt]( http://getblimp.github.io/django-rest-framework-jwt/)

### 12. QuerySet API
```
return QuerySets
    filter(): 返回对象QuerySet
        Entry.objects.filter(pub_date__year=2005).order_by('-pub_date', 'headline')
    exclude()
        users = User.objects.exclude(body_text__icontains="food")
    annotate()
        q = Blog.objects.annotate(Count('entry'))
    order_by()
        Entry.objects.order_by('headline')
    reverse()
        Entry.objects.order_by('headline').reverse()
    distinct()
        Permission.objects.values("content_type_id").distinct() 
    values(): 返回字典QuerySet
    values_list(): 返回tuple QuerySet
    dates()
        User.objects.dates("date_joined", "day")
    datetimes()
    none(): 返回一个空的QuerySet对象
    all()
        
    select_related()
        select_related主要针一对一和多对一关系进行优化。
        User.objects.select_related().all()
    prefetch_related()
        对于多对多字段（ManyToManyField）和一对多字段进行优化
    extra(): 子查询
        Entry.objects.extra(where=['headline=%s'], params=['Lennon'])
        Entry.objects.extra(where=["foo='a' OR bar = 'a'", "baz = 'a'"])
        Entry.objects.extra(select={'new_id': "select id from tb where id > %s"}, select_params=(1,), order_by=['-nid'])

        Blog.objects.extra(
        select={
            'entry_count': 'SELECT COUNT(*) FROM blog_entry WHERE blog_entry.blog_id = blog_blog.id'
        },)
    defer()
        Entry.objects.defer("headline", "body")
        Entry.objects.defer("body").filter(rating=5).defer("headline")

        You can defer loading of fields in related models
        Blog.objects.select_related().defer("entry__headline", "entry__body")

    only()
        Users.objects.only("username") 返回的QuerySet中每个user对象仅有username属性
    using()
        Entry.objects.using('backup')
    select_for_update() # 加行锁
        entries = Entry.objects.select_for_update().filter(author=request.user)
    raw()
        for user in User.objects.raw("select * from auth_user"):
            print user.username
    date
         Entry.objects.filter(pub_date__date=datetime.date(2005, 1, 1)) 
         Entry.objects.filter(pub_date__date__gt=datetime.date(2005, 1, 1))        
    year
         Entry.objects.filter(pub_date__year=2005) 
         Entry.objects.filter(pub_date__year__gte=2005)
    month
           Entry.objects.filter(pub_date__month=12) 
           Entry.objects.filter(pub_date__month__gte=6)
    day
         Entry.objects.filter(pub_date__day=3) 
         Entry.objects.filter(pub_date__day__gte=3)
    week
         Entry.objects.filter(pub_date__week=52) 
         Entry.objects.filter(pub_date__week__gte=32, pub_date__week__lte=38)
    time
         Entry.objects.filter(pub_date__time=datetime.time(14, 30))

    limit
        Entry.objects.all()[5:10]
        不支持负数下标

do not return QuerySets
    get()
        group = Group.objects.get(pk=2)
        group = Group.objects.get(name="admin")
    create()
        p = Person.objects.create(first_name="Bruce", last_name="Springsteen")

        p = Person(first_name="Bruce", last_name="Springsteen")
        p.save(force_insert=True)
    get_or_create()
    update_or_create()
    bulk_create()
        Entry.objects.bulk_create([
            Entry(headline='This is a test'),
            Entry(headline='This is only a test'),
        ])
    count()
        Entry.objects.filter(headline__contains='Lennon').count()
    in_bulk()
    iterator()
    latest()
        Entry.objects.latest('pub_date')
    earliest()
        Entry.objects.earliest('pub_date')
    first()
        p = Article.objects.order_by('title', 'pub_date').first()
    last()
        p = Article.objects.order_by('title', 'pub_date').last()
    aggregate()
    exists()
        entry = Entry.objects.get(pk=123)
        if some_queryset.filter(pk=entry.pk).exists():
            print("Entry contained in queryset")
    update(): 返回受影响的行数
        Entry.objects.filter(pub_date__year=2010).update(comments_on=False, headline='This is old')
    delete()
        Entry.objects.filter(blog=b).delete()
    as_manager()

Field  Lookups
    in
        Entry.objects.filter(id__in=[1, 3, 4])

        inner_qs = Blog.objects.filter(name__contains='Cheddar') 
        entries = Entry.objects.filter(blog__in=inner_qs)

    gt; gte
        Entry.objects.filter(id__gt=4)
        Entry.objects.filter(id__gte=4)

    startswith; istartswith
    endswith; iendswith

    exact; iexact
        Entry.objects.get(id__exact=14)
        Entry.objects.get(id__exact=None)
    contains; icontains
    range
        start_date = datetime.date(2005, 1, 1)
        end_date = datetime.date(2005, 3, 31) 
        Entry.objects.filter(pub_date__range=(start_date, end_date))

    isnull
        Entry.objects.filter(pub_date__isnull=True)
        
    search(只能用在有全文索引的地方)
        Entry.objects.filter(headline__search="+Django -jazz Python")

    regex; iregex
        Entry.objects.get(title__regex=r'^(An?|The) +')


aggregation function
    返回一个字典, 而不是Queryset
    avg
        User.objects.aggregate(Avg('id'))
    min
        User.objects.aggregate(Min('id'))
    max
        User.objects.aggregate(Max('id'))
    count
        User.objects.count()
    sum
        ModelName.objects.filter(field_name__isnull=True).aggregate(Sum('field_name'))
        ModelName.objects.aggregate(Sum('field_name'))

Query Related tools
    Q()
        Q()对象就是为了便于处理复杂的过滤条件
        使用符号&或者|将多个Q()对象组合起来传递给filter()，exclude()，get()等函数。当多个Q()对象组合起来时，Django会自动生成一个新的Q()。
        逗号之间的Q是and关系, '|' 或, '~' 取反
        Q()对象可以结合关键字参数一起传递给查询函数，不过需要注意的是要将Q()对象放在关键字参数的前面
        from django.db.models import Q
        News.objects.get(
            Q(pub_date=date(2005, 5, 2)) | Q(pub_date=date(2005, 5, 6)),
            question__startswith='Who')
    Prefetch()
    prefetch_related_objects()


直接执行SQL语句
    User.objects.raw() || Manager.raw()
        name_map = {'first': 'first_name', 'last': 'last_name', 'bd': 'birth_date', 'pk': 'id'}
        Person.objects.raw('SELECT * FROM some_other_table', translations=name_map)
    django.db.connection + django.db.transaction

```

### 14. cookie and session
```
Cookie
	import datetime

	def set_cookie(response, key, value, days_expire = 7):
	  if days_expire is None:
		max_age = 365 * 24 * 60 * 60  #one year
	  else:
		max_age = days_expire * 24 * 60 * 60 
	  expires = datetime.datetime.strftime(datetime.datetime.utcnow() + datetime.timedelta(seconds=max_age), "%a, %d-%b-%Y %H:%M:%S GMT")
	  response.set_cookie(key, value, max_age=max_age, expires=expires, domain=settings.SESSION_COOKIE_DOMAIN, secure=settings.SESSION_COOKIE_SECURE or None)

	def view(request):
	  response = HttpResponse("hello")
	  set_cookie(response, 'name', 'jujule')
	  return response

	request.COOKIE.get('username')

Session
	request.session['username'] = 'bob'

```
#### 14.1 Redis Session
```
pip install django-redis

SESSION_ENGINE = "django.contrib.sessions.backends.cache"
SESSION_CACHE_ALIAS = "default"

request.session['key'] = 'value'
```
### 15. change user password
```
from django.contrib.auth.models import User
usr = User.objects.get(username='your username')
usr.set_password('raw password')
usr.save()
```

### 16. customized template filter
```
after adding templatetags, need to restart server
```
### 17. django field 
#### 17.1 Field Type
```
AutoField: 自增的IntegerField
BigAutoField: 自增的BigIntegerField
BigIntegerField
BinaryField: 存储raw binary数值的字段, 只接受bytes
BooleanField: bool字段, 只能存储True/False, 默认值是None, 如果希望可以存储null值, 使用NullBooleanField
CharField: 字符串字段, max_length设置最大长度
DateField: 对应datetime.date, 以下属性只能三选一, 不能同时使用
    auto_now = False # 每当object被save()时, 自动设置为当前时间
    auto_now_add = False # 记录object被创建的时间
    default 默认值 
DateTimeField: 对应datetime.datetime
DecimalField: 对应Decimal
    max_digits = 5
    decimal_places = 2
DurationField: 对应timedelta 存储微秒为单位的bigint
EmailField: 一个开启了email验证的CharField
FileField: 
    upload_to='uploads/%Y/%m/%d/'
    storage
FilePathField
FloatField: 对应float类型
ImageField: 添加了image验证的FileFiled, 底层是varchar类型, 默认max_length=100
    height_field
    width_field
IntegerField: int字
GenericIPAddressField: 按照字符串来存取
    protocol=("both"|"IPv4"|"IPv6")
    unpack_ipv4=(True|False)
PositiveIntegerField: unsigned int
PositiveSmallIntegerField: unsigned small int
SlugField: 只能存储包含数字, 字母, 下划线, 连接符的varchar, max_length默认50
SmallIntegerField: small int
TextField: 对应mysql text类型字段, 接受<textarea>提交的值
TimeField: 对应datetime.time
URLField: 存储url的CharField, max_length默认为200
UUIDField:
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
```
#### 17.2 Field Option
```
null: 数据库字段值允许为null
blank: form表单验证中, 或者amdin页面, 允许空值
choices: 
    class Person(models.Model):
        # 第一个元素为最终存储在表中的数据, 字段类型要是元素的数据类型
        SHIRT_SIZES = (
            ('S', 'Small'),  #<option value="S">Small</option>
            ('M', 'Medium'),
            ('L', 'Large'),
        )
        name = models.CharField(max_length=60)
        shirt_size = models.CharField(max_length=1, choices=SHIRT_SIZES)


db_column # 对应表的字段名, 如果不设置, 使用field name
db_index=<Bool> # 是否在当前字段建立索引
default # 字段默认值, 可以是callabled的
editable # 默认为True, 如果为False, 则admin, ModelForm均不会编辑此字段, 并且跳过表单验证
error_message # 设置自定义出错信息
help_text # form widget中的字段帮助信息
primary_key # 标示当前字段为table主键, 只读, 如果修改一个存在的object的主键值, 会产生一个新的object, 老的object仍然保留
unique # 字段值唯一

unique_for_date
    title = models.CharField(unique_for_date="pub_date") # 不允许出现title和pub_date字段值重复的行
    pub_date = models.DateField() 
    #pub_date = models.DateTimeField() # 只会检测date部分
unique_for_year
unique_for_month

validators(list) 

Verbose Field Names
    ForeignKey, ManyToManyField, OneToOneField, 通过verbose_name属性设置
        sites = models.ManyToManyField(Site, verbose_name="list of sites")
    普通字段, 通过第一个optional parameter设置
        first_name = models.CharField("person's first name", max_length=30)
        first_name = models.CharField(max_length=30)  # verbose_name会是first name, 将下划线转化为空格
```
#### 17.3 Relationship fields
```
ForeignKey
    特性
        recursive: 外键为自己
            models.ForeignKey('self', on_delete=models.CASCADE).
        lazy: 关联属性都是延迟加载的

    on_delete
        models.CASCADE: 跟随一起删除
        PROTECT: 禁止删除
        SET_NULL  当参考的行被删除, 设为null
        SET_DEFAULT 要求必须设置default属性
        SET(callable|value) 设置为callable返回的值
    limit_choices_to: 用在ModelForm解析中, 设置过滤条件
        limit_choices_to={'is_staff': True}, 


        def limit_pub_date_choices():
            return {'pub_date__lte': datetime.date.utcnow()}
        limit_choices_to = limit_pub_date_choices
    related_name: 反向引用的属性名, 默认为类名全小写
        值为"+", 表明不生成反向引用
    related_query_name
        # Declare the ForeignKey with related_query_name
        class Tag(models.Model):
            article = models.ForeignKey(
                Article,
                on_delete=models.CASCADE,
                related_name="tags",
                related_query_name="tag",
            )
            name = models.CharField(max_length=255)

        # That's now the name of the reverse filter
        Article.objects.filter(tag__name="important")

    to_field="uuid"
        外键参考的表的field, 默认是id, 可以是带有unique=True的其他field
    db_constraint: 数据库是否为外键创建约束, 默认为True
    swappable: 
    db_index: 默认为True, 若为False则只有外键, 不建立索引


ManyToManyField
    自连结
        friends = models.ManyToManyField("self", symmetrical=True)
        symmetrical默认为True, 标明双方访问是对等的
    through
        默认django会自己产生中间表, 用此选项指定想用的中间表
        当希望在映射关系中保存其他的信息时, 使用此方案
    through_fields
        手动指定中间表的哪些field用来做映射
    db_table: 手动指定产生的中间表的名称
    related_name: 默认为{{class|lower}}_set
OneToOneField
```
### 18. display sql query
```
from django.db import connection
print connection.queries

all = MyModel.objects.filter(name="my name")
print all.query
```
### 19. django-bootstrap3
```
pip install django-bootstrap3

INSTALLED_APPS
    bootstrap3

```
### 20. Request and Response 
```
Request Object
    request.method  # 请求方法
    request.user   # 当前session用户
    request.COOKIE

Response Object
    response.set_cookie()

render(request, 'template', context=locals())
return HttpResponseRedirect(request.META.get('HTTP_REFERER'))
```
### 21 Template Comment
```
{% comment %} {% endcomment %}
{# oneline comment #}

from django.tempate import Template, Context

t = Template("this is {{ name }}")
d = {"name" : "bob"}
t.render(Context(d))
```
### 22 Logging
```
logger
    日志系统的entry point
handler
    决定每条信息的处理
filter
    在logger与handler之间进行消息过滤
formatter
    message的最终格式

settings.py
    LOGGING = {
        'project.app': {
            'handlers' :['file_handler'],
            'level':'DEBUG',
            'propagate': True
        },

    }
project/app/view.py
	import logging
	logger = logging.getLogger("project.app")
	logger.warn("warning")
    
    try:
        1/0
    except:
        logger.exception("error")
    
```        

### 23 SMTP
```
## setting for SMTP
EMAIL_HOST = 'smtp.126.com'
EMAIL_PORT = 25
EMAIL_HOST_USER = ''
EMAIL_HOST_PASSWORD = ''
EMAIL_USE_TLS = True


from django.core.mail import send_email
send_mail("subject", "body", "sender", ["receiver1", "receiver02"...])
send_mail("test", "test", "cppking@126.com", ["lazywhite@qq.com"])
```

### 24. Database Function
```
django.db.models.functions
    Cast
    Concat
    Greatest
    Least
    Length
    Lower
    Now
    Substr
    Upper

    ExtractYear
    Trunc
```

### 25. Validator
```
callable, 接受一个value作为参数, 抛出ValidationError表明验证失败, 否则正常
Built-in Validators
    RegexValidator
    EmailValidator
    URLValidator
    FileExtensionValidator

```

### 26. 对象级权限控制
```
配置文档 https://github.com/django-guardian/django-guardian

>>> from django.contrib.auth.models import User, Group
>>> jack = User.objects.create_user('jack', 'jack@example.com', 'topsecretagentjack')
>>> ct = ContentType.objects.get(pk=12)
>>> perm = Permission()
>>> perm.codename = "view_book12"
>>> perm.name = "can view book 12"
>>> perm.content_type = ct
>>> perm.save()
>>> book12 = Book.objects.get(pk=12)
>>> jack.has_perm('view_book12', book12)
False
>>> from guardian.models import UserObjectPermission
>>> UserObjectPermission.objects.assign_perm('view_book12', jack, obj=book12)
<UserObjectPermission: admins | jack | change_group>
>>> jack.has_perm('view_book12', book12)
True
>>> jack.has_perm('view_book12')
False
```

### 27. test
```
from django.test import TestCase
from django.test import Client


c = Client()
response = c.post('/login/', {'username': 'john', 'password': 'smith'}) 

response.status_code
response.content


python manage.py test [app] --parallel
python manage.py test [app.test.OneTestCase] --parallel


test database
./manage.py test --keep-db
```
### 29. pydoc
### 30. 跨域
[djang-corsheaders](https://pypi.python.org/pypi/django-cors-headers/2.0.0)  

    CORS_ALLOW_CREDENTIALS = True
    CORS_ORIGIN_WHITELIST = (
        '192.168.1.70:8080',
    )


### 31. uwsgi部署
```
uwsgi不会响应静态文件请求

mysite/setting.py
    STATIC_ROOT = os.path.join(BASE_DIR, "static/")
    STATIC_URL = '/static/'

python manage.py collectstatic
nginx做反向代理


在模板中使用静态文件
    my_app/static/my_app/demo.jpg
    {% load static %}
    <img src='{% static "my_app/demo.jpg" %}' alt="My image"/>


```

### 31. Signal
```
local
    __init__.py
        default_app_config = "local.apps.LocalConfig"
    apps.py
        class LocalConfig(AppConfig):
            name = 'local'
            def ready(self):
                import local.signals
    signals.py
        from django.db.models.signals import pre_save
        from django.dispatch import receiver

        @receiver(<signal_name>, sender=<Model>)
        def handler(sender, **kwargs):
            pass

        signal_name
            pre_save: before obj.save()
            post_save: after obj.save()
            pre_delete: before obj.delete()
            post_delete: after obj.delete()
            m2m_changed
            request_started
            request_finished


自定义signal
    signals.py
        from django.dispatch import Signal
        pizza_done = Signal(providing_args=['topping', 'size'])

        @receiver(pizza_done, sender="chef")
        def pizza_handler(sender, topping, size, **kwargs): # 必须有**kwargs
            pass

    views.py
        from .signals import pizza_done
        def my_view(request):
            pizza_done.send(sender="chef", topping=10, size=20)

```
### 32 Static file
```
https://docs.djangoproject.com/en/1.11/howto/static-files/
```
### 33 Generate PDF
```
pip install reportlab
https://docs.djangoproject.com/en/1.11/howto/outputting-pdf/
```

### 34 Template
```
django.template.loader.get_template("template")
django.template.loader.render_to_string("template", context)
```
### 35 CSRF
```
disable globally
    commnet 'django.middleware.csrf.CsrfViewMiddleware',

disable on specific view
    from django.views.decorators.csrf import csrf_exempt

    @csrf_exempt
    def my_view(request):
        return HttpResponse('Hello world')

配置
    CSRF_USE_SESSIONS = False  #默认使用csrftoken cookie保存, 开启后存储在服务端
    CSRF_HEADER_NAME = 'X-CSRFToken' # 将token放在header进行传递时默认的key
    CSRF_COOKIE_NAME = 'csrftoken' # token放在在cookie内时默认的key

django csrf middleware 验证request csrf toke的流程
    1. 从cookie获取token, 不存在则返回403
    2. 如果是post方法, 则检查 form data 'csrfmiddlewaretoken'
        不存在则从request.META[CSRF_HEADER_NAME]中获取
        将两者比对, 相同则通过
 
与axios的配合使用
    1. django login api 使用csrf_exempt
    2. 登录成功后, 使用get-token api获取token
    3. 将token放入X-CSRFToken header中
        api.getCsrfToken().then(res=>{
            var token = res.data;
            axios.defaults.headers['X-CSRFToken'] = token;
        })
```

### 36 Redis Cache
```
pip install django-redis
CACHES = {
    "default": {
        "BACKEND": "django_redis.cache.RedisCache",
        "LOCATION": "redis://127.0.0.1:6379/0",
        "OPTIONS": {
            "CLIENT_CLASS": "django_redis.client.DefaultClient",
        }
    }
}

from django.core.cache import cache
cache.set("key", "value", timeout=None)
cache.set("key", "value", timeout=600)

cache.ttl("key") # 显示ttl
cache.persist("key") # 永不超时
cache.expire("key", 60) # 设置超时
cache.get("key")
```

### 37 Crontab
```
pip install django-crontab

settings.py
    INSTALLED_APPS = [
        'django_crontab',
    ]

    CRONJOBS = [
    ('*/5 * * * *', 'appname.cron.test','>>/home/test.log')
    ]

	LOGGING 

		'django_crontab.crontab': {
			'handlers' :['console'],
			'level':'DEBUG',
			'propagate': True
		},


python manage.py crontab add
# crontabl -l
python manage.py crontab show
python manage.py crontab remove

在setting中修改cronjob后先remove再add
```

### 38 自定义middleware

### 39 Redis
```
pip install django-redis
from djang_redis import get_redis_connection
conn = get_redis_connection('default')

```
### 40 class base view
```
# Django==1.11
from django.views import View
class MyView(View):
    http_method_names = ['get', 'post'] # 必须使用小写
    def get(self, request, *args, **kwargs):
        pass
    def post(self, request, route_param, *args, **kwargs):
        pass

```

### 41 django 1.11 admin svg图片不显示问题
```
project/settings.py
    import mimetypes

    mimetypes.add_type("image/svg+xml", ".svg", True)
    mimetypes.add_type("image/svg+xml", ".svgz", True)
```

### 42 app admin页面自定义名称
```
local/apps.py
    from django.app import AppConfig
    class LocalConfig(AppConfig):
        name = 'app'
        verbose_name = '中文'

local/__init__.py
    default_app_config = 'local.apps.LocalConfig'
```

### 42 某model设置为只读
```
local/admin.py
	from django.contrib import admin 

	@admin.register(User)
	class CLAdmin(admin.ModelAdmin):
		actions = None

		def has_add_permission(self, request):
			return True

		def has_change_permission(self, request, obj=None):
			return True

		def has_delete_permission(self, request, obj=None):
			return False


```

### 43 生成unique key
```
class Test(models.Model):
    name = models.CharField(unique=True)

class Test(models.Model):
    user = models.ForeignKey(User)
    name = models.CharField(unique=True)
    class Meta:
        unique_together = (('user', 'name'),)
        index_together = [
            ['user', 'name'],
        ]

如果在创建表之后再添加unique=True, migrate有可能不执行, 需要确认或手动执行
    alter table app_test add unique(name);
```

### 44 权限认证
```
method view
    from django.contrib.auth.decorators import user_passes_test
    @user_passes_test(lambda u:u.is_superuser)
    def req(request):
        pass

class based view
    from django.contrib.auth.mixins import UserPassesMixin, LoginRequiredMixin
    from django.views import View

    class CriteriaRootView(LoginRequiredMixin, UserPassesTestMixin, View):

        # 权限检测
        def test_func(self):
            if self.request.method == 'GET':
                return True
            if self.request.method == 'POST' and self.request.user.is_superuser:
                return True
            return False

        # override  登录跳转
        def get_login_url(self):
           if not self.request.user.is_authenticated():
                return super(CriteriaRootView, self).get_login_url()
           else:
                return '/account/login/'
```
### 45 事务
```
from django.db.utils import transaction

@transaction.atomic(using="default") # 多数据库连接
def func(request):
    pass

@transaction.atomic
def func(request):
    pass
```
### 46 django template unicode decode error
```
manage.py
    reload(sys)
    sys.setdefaultencoding('utf8')

path/to/template.html
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    </head>
views.py
    # -*- coding: utf-8 -*-
```

### 47 ModelForm
```
from django.forms import ModelForm, TextArea
from .models import Author
class Author(models.Model):
    name = models.CharField()
    title = models.CharField()
    birth_date = models.DateField(editable=False) # form不包含此field

class AuthorForm(ModelForm):
    # 完全自定义某个form filed
    slug = CharField(validators=[validate_slug]) # django.forms.CharField
    class Meta:
        model = Author
        fields = '__all__'  # 全部使用
        fields = ['name', 'title']  # 指定列表
        exclude = ['title']
        localized_fields  = '__all__' # 默认不会国际化
        # 改变默认widget
        widgets = {
            'name': TextArea(attrs={"cols": 80, "rows": 20})
        }
       labels = {
            'name': _('Writer'),
        }
        help_texts = {
            'name': _('Some useful help text.'),
        }
        error_messages = {
            'name': {
                'max_length': _("This writer's name is too long."),
            },
        }

def process(request):
    if request.method == 'GET':
        form = AuthorForm()
        return render(request, 'app/add_author.html', locals())
    if request.method == 'POST':
        '''
        # for create
        form = AuthorForm(request.POST)
        form.save()

        # change before save
        author = form.save(commit=False)
        author.attr = 'modified'
        author.save()
        form.save_m2m() # 仅在commit=False时使用
        '''

        '''
        # for update
        author = Author.objects.get(pk=10)
        form = AuthorForm(request.POST, instance=author)
        form.save()
        '''

        '''
        author = Author.objects.get(pk=3)
        form = AuthorForm(initial={"name": "default", instance=author)
        form['name'].value() # => "default" initial参数有最高优先级
        form['title'].value() # => "MR" 
        '''
        return render(request, 'app/add_author.html', locals())

```
## 48 认证系统
```
自定义权限, 默认会创建add_author, change_author, delete_author
class Author(models.Model):
    class Meta:
        permissions = (
            ("view_author", "View Author")
        )

python manage.py makemigrations <app>
python manage.py migrate <app> <num> 将会创建Permission对象
注意分库的时候, 要指定使用权限表所在的db source


# 创建普通用户
from django.contrib.auth import authenticate
from django.contrib.auth.models import Permission, User, Group
from django.contrib.contenttypes.models import ContentType

u = User.objects.create_user(username="demo", email="test@123.com", password="demo")
u.set_password("new")
u.check_password("new")
u = authenticat(username="demo", password="demo")

u.user_permissions.all() # 直接关联到用户的权限
# 创建root用户
python manage.py createsuperuser

# 创建组
g = Group.objects.create(name="admin")
g.permissions.all() # 关联到组的所有权限

u.groups.add(g) # 添加用户到组

author_ct = ContentType.objects.get_for_model(Author)

perms = Permission.objects.filter(content_type=author_ct)
change_author = perms[1]
g.permissions.add(change_author)

# u.has_perm()会检查自身及所属组的所有权限
# superuser has_perm()全部返回True
u.has_perm("polls.change_author") # => True 

# 新建自定义权限
perm = Permission.objects.create(codename="rename_author",
                name="Can rename author",
                content_type=author_ct)

u.user_permissions.add(perm)
u.has_perm("polls.rename_author") # => False  
# 因为权限会在第一次获取user object时缓存下来, 因此添加新权限后要重新获取
u = get_object_or_404(User, pk=user_id)
u.has_perm("polls.rename_author") # => True

# 权限相关decorator
from django.contrib.auth.decorators import permission_required
from django.contrib.auth.mixins import PermissionRequiredMixin

raise_exception=True, 会返回403而不是redirect
permission_required(perm, login_url=None, raise_exception=False)
@permission_required("polls.add_author")
def myview(request):
    pass


## 权限在模板系统中的使用
{{ user }} # 表示当前用户
{{ perms }} # 包含当前user的所有权限
{% if perms.polls.delete_author %}

默认权限由auth package提供, 新建model后, 需要重新migrate 所有
```

## 49 ORM API
```
author = Author.objects.get(pk=1)
a = Author.objects.create()
author.save()
author.delete()

# many2many
author.books_set.all() # 列表
author.books_set.set([book1, book2]) # 重设
author.books_set.add(book1, book2) # 增加
author.books_set.remove(book1, book2) # 删除
author.books_set.clear() # 清空

```
## 50 登录登出
```
from django.contrib.auth import login, authenticate, logout
user = authenticate(username="", password="")
if user is not None:
    login(request, user) 

logout(request)

from django.contrib.auth.decorators import login_required

#redirect_filed_name: 字段名 如果用户成功登录后, 跳转到的页面
# login_url: 如果用户未登录, 跳转到的页面, 全局设置  settings.LOGIN_URL
@login_required(redirect_field_name="next", login_url="/accounts/login")
def myview(request):
    pass
```
## 六、 Tips
```
python -c "import django; print(django.get_version())"

./manage.py createsuperuser --username=joe --email=joe@example.com

middleware 
    request会按照MIDDLEWARE_CLASSES定义的顺序被处理
    response按照相反顺序被处理

redirect("account:profile", permanent=True)
redirect("/user/login/", permanent=True)

主从读写分离
按app的数据库配置
    为某个app指定read/write, 要注意代码不要调用这个app之外的model

逆向生成models.py
    1. 在setting里面设置你要连接的数据库类型和连接名称，地址之类
    2. django-admin.py startapp app
    3. python manage.py inspectdb > app/models.py
    4. 仅生成某张表
        python manage.py inspectdb <table_name>


无主键的model无法进行迭代
ALLOWED_HOSTS = [ * ]

返回301, 可能url路径少了'/'

多数据库
    ./manage.py migrate --database=users

    ./manage.py makemigrations asset  0001
    ./manage.py sqlmigrate asset 0001 --database zabbix # 查看生成的sql脚本
    ./manage.py migrate asset 0001 --database zabbix
    ./manage.py  makemigration <app> #不能添加--database
    ./manage.py  migrate <app> <0001> --fake --database=xx #跳过某些migration

某个字段从CharField变为Enum类型时, 做好数据备份, 将原表中的数据全部设置为null, 然后可进行migrate
template中无法迭代defaultdict, 转化为dict

运行脚本  
    python manage.py shell_plus  # execfile("script.py")
    python manage.py shell < script.py

    import os
    import django
    os.environ['DJANGO_SETTINGS_MODULE'] = 'project.settings'
    django.setup()

快速为所有url添加前缀
    project.settings
        ROOT_URLCONF = 'dashboard.root_urls'
    project.root_urls
		from django.conf.urls import url, include

		urlpatterns = [
			url(r'^api/', include('project.urls')),
		]

	project.urls 保持不变


models.ForeignKey(IDC, unique=True)
    foreign key 字段不能使用unique, 否则跟OneToOneField是一样的

Items.objects.exclude(field__isnull=true)

attr_list = ['a', 'b', 'c']
Items.objects.filter(reduce(operator.or_, (Q(name__contains=attr) for attr in attr_list)))
    select * from items where name like "%a" or name like "%b%";

{% for item in items %}
    {% if forloop.counter0|divisibleby:2 %}
        content
    {% endif %}
{% endfor %}

为model设置admin页面别名
    class Meta:
        verbose_name=u'模块'
        verbose_name_plural=u'模块'
为field设置admin页面别名
    change_time=models.DateTimeField(verbose_name=u'更改时间')


ForeignKey model名称加引号, 其他情况可以不加
	1. You want a recursive relationship (eg - model.ForeignKey('self'))
	2. For referring to a model that is possibly not defined yet (for cyclic relationships).
	3. A shortcut to refer to a model in another application (eg - model.ForeignKey('app.mymodel'))


from django.views.decorators.http import require_http_methods
@require_http_methods(["POST", "GET"])

exception
    django.http.Http404
    django.db.utils.IntegrityError


设置用户密码
    user.set_password("new")
    user.save()

UnixtimestampField
    https://pypi.python.org/pypi/django-unixtimestampfield

python3 安装 mysql driver
    pip install pymysql
    django/mange.py
        import pymysql
        pymysql.install_as_MySQLdb()

    or
    yum -y install mariadb-devel
    pip install mysqlclient

QuerySet 不支持负数下标

template 声明变量
    {% with var=value %} {% endwith %}
```



