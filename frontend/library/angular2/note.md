##  Component
##  Directive
##  Service
##  Router  


## Binding 
    one-way
    two-way

### Template expression
the material between the braces is a template expression that Angular first evaluates and then converts to a string.

Angular evaluates all expressions in double curly braces,  
converts the expression results to strings, and concatenates  
them with neighboring literal strings. Finally, it assigns   
this composite interpolated result to an element or directive property.


A template expression produces a value. Angular executes the expression   
and assigns it to a property of a binding target; the target might be an  
HTML element, a component, or a directive.


1. The most common property binding sets an element property to a component property value. <img [src]="heroImageUrl">
2. setting a property of a directive: <div [ngClass]="classes">[ngClass] binding to the classes property</div>
3. another is setting the model property of a custom component (a great way for parent and child components to communicate):
<hero-detail [hero]="currentHero"></hero-detail>

People often describe property binding as one-way data binding because it flows a value in one direction
from a component’s data property into a target element property.
We cannot use property binding to pull values out of the target element. We can't bind to a property of the target element to read it. We can only set it.


Element properties may be the more common targets, but Angular looks first to see if the name is a property of a known directive
If we forget the brackets, Angular treats the string as a constant and initializes the target property with that string

### Template statement

<button (click)="onSave()">Save</button>  calling the component's onSave() method whenever a click occurs 
Event binding syntax consists of a target event within parentheses on the left of an equal sign, and a quoted template statement on the right.


####  Directive
A directive is a class with directive metadata. In TypeScript we'd apply the @Directive decorator to attach metadata to the class

A component is a directive-with-a-template and the @Component decorator is actually a @Directive decorator extended with template-oriented features.

Our Angular templates are dynamic. When Angular renders them, it transforms the DOM according to the instructions given by a directive.

A directive is a class with directive metadata
 In TypeScript we'd apply the @Directive decorator to attach metadata to the class

There are two other kinds of directives as well that we call "structural" and "attribute" directives.

structural: *ngFor *ngIf ngSwitch ngStyle ngClass

#### Data binding 
{{obj.attr}} --> evaluated to string : Component to DOM (one way)
[property]="<expression>"  --> set target's property: Component to Component|DOM (one way)
(event)="<statement>" --> call component function : DOM to Component 
[(ng-model)]="property" --> DOM with Component (two way)

#### Metadata
Metadata tells Angular how to process a class.
@Component accept a metadata which describe property of component

#### Module 
A typical module is a cohesive block of code dedicated to a single purpose. A module exports something of value in that code, typically one thing such as a class. 


### Component
A class has defined property and function tho generate a view with template 


### Template
A template is a form of HTML that tells Angular how to render the Component.


### @Component

@Component function takes the configuration object and turns it into metadata that it attaches to the component class definition. Angular discovers this metadata at runtime and thus knows how to do "the right thing".

Here we see a few of the possible @Component configuration options:

1.selector - a css selector that tells Angular to create and insert an instance of this component where it finds a <hero-list> tag in parent HTML. If the template of the application shell (a Component) contained
    <hero-list></hero-list>
Angular inserts an instance of the HeroListComponent view between those tags.
2. directives - an array of the Components or Directives that this template requires
3. providers - an array of dependency injection providers for services that the component requires
4. The template, metadata, and component together describe the view.



#### Service 
"Service" is a broad category encompassing any value, function or feature that our application needs.


#### Dependence injection
A component's job is to enable the user experience and nothing more. It mediates between the view (rendered by the template) and the application logic (which often includes some notion of a "model"). A good component presents properties and methods for data binding. It delegates everything non-trivial to services
angular factor our application logic into services and make those services available to components through dependency injection.
Angular can tell which services a component needs by looking at the types of its constructor parameters


dependency injection is wired into the framework and used everywhere.

the Injector is the main mechanism.
an injector maintains a container of service instances that it created.
an injector can create a new service instance using a provider.
a provider is a recipe for creating a service.

we register providers with injectors.
