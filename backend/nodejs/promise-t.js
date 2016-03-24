var Promise = require('promise');

var promise = new Promise(function (resolve, reject) {
    get('http://www.baidu.com', function (err, res) {
        if (err){console.log(err); reject(err)}
        else resolve(res);
        });
});


console.log('it\'s here')
