package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *生成验证码类,
 */
public final class ImageUtil {
	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "东",
			"南", "西", "北", "中"};
	private static final int SIZE = 5;//验证码字符个数
	private static final int LINES = 10;//干扰线数量 
	private static final int WIDTH = 200;
	private static final int HEIGHT = 100;//验证码图片的大小 
	private static final int FONT_SIZE = 60;//字体大小 
	//map:
	// key: 验证码字符组成字符串
	// value: 验证码图片对象
	
	public static Map<String,BufferedImage> getImage() {
		StringBuffer sb = new StringBuffer();
		//图片对象
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		//画笔对象
		Graphics graphic = image.getGraphics();
		//上背景色 
		graphic.setColor(Color.LIGHT_GRAY);
		//画矩形
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		//画随机字符  5个字符
		for(int i=1;i<=SIZE;i++){
			int r = ran.nextInt(chars.length);
			//随机颜色
			graphic.setColor(getRandomColor());
			graphic.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
			graphic.drawString(chars[r],(i-1)*WIDTH/SIZE , HEIGHT/2);
			sb.append(chars[r]);
		}
		//画干扰线
		for(int i=1;i<=LINES;i++){
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH),ran.nextInt(HEIGHT));
		}
		//组织成一个map对象
		Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}
	public static Color getRandomColor(){
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
		return color;
	}
}
