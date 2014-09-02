package ch.theowinter.UltimateUInt.Layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LayoutGUI {

	private JFrame frmLayoutExample;
	private JTextField txtName;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutGUI window = new LayoutGUI();
					window.frmLayoutExample.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LayoutGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLayoutExample = new JFrame();
		frmLayoutExample.setTitle("Layout Example");
		
		//Set the x,y coordinates and the size (width, height) of frame.
		frmLayoutExample.setBounds(100, 100, 450, 300);
		
		//Behavior when pressing the X button on the window.
		frmLayoutExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the first JPanel.
		JPanel contentPane = new JPanel();
		frmLayoutExample.setContentPane(contentPane);
		
		/*
		 * Chose a Border & decide how thick it should be.
		 * 
		 * Possible Border Types:
		 * - null: No border (default)
		 * - EmptyBorder: Invisible border
		 * - BevelBorder: Bevel visible
		 * .. and a bunch more
		 */
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		/*
		 * Chose a LayoutManager
		 * 
		 * Possible Layout Managers:
		 * - BorderLayout: 5 Areas (NORTH, SOUTH, WEST, EAST and CENTER) - Usually a good starting point.
		 * - FlowLayout: Containers/Elements inside FL can be aligned LEFT, RIGHT, CENTER.
		 * - GridBagLayout: Table-ish Layout. Good for forms.
		 */
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		//Center Panel, with a GridBag Layout inside:
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		{
			GridBagLayout gbl_center = new GridBagLayout();
			gbl_center.columnWidths = new int[]{132, 0, 0};
			gbl_center.rowHeights = new int[]{0, 0, 0, 0};
			
			//Weight 1 = This column/row gets extended when the window is resized. Usually the last row/column.
			gbl_center.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_center.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			center.setLayout(gbl_center);
			
			//Adding a label to the first field of the GridBag.
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5); //top,left,bottom,right
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.gridx = 0; //position of the field in the x-axis
			gbc_lblName.gridy = 0; //position of the field in the y-axis
			center.add(lblName, gbc_lblName);
			
			txtName = new JTextField();
			txtName.setText("name");
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 0);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 1;
			gbc_txtName.gridy = 0;
			center.add(txtName, gbc_txtName);
			txtName.setColumns(10);
			
			JLabel lblAge = new JLabel("Age");
			GridBagConstraints gbc_lblAge = new GridBagConstraints();
			gbc_lblAge.anchor = GridBagConstraints.EAST;
			gbc_lblAge.insets = new Insets(0, 0, 5, 5);
			gbc_lblAge.gridx = 0;
			gbc_lblAge.gridy = 1;
			center.add(lblAge, gbc_lblAge);
			
			txtAge = new JTextField();
			txtAge.setText("age");
			GridBagConstraints gbc_txtAge = new GridBagConstraints();
			gbc_txtAge.insets = new Insets(0, 0, 5, 0);
			gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAge.gridx = 1;
			gbc_txtAge.gridy = 1;
			center.add(txtAge, gbc_txtAge);
			txtAge.setColumns(10);
			
			JLabel lblYourMessage = new JLabel("your message");
			GridBagConstraints gbc_lblYourMessage = new GridBagConstraints();
			gbc_lblYourMessage.anchor = GridBagConstraints.EAST;
			gbc_lblYourMessage.insets = new Insets(0, 0, 0, 5);
			gbc_lblYourMessage.gridx = 0;
			gbc_lblYourMessage.gridy = 2;
			center.add(lblYourMessage, gbc_lblYourMessage);
			
			JTextArea textArea = new JTextArea();
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 1;
			gbc_textArea.gridy = 2;
			center.add(textArea, gbc_textArea);
		}
		
		JPanel bottom = new JPanel();
		contentPane.add(bottom, BorderLayout.SOUTH);
		
	}
}
