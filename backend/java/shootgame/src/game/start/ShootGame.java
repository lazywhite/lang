package game.start;

import game.entity.Plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShootGame game = new ShootGame();
        GamePanel gp = new GamePanel();
        JFrame frame = new JFrame();

        Plane p = new Plane();
        frame.add(gp);
//        frame.setBounds(400, 100, 400, 600);
        frame.setSize(GameConfig.WIDTH, GameConfig.HEIGHT);
        frame.setLocationRelativeTo(null);//设置居中显示
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
