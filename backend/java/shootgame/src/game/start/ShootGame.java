package game.start;

import game.entity.Plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShootGame game = new ShootGame();
        JFrame frame = new JFrame();

        Plane p = new Plane();
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
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameConfig.plane.changeImage();
                GameConfig.gp.repaint();
            }
        }, 10, 100);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                GameConfig.plane.setX(x - GameConfig.plane.getWidth()/2);
                GameConfig.plane.setY(y - GameConfig.plane.getHeight()/2);
            }
        };
        GameConfig.gp.addMouseMotionListener(mouse);
//        GameConfig.gp.addMouseListener(mouse);

    }
}
