## Introduction
qweb is the template engine used by the openerp web client, It is an xml-based templating language  
1. it's implemented fully in javascript and rendered in the browser
2. each template file\(xml files\) contains multiple templates 
3. it has special support in openerp web's widget

## Template directives
### Output
```
t-name="name"
t-esc=content
    evaluate, html-escape and output contents
t-escf=content
    similar to "t-esc" but evaluates a "Format" instead of just an expression

t-raw=content
    similar to "t-esc" but not html-escape

t-rawf=content
    Format-based version of "t-raw"

t-att=map
    
t-att-ATTNAME=value
t-attf-ATTNAME=value

```

### 2. Flow Control
```
t-set=name (t-value=value|BODY)
    create a new binding in the template context, if "value" is specified, evaluates it and set it 
    to the specified "name"

t-if=condition

t-foreach=iterable [t-as=name]
t-call=template [BODY]
    calls the specified "template" and returns its result
```

### 3. Template Inheritance and Extension
```
t-extend=template BODY
t-jquery=selector
```


### 4. Escape Hatches/debugging
```
t-log=expression
t-debug
t-js=context BODY
```



## Example
### 1. context

```
{
    "class1": "foo",
    "title": "Random Title",
    "items": [
        { "name": "foo", "tags": {"bar": "baz", "qux": "quux"} },
        { "name": "Lorem", "tags": {
                "ipsum": "dolor",
                "sit": "amet",
                "consectetur": "adipiscing",
                "elit": "Sed",
                "hendrerit": "ullamcorper",
                "ante": "id",
                "vestibulum": "Lorem",
                "ipsum": "dolor",
                "sit": "amet"
            }
        }
    ]
}
```

### 2. template
```
<templates>
  <div t-name="example_template" t-attf-class="base #{cls}">
    <h4 t-if="title"><t t-esc="title"/></h4>
    <ul>
      <li t-foreach="items" t-as="item" t-att-class="item_parity">
        <t t-call="example_template.sub">
          <t t-set="arg" t-value="item_value"/>
        </t>
      </li>
    </ul>
  </div>
  <t t-name="example_template.sub">
    <t t-esc="arg.name"/>
    <dl>
      <t t-foreach="arg.tags" t-as="tag" t-if="tag_index lt 5">
        <dt><t t-esc="tag"/></dt>
        <dd><t t-esc="tag_value"/></dd>
      </t>
    </dl>
  </t>
</templates>
```

### 3. output
```
<div class="base foo">
    <h4>Random Title</h4>
    <ul>
        <li class="even">
            foo
            <dl>
                <dt>bar</dt>
                <dd>baz</dd>
                <dt>qux</dt>
                <dd>quux</dd>
            </dl>
        </li>
        <li class="odd">
            Lorem
            <dl>
                <dt>ipsum</dt>
                <dd>dolor</dd>
                <dt>sit</dt>
                <dd>amet</dd>
                <dt>consectetur</dt>
                <dd>adipiscing</dd>
                <dt>elit</dt>
                <dd>Sed</dd>
                <dt>hendrerit</dt>
                <dd>ullamcorper</dd>
            </dl>
        </li>
    </ul>
</div>
```
