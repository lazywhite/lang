## Introduction
AngularJS extends HTML with new attributes(ng-directives).
AngularJS extends HTML attributes with Directives, and binds data to HTML with Expressions.
The ng-app directive defines an AngularJS application.
The ng-model directive binds the value of HTML controls (input, select, textarea) to application data.
The ng-bind directive binds application data to the HTML view

AngularJS modules define AngularJS applications.
AngularJS controllers control AngularJS applications.

AngularJS expressions can be written inside double braces: {{ expression }}.
AngularJS expressions can also be written inside a directive: ng-bind="expression".

AngularJS keep all functions local to the module 

a service is a function, or object, that is available for, and limited to, your AngularJS application.


## Angular vs Javascript
Like JavaScript expressions, AngularJS expressions can contain literals, operators, and variables.
Unlike JavaScript expressions, AngularJS expressions can be written inside HTML.
AngularJS expressions do not support conditionals, loops, and exceptions, while JavaScript expressions do.
AngularJS expressions support filters, while JavaScript expressions do not.


## Tips
Module and Controllers in Files


## Directives
To invoke the new directive, make an HTML element with the same tag name as the new directive.
When naming a directive, you must use a camel case name, w3TestDirective, but when invoking it, you must use - separated name, w3-test-directive:

You can invoke a directive by using:
    Element name
    Attribute
    Class
    Comment

You can restrict your directives to only be invoked by some of the methods.


ng-init
ng-model
ng-bind
ng-bind-html
ng-show
ng-if
ng-repeate
    $index
    $odd
    $even
    $last
    $first
    $middle
ng-cloak
ng-copy #trigger when copy event


## Concept
filter
scope
http
dependent module
directive

## directives
ng-repeate
ng-options
ng-disabled
<p ng-show="hour > 12">{{}}</p>
ng-hide

## Events

ng-blur
ng-change
ng-click
ng-copy
ng-cut
ng-dblclick
ng-focus
ng-keydown
ng-keypress
ng-keyup
ng-mousedown
ng-mouseenter
ng-mouseleave
ng-mousemove
ng-mouseover
ng-mouseup
ng-paste


## Service
In AngularJS, a service is a function, or object, that is available for, and limited to, your AngularJS application.
AngularJS constantly supervise your application, and for it to handle changes and events properly
$location.absUrl()
$http({
  method: 'GET',
  url: '/someUrl'
}).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });
$timeout(function(){})
$interval(function(){})

## self-defined service
app.service('hexafy', function() {
    this.myFunc = function (x) {
        return x.toString(16);
    }
});


## Animation
angular-animate.js

## Include other file

## Service

## Function
angular.bootstrap
angular.fromJson(json)
angular.foreach
angular.element(html_element)
angular.noop() ## like python pass

## Dependence injection
## Route
### RootRouter
### ChildRouter



