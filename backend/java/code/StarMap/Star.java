package StarMap;

import java.awt.Color;

import javax.swing.JFrame;



public class Star {
	public static void genStar(){

		JFrame jf = new JFrame();
		jf.setTitle("������"); 
		jf.setSize(500, 500);  //setSize(width, height)
		
		Panel p = new Panel();
		p.setBackground(Color.black); //������ɫ

		jf.add(p);
		jf.setVisible(true);
	
	}
	public static void main(String[] args){
		genStar();
	}
}
