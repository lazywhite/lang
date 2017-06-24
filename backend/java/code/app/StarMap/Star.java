package app.StarMap;
import java.awt.Color;

import javax.swing.JFrame;



public class Star {
	public static void genStar(){

		JFrame jf = new JFrame();
		jf.setTitle("满天星"); 
		jf.setSize(500, 500);  //setSize(width, height)
		
		Panel p = new Panel();
		p.setBackground(Color.black); //画布颜色

		jf.add(p);
		jf.setVisible(true);
	
	}
	public static void main(String[] args){
		genStar();
	}
}
