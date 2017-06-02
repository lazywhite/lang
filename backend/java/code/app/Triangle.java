/*
 * Triangle.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    public static boolean check(int[] arr){
        if(arr[0] + arr[1] > arr[2]){
            System.out.println("可以构成三角形");
            return true;
        }
        return false;
    }
    /*检查是否是等腰三角形*/
    public static void checkDY(int[] arr){
        if(arr[0] == arr[1] || arr[1] == arr[2]){
            System.out.println("是等腰三角形");
        }else{
            System.out.println("不是等腰三角形");
        }
    }
    public static void checkAngle(int[] arr){
        double r = Math.pow(arr[0], 2) + Math.pow(arr[1], 2) - Math.pow(arr[2], 2);
        String str;
        if(r == 0){
            System.out.println("是直角三角形");
        }else if (r > 0){
            System.out.println("是钝角三角形");
        }else{
            System.out.println("是角三角形");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        System.out.println("请输入三角形的三条边长");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if(check(arr)){
            checkDY(arr);
            checkAngle(arr);
        }
    }
}

