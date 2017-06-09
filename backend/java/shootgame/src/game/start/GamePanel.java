package game.start;

import game.entity.Bullet;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;


/**
 * Created by white on 17/6/8.
 */
public class GamePanel extends JPanel {


    public void paint(Graphics g){
        g.drawImage(GameConfig.background, 0, 0, null);
        g.drawImage(GameConfig.plane.getImage(), GameConfig.plane.getX(), GameConfig.plane.getY(), null);
        if(GameConfig.bullets.size()> 0){
            for(Bullet b: GameConfig.bullets){
                g.drawImage(b.getImage(), b.getX(), b.getY(), null);
                b.move();
            }
        }
    }

}
