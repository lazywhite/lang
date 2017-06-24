package app;
/*
 * BallGame.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
/*
 * 双色球游戏
 *
 * red ball in ["01", "02"......"33"]
 * blue ball in ["01", ...."16"]
 * 
 * select 6 red ball, 1 blue ball
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class BallGame {
    public static final ArrayList<String> redArr = new ArrayList<>();
    public static final ArrayList<String> blueArr = new ArrayList<>();
    public static final ArrayList<String> result = new ArrayList<>();
    public static final Random r = new Random();

    static{
        /*初始化球池*/
        for(int i=1;i<=33;i++){
            String str = Integer.toString(i);
            if(str.length() ==1){
                str = "0" + str;
            }
            redArr.add(str);
        }
        for(int i=1;i<=16;i++){
            String str = Integer.toString(i);
            if(str.length() ==1){
                str = "0" + str;
            }
            blueArr.add(str);
        }

    }

    public static void main(String[] args){

        getRedBall();
        getBlueBall();
        System.out.println(result);
    }

    public static void  getRedBall(){
        for(int i=0;i<6;i++){
            int index = r.nextInt(redArr.size());
            String ball = redArr.get(index);
            result.add(ball);
            redArr.remove(index);
        }

    }
    public static void getBlueBall(){
        int index = r.nextInt(blueArr.size());
        String ball = blueArr.get(index);
        result.add(ball);
    }
}

