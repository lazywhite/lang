define(["require", "exports", "./test", "./person"], function (require, exports, test_1, person_1) {
    "use strict";
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
            jquery: 'jquery-2.2.3'
        }
    });
    require(['jquery'], function ($) {
        $(document).ready(function () {
            test_1.f1();
            var person = new person_1.Person();
            console.log(person.name);
            console.log('Your code executes after jQuery has been loaded.');
        });
    });
});
