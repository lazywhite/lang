package game.start;

import game.entity.Bee;
import game.entity.Bullet;
import game.entity.Minion;
import game.entity.MinionBullet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by white on 17/6/8.
 */
public class GamePanel extends JPanel {


    public void paint(Graphics g){

        //绘制背景
        g.drawImage(GameConfig.background, 0, 0, null);
        //绘制飞机
        g.drawImage(GameConfig.plane.getImage(), GameConfig.plane.getX(), GameConfig.plane.getY(), null);
        //绘制子弹
        if(GameConfig.bullets.size()> 0){
            for(Bullet b: GameConfig.bullets) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), null);
            }
        }
        if(GameConfig.minions.size() > 0){
            for(int i = 0; i<GameConfig.minions.size(); i++){
                Minion t1 = GameConfig.minions.get(i);
                g.drawImage(t1.getImage(), t1.getX(), t1.getY(), null);
            }
        }
        if(GameConfig.minions.size() > 0){
            for(int i = 0; i<GameConfig.bees.size(); i++){
                Bee b = GameConfig.bees.get(i);
                g.drawImage(b.getImage(), b.getX(), b.getY(), null);
            }
        }
        //绘制敌人子弹
        if(GameConfig.minionBullets.size()>0){
            for(int i=0;i<GameConfig.minionBullets.size();i++){
                MinionBullet m = GameConfig.minionBullets.get(i);
                g.drawImage(m.getImage(), m.getX(), m.getY(), null);
            }
        }
        //绘制分数
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monaco", Font.BOLD, 20));
        g.drawString("分数: " + GameConfig.SCORE, 10, 30);
        g.drawString("生命: " + GameConfig.plane.getLife(), 10, 60);
    }

}
