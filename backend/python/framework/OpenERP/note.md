## Keyword
```
module
    __init__.py
        should import all the other python file for submodules
    __openerp__.py: manifest file
        determine the XML files that will be parse during the initialization of ther server
        determine the dependencies of the created module
        declare additional meta data

        python dict literal
            name
            version
            summary
            description
            category
            author
            website
            licence
            depends
            data
                list of .xml files to load when the module is installed or updated
            demo
                list of additional .xml files to load when the module is installed or updated and demo flag
                is active
            installable 
            auto_install
    *.py: python object
        all OE resources are objects: metadata, menu, actions, reports
        Object name are hierarchical
    xml/csv files:  module data such as views, menu entries or demo data
        XML files are used to initialize or update the database                 
            views declaration
            reports declaration
            workflow declaration
    report
    workflow
    
security
    user
    group
    menu access
    view customize

menu and action
views and event
object, field, method

Qweb
template
widget
```


## OE Architecture

```
Model
Application
    modules/addons
Presentation
	os client
	web client
```

## Component
```
PostgreSQL database \(can be clustered databases\)  
    direct SQL queries  
    ORM modules  
OpenERP server \(could be multiple and load balanced \)  
    enterprise logic  
Client
    Javascript web browser application
        jsonRPC
    OS client
        XML-RPC (session-less)
```
## MVC
```
Model
    the postgresql tables
View
    defined by XML files 
Controller
    the objects of OpenERP
```


## Topic
everything in OpenERP, and objects method in particular, are exposed via the network and a security layer, access to the data model is in fact a
'service' and it is possible to expose new services  

services can make use of the WSGI stack, WSGI is a standard solution in  
the Python ecosystem to write HTTP servers, applications and middleware  
which can be used in a mix-and-match fashion, by using WSGI it is possible  to run OpenERP in any WSGI compliant server




## XML serialization
```

record tag
    attribute
        model
            model.Model is the object name where the insertion has to be done
        id
            make reference to this record
    field
        name
        eval
        ref
        model
        search

function tag \(self closed \)
    field
        model
        name
        eval
```

## Views
views are way to represent the objects on the client side, they indicate to the client how to layout the data coming from the objects on the screen views are describe in xml

if no view has been defined for an object, the object is able to generate a view to represent itself  

```
Types
    form view
    tree view
        list view: just a particular case of tree view
    gantt view
    graph view
    search view

```


## Report
## Workflow
the objects and the views allow you to define new forms very simply, lists/trees and interactions between them
but that's not enough, you must define the dynamic of these objects

example:
    a confirmed sale order must generate and invoice, according to certain conditions
    a paid invoice must, only under certain conditions, start the shippping order


## Objects
1. all the OE pieces of data are accessible through "objects", as an example, there is a res.partner object to access  
the data concerning the partners, an account.invoice object for the data concerning the invoices, etc...
2. there is an object for every type of resources, and not an object per resource
3. OE "Ojbects" are usually called classes in object oriented programming
4. an OE "Resource" is usually called an object in OO  programming, instance of a class
5. an OE "Resource" can be converted magically into a nice Python object using the "browse" class method



## Object Attributes
data model is described and manipulated through Python classes and objects
### Object definition
```
class name_of_the_object(osv.osv):
    _name = 'name.of.the.object'
    _columns = {..}

name_of_the_object()

an object is defined by declaring some field with predefined names in the class, Two of them are required(_name and _colums)

Predefined fields
    _auto: determines whether a corresponding PG table must be generated automatically from the object
    _columns: the object fields
    _constraints: the constraints on the object
    _sql_constraints: 
    _defaults: default value for some of the object's field
    _inherit: the name of the osv object which the current object inherits from
    _inherits: the list of "osv" objects which the currrent object inherits from, list must be a Python Dict
    _log_access: determines whether or not the write access to the resource must be logged, If true, four fields will be 
                created in the SQL table: "create_uid", "create_date", "write_uid", "write_date" 
                This data may be obtained by using the "perm_read" method
    _name: (required)
    _order: Name of the fields used to sort the results of the search and read method
    _rec_name: name of the field in which the name of every resource is stored, default value "name"
    _sequence: name of the SQL sequence that manage the ids for this object, default value "None"
    _table: name of the SQL table, default value: the value of "_name" field with the dot replaced by underscores


Base  Type of fields
    boolean
    integer
    float
    char
    text
    date
    datetime
    binary
    selection
    

Relational Types if fields
    one2one
    many2one
    one2many
    many2many
    related: refer to the relation of a relation

Functional Fields

    'function' : fields.function(
                _get_cur_function_id,
                type='many2one', 
                obj="res.partner.function",
                method=True,
                string='Contract Function'),
        } 

Property Field
    
store Parameter
    It will calculate the field and store the result in the table

```
## Views and Events
1. every resource type uses its own interface
2. OE user interface is dynamically built from XML descriptions of the client screens
3. views called "screen description views"
4. views can be edited at any moment, after a modification to a displayed view has occured
    you simply need to close the tab corresponding to that "view" and re-open it for the changes to apprear
5. view describe how each object \(type of resource) is displayed, More precisely, for each object, we can 
    define one or several views to describe which fields should be drawn and how
6. form views can also contain graphs

### Form views
```
the field disposition in a form view always follows the same principle, Fields are distributed on the screen 
following the rules below:
    1. by dafault, each field is preceded by a label with its name
    2. fields are places on the screen from left to right and from top to bottom, according to the order in 
        which they are declared in the view
    3. every screen is divided into 4 columns, each column beging able to contain either a label or an "edition" 
        field, as every edition field sis preceded by a label with its name, there will be two fields on each line
        of the screen, the green and red zones on the screen-shot below, illustrate those 4 columns, they designate
        respectively the labels and their corresponding fields

view also support more advanced placement options
    1. a view field can use several columns
    2. we can also make the opposite operation: take a columns group and divide it in as many columns as desired
        the surrouned green zones of the screen above are good example
```

### On Change
```
the on_change attribute defines a method that is called when the content of a view field has changed, this method  
takes at least arguments: cr, uid, ids, which are the three classical arguments and also the context dictionary  
you can ad parameter to the method, they must correspond to other fields defined in the view and must also be 
defined in the XML with fields defined this way 

<field name="name_of_field" on_change="name_of_method()"/>

you can use "context" keyword to access data in the contet that can be used as params of the functions

it is possible no only to  change more than just the values of fields, but also the value of some fields and the 
domain of other fields by returning a value of the form "return{'domain': d , 'value': value}"
```

## Tree View
tree view are used when we work in list mode \(in order to visualize several resources at once\) and in the search 
screen, these views are simpler than the form views and thus have less options
## Search view
search view creates a customized search panel, and is declared quite similarly to a form view, except that the view 
type and root element change to "search" instead of "form"

### search view tags
group tag
filter tag
group by
Fields
range field

## Graph view
a graph is a new mode of view for all views of type form


## Controlling view actions
when defining a view, the following attributes can be added on the opening element of the view  

```
create
    set to false to hide the link/button which allows to create a new record
delete
    set to false to hide the link/button which allows to remove a record
edit
    set to false to hide the link/button which allows to edit a record
```
  
these attributes are available on form, tree, kanban and gantt views


## Calender Views
```
calender view provides timeline/schedule view for the data

calender tag
    attribute
        string
        date_start
        date_stop
        date_delay
        day_length
        color
        mode
```
## Gantt view
```
provides timelien view for the data, Generally it can be used to display project tasks and resource allocation

gantt tag
    attribute
        string
        date_start
        date_stop
        date_delay
        day_length
        color
        mode

level tag
    object
    link
    domain

```
## Drag and Drop

## Button
```
button tag
    attribute
        @type
            workflow
            object
            action
        @special
            cancel: indicate that the popup should be closed without performing any RPC call or action resolution
        @name
        @confirm
        @string
        @icon
        @states, @attrs, @invisible
        @default_focus
```
## Label
add a simple label using the string attribute as caption

## Newline
force a return to the line even if all the columns of the view are not filled in


## Inheritance in Views
when you create and inherit objects in some custom or specific modules, it is better to inherit from an existing view  
to add/modify/delete some fields and preserve the others

## Menus 
```
menus are records in the "ir.ui.menu" table, In order to create a new menu entry, you can directly create a record using  
the "record" tag

menuitem tag
    attribute
        id: xml identifier of the munu item , mandatory field
        name: the menu name that will be displayed in the client
        action: specifies the identifier of the attached action defined in the action table
        icon: 
        groups: specifies which group of user can see the menu item
        sequence: used to sort the menu item in the menu, the higher the sequence number, the downer the menu item
        parent
```
## Actions
```
the actions define the behavior of the system in response to the actions of the users; login, double click, click

simple action
    window
    report
    execute
    group

``` 

## Security 
```

user: a person identified by its login and password, Note that all employees of a company are not necessarily OpenERP
users, an user is somebody who access the application
group: a group of users that has some access rights, A group gives its access rights to the users that belong to the group
security rule: a rule that defines the access rights a given group grants to its user, Security rules are attached to a 
given resource


security rules are attached to groups, Users are assigned to several groups, this gives users the rights that are attached to  
their groups, therefore controlling user roles is done by managing user groups and adding or modifying security rules attached to those groups

```

### Security rule
```
types
    access rights are global rights on an object
    record rules are records access filter
    fields access right
    workflow transition rules are operations rights
```
