## 安装使用
```
gem install sass
sass test.scss test.css //编译

编译参数
　　* nested：嵌套缩进的css代码，它是默认值。
　　* expanded：没有缩进的、扩展的css代码。
　　* compact：简洁格式的css代码。
　　* compressed：压缩后的css代码。
sass --style compressed test.sass test.css

自动编译
　　sass --watch input.scss:output.css　// watch a file
　　sass --watch app/sass:public/stylesheets　// watch a directory
```
## 语法
```
注释: /* */ 
单行注释: //
行位： ';' 
变量
　　$blue : #1875e7;　

　　div {
　　　color : $blue;
　　}

　  $side : left;
　　.rounded {
　　　　border-#{$side}-radius: 5px; //在字符串中使用变量
　　}

计算
　　body {
　　　　margin: (14px/2);
　　　　top: 50px + 100px;
　　　　right: $var * 10%;
　　}
继承
    .class1 {
　　　　border: 1px solid #ddd;
　　}

  　.class2 {
　　　　@extend .class1;
　　　　font-size:120%;
　　}

Mixin
    $primary-color: #A3A4A5;
    @mixin <mixin_name> { //不带参数
        margin-left: auto;
    }

    div {
        @include <mixin_name>; //mixin name
        color: $primary-color;
    }

    @mixin size($width, $height: 100px){ //参数默认值
        width: $width;
        height: $height;
    }

    .rectangle {
        @include size(100px, 100px);
    }

Import
    @import 'path/foo.scss';

If 
　　@if lightness($color) > 30% {
　　　　background-color: #000;
　　} @else {
　　　　background-color: #fff;
　　}
Functions
    内置函数
        width: round(10.25px);
        background-color: fade_out(#000000, 0.25) -->  rgba(0, 0, 0, 0.25)

    自定义函数
        @function calculate-percentage($target-size, $parent-size){
            @return $target-size / $parent-size * 100%;
        }
        .main-content {
            width: calculate-percentage(600px, 960px);
        }

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

