package ch.theowinter.UltimateUInt.DefaultButtons;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class DefaultButtonsGUI {

	private JFrame frame;
	private static JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultButtonsGUI window = new DefaultButtonsGUI();
					window.frame.setVisible(true);
					
					//Request that btnSave gets the focus initially. Only works when called after .setVisible();
					btnSave.requestFocusInWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DefaultButtonsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel header = new JPanel();
		FlowLayout flowLayout = (FlowLayout) header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(header, BorderLayout.NORTH);
		
		JLabel headerText = new JLabel("Fancy Editor");
		headerText.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		header.add(headerText);
	
		JPanel center = new JPanel();
		frame.getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		JLabel lblSdjka = new JLabel("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
		center.add(lblSdjka);
		
		FlowLayout bottomFlowLayout = new FlowLayout();
		bottomFlowLayout.setAlignment(FlowLayout.RIGHT);	
		JPanel bottom = new JPanel(bottomFlowLayout);
		frame.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		bottom.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent aE) {
				System.out.println("Cancel button pressed");
			}
		});
		
		//Creating a simple button and adding it to the bottom panel.
		btnSave = new JButton("Save");
		bottom.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent aE) {
				System.out.println("Save button used.");
			}
		});
		
		//Setting the default button. Usually enter
		frame.getRootPane().setDefaultButton(btnSave);

		
		//Listening to "esc" to push the cancel button.
	    ActionListener escListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           System.out.println("esc listener");
	           btnCancel.doClick();
	        }
	    };

	    //Adding the escListener as a keyBoardAction
	    frame.getRootPane().registerKeyboardAction(escListener,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);

	}
}
