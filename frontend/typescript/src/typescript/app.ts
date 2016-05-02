///<reference path="require.d.ts" />
///<reference path="jquery.d.ts" />
import {f1} from "./test";
import {Person} from "./person";
requirejs.config({
    baseUrl: 'js',
    paths: {
        // the left side is the module ID,
        // the right side is the path to
        // the jQuery file, relative to baseUrl.
        // Also, the path should NOT include
        // the '.js' file extension. This example
        // is using jQuery 1.9.0 located at
        // js/lib/jquery-1.9.0.js, relative to
        // the HTML page.
        jquery: 'jquery-2.2.3',
//        test: 'test',
    }
});

require(['jquery'], function ($) {
    $(document).ready(() => {
        f1();
        var person = new Person()
        console.log(person.name)
        console.log('Your code executes after jQuery has been loaded.');
    });
});



