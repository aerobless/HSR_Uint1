package ch.theowinter.UltimateUInt.Java2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		//Draw text:
		g2d.drawString("Java 2D", 50, 50);
		
		//Draw a straight line:
		g2d.drawLine(30, 30, 200, 30);
		
		//Move the drawing area
		// 0,0 is the top left corner. so the y value actually goes towards the bottom.
		g2d.translate(80, 100); //x,y
		
		//Rotate the drawing area
		g2d.rotate(90);
		
		//Draw a filled, round-rectangle:
		g2d.fillRoundRect(-20, -20, 70, 60, 25, 25);
		
		//Change the color
		g2d.setColor(Color.red);
		g2d.fillRoundRect(20, 20, 70, 60, 25, 25);
		
		g2d.setColor(Color.blue);
		g2d.fillOval(30, 30, 10, 10);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
			super.paintComponent(g);
			doDrawing(g);
	}
}

public class Java2D extends JFrame {
	private static final long serialVersionUID = 1L;

	public Java2D() {
		initUI();
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				Java2D j2d = new Java2D();
				j2d.setVisible(true);
			}
		});
	}
	
	private void initUI() {
		add(new Canvas());
		
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
