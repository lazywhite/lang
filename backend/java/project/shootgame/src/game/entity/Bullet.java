package game.entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by white on 17/6/9.
 */
public class Bullet extends Item {
    private int speed = 3;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File("./images/bullet1.png")) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }
    @Override
    public void move() {
        this.y -= this.speed;
    }

    @Override
    public boolean outOfBounds() {
        return this.y < 0;
    }
}
