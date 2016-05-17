## Usage   
```
1. DOM manipulation
2. CSS manipulation
3. Event 
4. Animation
5. ajax
6. utilities
```
  
## Syntax
```
#(select).action()
```
### Selectors
```
element selector
id selector
class selector
attribute selector
pesudo class selector
    $(":button")
    $("input:checked")
    $("tr:even")
pesudo element selecotr
```  
  
### Events
```
click 
dblclick
```  
  
## Effects
```
1. Hide/Show
    hide(), show(), toggle()
    $(selector).<hide|show>(speed,callback);   <speed is int mm: 1000>
2. Fade
    fadeIn(), fadeOut(), fadeToggle(), fadeTo(speed, opacity, callback)
3. Slide
    slideDown(), slideUp(), slideToggle() 
4. Animate
    animate({params}, speed, callback); <params is Object>
    stop(): stop an animation or effect before it is finished
5. Method chaining 
    Chaining allows us to run multiple jQuery methods (on the same element) within a single statement.
    $("#p1").css("color", "red").slideUp(2000).slideDown(2000); 
```  
  
## DOM
```
text() - Sets or returns the text content of selected elements
html() - Sets or returns the content of selected elements (including HTML markup)
val() - Sets or returns the value of form fields

append() - Inserts content at the end of the selected elements
prepend() - Inserts content at the beginning of the selected elements
after() - Inserts content after the selected elements
before() - Inserts content before the selected elements

remove() - Removes the selected element (and its child elements)
empty() - Removes the child elements from the selected element
```

## CSS
```
addClass() - Adds one or more classes to the selected elements
removeClass() - Removes one or more classes from the selected elements
toggleClass() - Toggles between adding/removing classes from the selected elements
css() - Sets or returns the style attribute

width()
height()
innerWidth()
innerHeight()
outerWidth()
outerHeight()
```

## Traversing
### Ancestors
```
parent()
parents()
parentsUntil()
```
### Descendants
```
children() method returns all direct children of the selected element.
find() method returns descendant elements of the selected element, all the way down to the last descendant.
```
### Sibling
```
siblings() method returns all sibling elements of the selected element.
next() method returns the next sibling element of the selected element.
nextAll() method returns all next sibling elements of the selected element.
nextUntil() method returns all next sibling elements between two given arguments.
prev(), prevAll() and prevUntil() methods work just like the methods above but with reverse functionality
```
### Filtering
```
first() method returns the first element of the selected elements.
last() method returns the last element of the selected elements.
eq(index) method returns an element with a specific index number of the selected elements.
filter() method lets you specify a criteria,  Elements that do not match the criteria are removed from the selection, and those that match will be returned
not() method is the opposite of filter().
```
