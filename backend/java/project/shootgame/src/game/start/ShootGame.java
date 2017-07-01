package game.start;

import game.entity.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import java.util.*;
import java.util.Timer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by white on 17/6/8.
 */
public class ShootGame {

    static{

        try {
            GameConfig.background = ImageIO.read(new File("./images/background.png"));
            GameConfig.start = ImageIO.read(new File("./images/start.png"));
            GameConfig.pause = ImageIO.read(new File("./images/pause.png"));
            GameConfig.gameover = ImageIO.read(new File("./images/gameover.png"));
            GameConfig.plane = new Plane();
            GameConfig.gp = new GamePanel();
            GameConfig.bullets = new ArrayList<Bullet>();
            GameConfig.minionBullets = new ArrayList<MinionBullet>();
            GameConfig.minions = new ArrayList<Minion>();
            GameConfig.bees = new ArrayList<Bee>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShootGame game = new ShootGame();
        JFrame frame = new JFrame();
        GameConfig.plane.setDoubleFire(1);
        frame.add(GameConfig.gp);
//        frame.setBounds(400, 100, 400, 600);
        frame.setSize(GameConfig.WIDTH, GameConfig.HEIGHT);
        frame.setLocationRelativeTo(null);//设置居中显示
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        action();
    }

    public static void action() {
        Timer timer = new Timer();
        //更新飞机图片
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameConfig.plane.changeImage();
            }
        }, 10, 100);

        //生成攻击子弹
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Bullet> bt = GameConfig.plane.shoot();
                GameConfig.bullets.addAll(bt);
                for(int i=0;i<GameConfig.bullets.size();i++){
                    Bullet b = GameConfig.bullets.get(i);
                    //清理越界子弹
                    if(b.outOfBounds()){
                        GameConfig.bullets.remove(b);
                    }
                }
            }
        }, 10, 500);

        //移动子弹
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Bullet b: GameConfig.bullets){
                    b.move();
                }
            }
        }, 10, 10);

        //生成敌人子弹
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i=0;i<GameConfig.minions.size();i++){
                    Minion m = GameConfig.minions.get(i);

                    List<MinionBullet> mb = m.shoot();
                    GameConfig.minionBullets.addAll(mb);
                }
                for(int i=0;i<GameConfig.minionBullets.size();i++){
                    MinionBullet b = GameConfig.minionBullets.get(i);
                    System.out.println(b.getY());
                    //清理越界子弹
                    if(b.outOfBounds()){
                        GameConfig.minionBullets.remove(b);
                    }
                }
            }
        }, 10, 1000);
        //移动敌人子弹
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i=0;i<GameConfig.minionBullets.size();i++){
                    MinionBullet b = GameConfig.minionBullets.get(i);
                    b.move();
                }
//                System.out.println(GameConfig.minionBullets.size());
            }
        }, 10, 30);

        //生成敌机
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random r = new Random();
                for (int i = 0; i < r.nextInt(3); i++) {
                    GameConfig.minions.add(new Minion());
                }
                for (int i = 0; i < GameConfig.minions.size(); i++) {
                    Minion m = GameConfig.minions.get(i);
                    if (m.outOfBounds()) {
                        GameConfig.minions.remove(m);
                    }
                }
//                System.out.println(GameConfig.minions.size());
            }
        }, 1000, 1000);

        //移动敌机
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i<GameConfig.minions.size(); i++){
                    Minion t = GameConfig.minions.get(i) ;
                    t.move();
                }
            }
        }, 2000, 10);
        //生成Bee
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Random r = new Random();
//                int a = r.nextInt(3);
//                if(a == 2){
//                    GameConfig.bees.add(new Bee());
//                    System.out.println("new bee");
//                }
//
//            }
//        }, 1000, 100);
//
//        //移动bee
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                for(int i=0;i<GameConfig.bees.size();i++){
//                    Bee b = GameConfig.bees.get(i);
//                    if(b.outOfBounds()){
//                        GameConfig.bees.remove(b);
//                    }else {
//                        b.move();
//                    }
//                }
//
//            }
//        }, 1000, 10);


        //击中敌机检测
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i=0;i<GameConfig.bullets.size();i++){
                    Bullet b = GameConfig.bullets.get(i);
                    for(int j=0;j<GameConfig.minions.size();j++){
                        Minion m = GameConfig.minions.get(j);
                        if(Math.abs(m.getX()- b.getX()) <= m.getWidth() && Math.abs(m.getY() - b.getY()) <= m.getHeight()){
                            GameConfig.SCORE += m.getScore();
                            GameConfig.minions.remove(m);
                            GameConfig.bullets.remove(b);
                        }
                    }
                }
            }
        }, 100, 50);
        //被击中检测
        timer.schedule(new TimerTask() {
           @Override
           public void run() {
                for(int i=0;i<GameConfig.minionBullets.size();i++){
                    MinionBullet mb = GameConfig.minionBullets.get(i);
                    if(Math.abs(mb.getX() - GameConfig.plane.getWidth()/2 - GameConfig.plane.getX()) <= 30 &&
                        Math.abs(mb.getY() - GameConfig.plane.getHeight()/2 - GameConfig.plane.getY()) <= 30){
                        GameConfig.plane.setLife(GameConfig.plane.getLife() - 1);
                        GameConfig.minionBullets.remove(mb);
                    }
                }
           }
        }, 1000, 30);

        //画布重绘
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameConfig.gp.repaint();
            }
        }, 10, 30);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                GameConfig.plane.moveTo(x, y);
            }
        };
        GameConfig.gp.addMouseMotionListener(mouse);

    }

}
