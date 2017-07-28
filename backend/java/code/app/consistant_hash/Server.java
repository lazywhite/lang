/*
 * Server.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

public class Server {
    public String name;
    public String ip;
    public int port;
    public Server(String name, String ip, int port){
        this.name = name;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString(){
        return this.name;
    }

}

