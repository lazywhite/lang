package game.entity;

import game.start.GameConfig;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by white on 17/6/9.
 */
public class MinionBullet extends Item {
    private int speed = 2;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public MinionBullet(int x, int y){
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File("./images/bullet.png")) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }
    @Override
    public void move() {
        this.y += this.speed;
    }

    @Override
    public boolean outOfBounds() {
        return this.y > GameConfig.HEIGHT;
    }
}
