package ch.theowinter.UltimateUInt.ListenerTypes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ListenerGUI {

	private JFrame frmListenerExample;
	private JTextField textField;

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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		center.add(textField, gbc_textField);
		textField.setColumns(10);
		
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
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frmListenerExample.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		JButton btnIAmA = new JButton("I am a button");
		bottom.add(btnIAmA);
		
		JLabel status = new JLabel("Status:");
		bottom.add(status);
	}

}
