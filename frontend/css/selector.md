## selector

|名称|例子|范围|
|:--:|:--:|:--:|
|.class |.intro| 类选择器|
|#id | #firstname| id选择器|  
|* | *| 所有元素|
|element|p|选择所有p元素|
|element,element|div, p|选择所有div元素和所有p元素|
|element element|div p|选择所有div元素内部的所有p元素|
|element>element|div>p|选择父元素为div的所有p元素|
|element+element|di+p|选取紧接在div元素之后的所有p元素|
|[attribute]|[target]|选取所有带target属性的元素|
|[attribute=value]|[target=_blank]|选取所有target="_blank"的元素|
|[attribute~=value]|[title~=flower]|选取所有title中包含"flower"的所有元素|
|```attribute|=value]```|```[lang=|en]```|选取lang属性已"en"开头的所有元素|
|attribute^=value|a[src^="https"]|选取src属性以"https"开头的元素|
|attribute$=value|a[src$=".pdf"]|选取src属性以".pdf"结尾的元素|
|attribute*=value|a[src*="abc"]|选取src属性包含"abc"子串的元素|
|:link|a:link|伪类选择器, 选取所有未被访问的链接|
|:visited|a:visited|伪类选择器, 选取所有已被访问的链接|
|:active|a:active|伪类选择器, 选取所有活动的链接|
|:hover|a:hover|选取鼠标指针在其上的链接|
|:focus|input:focus|选取活的焦点的input元素|
|:first-letter|p:first-letter|伪元素选择器, 选取每个p元素的首字母|
|:first-line|p:first-line|伪元素选择器, 选取每个p元素的首行|
|:first-child|p:first-child|伪元素选择器, 选取每个p元素的第一个子元素|
|:before|p:before|伪元素选择器, 在每个p元素的内容之前插入内容|
|:after|p:after|伪元素选择器, 在每个p元素的内容之后插入内容|
|element1~element2|p~ul|选择前面有p元素的每个ul元素|
|:root|:root|选取文档的根元素|
|:empty|p:empty|选取没有子元素的每个p元素|
|:target|#news:target|选取当前活动的#news元素|
|:enabled|input:enabled|选取启用的input元素|
|:disabled|input:disabled|选取禁用的input元素|
|:checked|input:checked|选取每个被选中的input元素|
|:not(selector)|:not(p)|选取非p元素的每个元素|
|::selection|::selection|选取被用户选取的元素部分|





