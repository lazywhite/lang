## Keyword
```
bean
    definition
        xml
            class
            name
            constructor-arg
            properties
            autowiring mode
            lazy-initialization mode 
            initialization()
            destruction()
            init-method
            destroy-method
            inheriance
            template

    scope
        singleton
        prototype
        request
        session
        global-session
IoC

annotation
    multi annotation has no order
    can leave blank line between annotation and class definition
```

```
@PathVariable - must be placed in the endpoint uri and access the query parameter value from the request
@RequestParam - must be passed as method parameter (optional based on the required property)
 http://localhost:8080/employee/call/7865467

 @RequestMapping(value=“/call/{callId}", method = RequestMethod.GET)
 public List<Calls> getAgentCallById(
            @PathVariable(“callId") int callId,
            @RequestParam(value = “status", required = false) String callStatus) {

    }

http://localhost:8080/app/call/7865467?status=Cancelled

@RequestMapping(value=“/call/{callId}", method = RequestMethod.GET)
public List<Calls> getAgentCallById(
            @PathVariable(“callId") int callId,
            @RequestParam(value = “status", required = true) String callStatus) {

}
```
```
return new ModelAndView("welcomePage","WelcomeMessage","Welcome!");
welcomePage.jsp
    Hello Stranger! ${WelcomeMessage}

MyBean bean = new MyBean();
bean.setName("Mike!");
bean.setMessage("Meow!");

return new ModelAndView("welcomePage","model",bean);

Hello ${model.name}! {model.message} /
```
```
ModelAndView
```
