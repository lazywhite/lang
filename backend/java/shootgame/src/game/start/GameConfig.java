package game.start;

import game.entity.Plane;

import java.awt.image.BufferedImage;

/**
 * Created by white on 17/6/8.
 */
public class GameConfig {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    public static BufferedImage background; //背景图片
    public static BufferedImage start;//游戏开始图片
    public static BufferedImage pause;//暂停图片
    public static BufferedImage gameover;//结束图片
    public static Plane plane;
}
