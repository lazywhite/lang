package app.StarMap;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


public class Panel extends JPanel {
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.white);  //画笔颜色
		for (int i=0;i<100;i+=10){
			for(int j=0;j<200;j+=10){
				g.drawString("*", 
						(int)(Math.random() * 500),
						(int)(Math.random() * 500));
			}
		}
		g.fillOval(100, 100, 50, 50);
		g.setColor(Color.black);
		g.fillOval(80, 80, 50, 60);
	}

}
