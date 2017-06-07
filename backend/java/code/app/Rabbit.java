/*
 * Rabbit.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 1. 兔子需要3个月成熟
 * 2. 初始有4只兔子， 每两个成熟的兔子每个月可生一个兔子
 * 3. n个月后共有多少兔子
 *
 *
 */

public class Rabbit {
    public static int getRabbitNum(int month){
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        int start = 4;
        int canBorn = 4;
        int total = 4;
        while(month >0){
            canBorn += num3;
            num3 = num2;
            num2 = num1;
            num1 = canBorn / 2;
            total += num1;//总数为已有的加新出生的
            month--;
        }

        return total;
    }
    public static void main(String[] args){
        System.out.println(getRabbitNum(10));
    }
}

