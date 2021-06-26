# Installation
## install protobuf compiler
```
git clone https://github.com/google/protobuf.git
cd protobuf/
./autogen.sh
./configure --prefix=/usr
make install
```
## install python library
cd protobuf/python
python setup.py build
python setup.py test
python setup.py install

## translate proto filetype to python module
protoc --python_out=/path/to/site-package addressbook.proto  


# Python tutorial

[Python tutorial](https://developers.google.com/protocol-buffers/docs/pythontutorial)

#Language guide

message <MessageName>{
<field rule> <data type> <field name> = <unique numbered tag> [ default = <v> ];
//comment
}

field rule:
    required 
    optional
    repeated

data type:
    enum
    message
    scalar<int, string>

## enum:
You can define aliases by assigning the same value to different enum constants.
option allow_alias = true;
```
    enum Corpus {
    UNIVERSAL = 0;
    WEB = 1;
    IMAGES = 2;
    LOCAL = 3;
    NEWS = 4;
    PRODUCTS = 5;
    VIDEO = 6;
  }
    
```

## import 

```
import "myproject/other_proto.proto"
```


By default you can only use definitions from directly imported .proto files. However, sometimes you may need to move a .proto file to a new location. Instead of moving the .proto file directly and updating all the call sites in a single change, now you can put a dummy .proto file in the old location to forward all the imports to the new location using the import public notion. import public dependencies can be transitively relied upon by anyone importing the proto containing the import public statement.


## Nested types
You can define and use message types inside other message types

If you want to reuse this message type outside its parent message type, you refer to it as <Parent>.<Type>


## Extensions

Extensions let you declare that a range of field numbers in a message are available for third-party extensions. Other people can then declare new fields for your message type with those numeric tags in their own .proto files without having to edit the original file.

```
message Foo {
  // ...
  extensions 100 to <number|max>;
}

extend Foo {
  optional int32 bar = 126;
}
```
## oneof
If you have a message with many optional fields and where at most one field will be set at the same time, you can enforce this behavior and save memory by using the oneof feature.


## Maps
map<key_type, value_type> map_field = N;



## Packages
prevent name clashes


## Options
 Options do not change the overall meaning of a declaration, but may affect the way it is handled in a particular context. 


## gRPC

[gRPC arch](http://www.grpc.io/img/grpc_concept_diagram_00.png)
