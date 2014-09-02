package ch.theowinter.UltimateUInt.ListenerTypes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ListenerGUI {

	private JFrame frmListenerExample;
	private JTextField someTextField;
	private JButton someButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListenerGUI window = new ListenerGUI();
					window.frmListenerExample.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListenerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListenerExample = new JFrame();
		frmListenerExample.setTitle("Listener Example");
		frmListenerExample.setBounds(100, 100, 450, 300);
		frmListenerExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListenerExample.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		FlowLayout flowLayout = (FlowLayout) header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmListenerExample.getContentPane().add(header, BorderLayout.NORTH);
		
		JLabel lblListenerExample = new JLabel("Listener Example");
		lblListenerExample.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		header.add(lblListenerExample);
		
		JPanel center = new JPanel();
		frmListenerExample.getContentPane().add(center, BorderLayout.CENTER);
		GridBagLayout gbl_center = new GridBagLayout();
		gbl_center.columnWidths = new int[]{120, 0, 0, 0};
		gbl_center.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_center.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center.setLayout(gbl_center);
		
		JLabel lblJtextfield = new JLabel("JTextField");
		GridBagConstraints gbc_lblJtextfield = new GridBagConstraints();
		gbc_lblJtextfield.insets = new Insets(0, 0, 5, 5);
		gbc_lblJtextfield.anchor = GridBagConstraints.EAST;
		gbc_lblJtextfield.gridx = 0;
		gbc_lblJtextfield.gridy = 0;
		center.add(lblJtextfield, gbc_lblJtextfield);
		
		someTextField = new JTextField();
		GridBagConstraints gbc_someTextField = new GridBagConstraints();
		gbc_someTextField.insets = new Insets(0, 0, 5, 5);
		gbc_someTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_someTextField.gridx = 1;
		gbc_someTextField.gridy = 0;
		center.add(someTextField, gbc_someTextField);
		someTextField.setColumns(10);
		
		JLabel lblJradiobutton = new JLabel("JRadioButton");
		GridBagConstraints gbc_lblJradiobutton = new GridBagConstraints();
		gbc_lblJradiobutton.anchor = GridBagConstraints.EAST;
		gbc_lblJradiobutton.insets = new Insets(0, 0, 5, 5);
		gbc_lblJradiobutton.gridx = 0;
		gbc_lblJradiobutton.gridy = 1;
		center.add(lblJradiobutton, gbc_lblJradiobutton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		center.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Option 1");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Option 2");
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel bottom = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) bottom.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		frmListenerExample.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		someButton = new JButton("I am a button");
		bottom.add(someButton);
		
		initListeners();
	}
	
	private void initListeners(){
		
		//Action Listener Example:
		someButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent aE) {
				System.out.println("Action through Button activated. I also works with the spacebar, try it ;-)");
			}
		});
		
		//Document Listener Example:
		someTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent aE) {
				System.out.println("Removed data in textfield");
			}
			
			@Override
			public void insertUpdate(DocumentEvent aE) {
				System.out.println("Inserted data in textfield");
			}
			
			@Override
			public void changedUpdate(DocumentEvent aE) {
				System.out.println("Changed data in textField");
			}
		});
		
	}
}
