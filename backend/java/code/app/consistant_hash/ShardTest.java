import java.util.*;
/*
 * ShardTest.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air>
 *
 * Distributed under terms of the MIT license.
 */

public class ShardTest {
     
    public static void main(String[] args){
        Server s1 = new Server("server01", "192.168.1.10", 3306);
        Server s2 = new Server("server02", "192.168.1.11", 3306);
        Server s3 = new Server("server03", "192.168.1.12", 3306);

        List<Server> list = new ArrayList<>(Arrays.asList(s1, s2, s3));

        Shard<Server> shard = new Shard(list);

        System.out.println(shard.getShardInfo("t1"));
        System.out.println(shard.getShardInfo("xxt"));
    }
}

