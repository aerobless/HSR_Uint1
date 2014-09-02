package ch.theowinter.UltimateUInt.ObserverExample;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ObserverGUI {

	private JFrame frmObserverExample;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObserverGUI window = new ObserverGUI();
					window.frmObserverExample.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ObserverGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmObserverExample = new JFrame();
		frmObserverExample.setTitle("Observer Example");
		frmObserverExample.setBounds(100, 100, 450, 300);
		frmObserverExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmObserverExample.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		FlowLayout flowLayout = (FlowLayout) header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmObserverExample.getContentPane().add(header, BorderLayout.NORTH);
		
		JLabel headerText = new JLabel("Observer Example");
		headerText.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		header.add(headerText);
		
		JPanel center = new JPanel();
		frmObserverExample.getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));
		
		JPanel textPanel = new JPanel();
		FlowLayout fl_textPanel = (FlowLayout) textPanel.getLayout();
		fl_textPanel.setVgap(30);
		fl_textPanel.setHgap(30);
		center.add(textPanel, BorderLayout.NORTH);
		
		JLabel veryImportantData = new JLabel("Press \"Trigger a change\" to change me!");
		textPanel.add(veryImportantData);
		
		JPanel bottom = new JPanel();
		frmObserverExample.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		JButton btnTriggerAChange = new JButton("Trigger a change");
		bottom.add(btnTriggerAChange);
	}

}
