const events = require('events')

var emitter = new events.EventEmitter();

var testHandler = function(){
    console.log('test event catched')
}

emitter.on('test', testHandler)

emitter.emit('test')

