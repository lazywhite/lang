/*
 * MM.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

public class MM {
    String str = new String("good"); 
    char[] ch = {'a', 'b', 'c'};
    public static void main(String[] args){
        MM m = new MM();
        System.out.println(m.str);
        System.out.println(m.ch);
        m.change1(m.str);
        System.out.println(m.str);
//        m.change(m.str, m.ch);
//        System.out.println(m.str);
//        System.out.println(m.ch);
    }

    public void change1(String str){
        str = "test ok"; 
        System.out.println(str);
    }
    public void change(String str, char[] ch){
        str = "test ok"; 
        ch[0] = 'g';
    }
}

