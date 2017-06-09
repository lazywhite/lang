package game.start;

import javax.swing.*;
import java.awt.*;


/**
 * Created by white on 17/6/8.
 */
public class GamePanel extends JPanel {


    public void paint(Graphics g){
        g.drawImage(GameConfig.background, 0, 0, null);
        g.drawImage(GameConfig.plane.getImage(), GameConfig.plane.getX(), GameConfig.plane.getY(), null);
    }

}
