define(["require", "exports"], function (require, exports) {
    "use strict";
    var Person = (function () {
        function Person() {
            this.name = 'David';
        }
        return Person;
    }());
    exports.Person = Person;
});
