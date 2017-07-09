/*
 * List.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
package app;

import java.io.*;

public class ListDir {

    public static void print(File f, int level){
        //格式化文件名字前的填充字符
        StringBuilder sbd = new StringBuilder();
        for(int i=0;i<level-2;i++){
            sbd.append("        ");
        }
        if(level > 1){
            sbd.append("|------ ");
        }

        System.out.println(sbd.toString() + f.getName()); //不管是目录或普通文件, 打印其名字
        if(f.isDirectory()){
            level++;
            File[] files = f.listFiles();
            for(File file: files){
                print(file, level);
            }
        }

    }
    public static void main(String[] args){
        String filePath = "/Users/white/local";
//        String filePath = ".";
        File file = new File(filePath);
        print(file, 1);
    }
}

