/*
* Copyright (C) 2017 white <white@Whites-Mac-Air.local>
*
* Distributed under terms of the MIT license.
*/
var fs = require("fs");


function getResult(args){
    result = {};
    var html = fs.readFileSync(args.file, "utf-8");
    var mt = html.match(/\s*\$scope\.(scenarios[^\n]*)/m);
    var data = "var " + mt[1];
    eval(data);
    for(var i=0;i<scenarios.length;i++){
        var tabName = scenarios[i].met;
        var rows = scenarios[i].table.rows;
        var index = getSuccessColumnIndex(scenarios[i].table.cols);
        for(var j=0;j<rows.length;j++){
            if(rows[j][0] === "total"){
                var percentNum = parseFloat(rows[j][index].split("%")[0]);
                if(isNaN(percentNum)){
                    percentNum = 0
                }
                result[tabName] = percentNum;
            }
        }
    }
    return result;
}

function getMin(result){
    var min = 1000;
    for(var x in result){
        min = result[x] > min?min:result[x];
    }
    return min;
}


function getSuccessColumnIndex(data){
    /*
    * 获取th为"Success"的index
    */
    for(var i=0;i<data.length;i++){
        if(data[i] === "Success"){
            return i;
        }
    }
}

function parseArgs(){
    var ArgumentParser = require('argparse').ArgumentParser;
    var parser = new ArgumentParser({
        version: '0.0.1',
        addHelp:true,
        description: 'parse cli args'
    });
    parser.addArgument(
        [ '-d', '--detail' ],
        {
            help: 'print detail message',
            defaultValue: false,
            action: "storeTrue"
        }
    );
    parser.addArgument(
        [ '-f', '--file' ],
        {
            help: 'html file to parse',
            required: true
        }
    );
    return parser.parseArgs();
}

(function(){
    var args = parseArgs();
    result = getResult(args);
    if(args.detail){
        console.log(result);
    }
    console.log(getMin(result) + "%");
})();

