/*
 * TestConstructor.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

public class TestConstructor {
    int w, x, y, z;
    public TestConstructor(int a, int b){
        x=a;
        y=b;
    }
    public TestConstructor(int a, int b, int c, int d){
//                x=a;y=b;
//        TestConstructor(a, b);
        this(a, b);
        z=c;
        w=d;
    }
}

