/*
 * TestHello.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import org.junit.*;
import static junit.framework.Assert.*;
import com.local.test.Main;


public class TestHello {
    @Test
    public void testHello(){
        assertEquals(Main.doSum(1, 2), 3);
    }
}

