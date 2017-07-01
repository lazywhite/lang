/*
 * OptionalTest.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

package basic;
import java.util.Optional;

/*
    Optional
        .empty(): 返回一个空的Optional对象
        .equals(Object obj)
        .filter(Predicate<? super T> predicate): if value is present and value match a given Predicate, it return an Optional with value, otherwise empty Optional
        .flatMap(): if value is present, apply the map function to it, return result, otherwise return empty Optional
        .get(): return present value or NoSuchElementException
        ifPresent(): if value is present, invoke the specified consumer with the value, otherwise does nothing
        .isPresent():  boolean
        .map(): if value is present, apply map method, if result is not null, return an Optional describe the result
        .of(): return an Optional with non-null value
        .ofNullAble(): return an Optional with non-null value or an empty Optional
        .orElse(T other): return value if present else  other
        .orElseGet(Supplier<? extends T> other): return value if present, otherwise invoke other and return result of that invocation
        .orElesThrow(exceptionSupplier): return value if present, otherwise throw an exception produced  by supplier
        .toString()
 */

class Request{
    public String getParameter(String name){
        if("key".equals(name)){
            return "value";
        }
        return null;
    }
}

public class OptionalTest {
     
    public static void main(String[] args){
        Request request = new Request();
        Optional<String> str1 = Optional.ofNullable(request.getParameter("key"));
        System.out.println(str1.orElse("default"));
        Optional<String> str2 = Optional.ofNullable(request.getParameter("key2"));
        System.out.println(str2.orElse("default"));

        Optional<String> id = Optional.ofNullable(request.getParameter("id"));
        if(!id.isPresent()){
            String idValue = id.get();
            // do sql
        } else {
            System.out.println("id not provided, process terminated");
//          System.exit(10);
        }
        //Optional<String> age = Optional.of(request.getParameter("key3"));  // of不接受null值, 会抛出NullPointerException
    }
}

