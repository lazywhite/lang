## Topic
```
transparent background
multiple background img
rgba color: rgb color with opacity 
gradient color: 
    linear-gradient(<direction|angel>, start, stop01, [stop02] ...)
    radio-gradient()

box-shadow
```
## Transform
transform: 2D, 3D(transform: method(arg))
  
```
translate(x, y): move element from  origin position
rotate(-20deg)
scale(multiple width, multiple height)
    
matrix() method combines all the 2D transform methods into one.
``` 
  
## Transition
change property value smoothly over a given period time
  
```
transition: <property 1> <period> [<property 2> <period>]

transition-timing-function: specify the speed curve of transition
transition-delay: specify a delay for the effect start


transition with transform:  transition: transform 2s;
```
   
## Animation
```
@keyframes <animation name> {
   percent: { <property value>}
}
    
<element> {
   animation-name: <name>
   animation-duration: <period>
   animation-iteration-count: <times|infinite>
   animation-fill-mode: <final state> 
}
```
## Media 
    @media rule, introduced in CSS2, made it possible to define different style rules for different media types.


