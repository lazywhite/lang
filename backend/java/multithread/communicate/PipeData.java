/*
 * PipeData.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 通过管道字节流进行线程通信
 */

import java.io.*;
class WriteData{
    public void writeData(PipedOutputStream out){
        try{
            System.out.println("write: ");
            for(int i=1;i<300;i++){
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class ReadData{
    public void readData(PipedInputStream input){
        try{
            System.out.println("read: " );
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Athread extends Thread{
    private WriteData write;
    private PipedOutputStream out;

    public Athread(WriteData write, PipedOutputStream out){
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run(){
        write.writeData(out);
    }
}

class Bthread extends Thread{
    private ReadData read;
    private PipedInputStream input;

    public Bthread(ReadData read, PipedInputStream input){
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run(){
        read.readData(input);
    }
}
public class PipeData {
     
    public static void main(String[] args){
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
            out.connect(in);

            Athread a = new Athread(writeData, out);
            a.start();
            Thread.sleep(2000);
            Bthread b = new Bthread(readData, in);
            b.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

