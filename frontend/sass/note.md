## Common
```
comment: /* */ 
';' as line end;
$primary-color: #A3A4A5; //variable

@mixin <mixin_name> {
    margin-left: auto;
}

div {
    @include <mixin_name>; //mixin name
    color: $primary-color;
}

@mixin size($width, $height){
    width: $width;
    height: $height;
}

.rectangle {
@include size(100px, 100px);
}
```
## Functions
### builtin function
```
width: round(10.25px);
background-color: fade_out(#000000, 0.25) -->  rgba(0, 0, 0, 0.25)
```
### self-defined function
```
@function calculate-percentage($target-size, $parent-size){
    @return $target-size / $parent-size * 100%;
    }

$main-content: calculate-percentage(600px, 960px);

.main-content {
    width: $main-content;
}

```
## Extends

```
.display {
    @include size(5em, 5em);
    border: 5px solid $secondary-color;
}

.display-success {
    @extend .display;
    border-color: #22df56;
}

/* Compiles to: */
.display, .display-success {
  width: 5em;
  height: 5em;
  border: 5px solid #51527F;
}

.display-success {
  border-color: #22df56;
}

```
## Nesting
```

ul {
    list-style-type: none;
    margin-top: 2em;

    li {
        background-color: red;

        &:hover {   //& is replaced by it's parent
          background-color: blue;
        }

        a {
          color: white;
        }
    }
}

/* Compiles to: */

ul {
  list-style-type: none;
  margin-top: 2em;
}

ul li {
  background-color: red;
}

ul li:hover {
  background-color: blue;
}

ul li a {
  color: white;
}
```

## Partials and Imports
```
_reset.css
@import 'reset';
```

## Placeholder
```
%content-window {
  font-size: 14px;
  padding: 10px;
  color: #000;
  border-radius: 4px;
}

.message-window {
  @extend %content-window;
  background-color: #0000ff;
}

/* Compiles to: */

.message-window {
  font-size: 14px;
  padding: 10px;
  color: #000;
  border-radius: 4px;
}

.message-window {
  background-color: #0000ff;
}

```

