type Reader interface{
    Read() bool
}
type Writer interface{
    Write() bool
}
type Closer interface{
    Close() bool
}


type ReaderWriter{
    Reader
    Writer
}
/*
有了embedding，无需像下面一样声明一个interface了
type ReaderWriter{
    Read() bool
    Write() bool
}
*/

type ReaderCloser interface{
    Reader
    Closer
}
type WriterCloser interface{
    Writer
    Closer
}

type ReaderWriterCloser interface{
    //因为两个interface都包含close()， 因此会报"Duplicate method: ", go1.14修复了这个错误, 现在取method合集
    ReaderCloser
    WriterCloser
}
