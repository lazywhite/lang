## Tips
1. "React" recommends using "inline styles", you need to use "camelCase" syntax
2. Javascript expressions can be used inside "JSX", you need to wrap it with "{}"
3. when you want to add custom attribute, you need to use "data-" prefix
4. If you want to return more elements, you need to wrap it with one container element
5. React use "JSX" for templating instead of regular "Javascript", because "JSX" is faster, type-safe, easy-to-write templates
6. HTML tags are always using lowercase tag names, while React components starts with Uppercase
7. you should use "className" and "htmlFor" as XML attribute names instead of "class" and "for"


## Glossary
```  
form
router
ajax
    this.serverRequest = $.get(this.props.source, function (result) {})
flux
table
props
    defaultProps
state
component
    api
        setState()
        replaceState()
        setProps()
        replaceProps()
        forceUpdate()
        findDOMNode()
        isMounted()

event
expression
    {}

virtual DOM: javascript object, faster than "regular DOM"

lifecycle methods
    componentWillMount()
    componentDidMount()
    componentWillReceiveProps()
    shouldComponentUpdate()
    componentWillUpdate()
    componentDidUpdate()
    componentWillUnmount()

ref: is used to return a reference to your element
    <input ref="myInput" />
    ReactDOM.findDOMNode(this.refs.myInput)
```
