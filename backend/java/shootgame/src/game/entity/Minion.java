package game.entity;

import game.start.GameConfig;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by white on 17/6/9.
 */
public class Minion extends Item implements Enemy {
    private int xSpeed = 2;
    private int ySpeed = 2;
    private String xdir;

    public Minion(){
        try {
            this.image = ImageIO.read(new File("./images/minion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.y = -this.height;
        Random r = new Random();
        this.x =  r.nextInt(GameConfig.WIDTH-this.width);
        if(this.x < GameConfig.WIDTH/2){
            this.xdir="right";
        }else{
            this.xdir="left";
        }
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public int getScore() {
        return 10;
    }

    @Override
    public void move() {
        if(this.x >= GameConfig.WIDTH - this.width){
            this.xdir = "left";
        }
        if(this.x <= 0){
            this.xdir = "right";
        }
        if(this.xdir == "left"){
            this.x -= this.xSpeed;
        }
        if(this.xdir == "right"){
            this.x += this.xSpeed;
        }
        this.y += this.ySpeed;
    }

    public List<MinionBullet> shoot(){
        ArrayList<MinionBullet> bullets = new ArrayList<>();
        bullets.add(new MinionBullet(this.getX() + this.getWidth()/4, this.getY()));
        bullets.add(new MinionBullet(this.getX() + (3 * this.getWidth()/4), this.getY()));
        return bullets;
    }

    @Override
    public boolean outOfBounds() {
        return this.y > GameConfig.HEIGHT || this.x < 0 || this.x > GameConfig.WIDTH;
    }
}
