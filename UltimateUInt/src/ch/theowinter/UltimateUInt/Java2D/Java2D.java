package ch.theowinter.UltimateUInt.Java2D;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Java 2D", 50, 50);
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
