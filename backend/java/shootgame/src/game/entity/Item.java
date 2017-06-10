package game.entity;

import java.awt.image.BufferedImage;

/**
 * Created by white on 17/6/8.
 */
public abstract class Item {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public abstract void move();
    public abstract boolean outOfBounds();
}
