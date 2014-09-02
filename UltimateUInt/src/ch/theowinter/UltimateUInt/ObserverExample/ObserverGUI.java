package ch.theowinter.UltimateUInt.ObserverExample;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ObserverGUI implements Observer{

	private JFrame frmObserverExample;
	private JLabel veryImportantData;
	
	private StorageOfImportantThings importantThings = new StorageOfImportantThings("Press \"Trigger a change\" to change me!");

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
		
		veryImportantData = new JLabel("Press \"Trigger a change\" to change me!");
		textPanel.add(veryImportantData);
		
		JPanel bottom = new JPanel();
		frmObserverExample.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		JButton btnTriggerAChange = new JButton("Trigger a change");
		bottom.add(btnTriggerAChange);
		btnTriggerAChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent aE) {
				importantThings.changeImportantThingToMoreImportantThing();
			}
		});
		
		importantThings.addObserver(this);
	}


	@Override
	public void update(Observable aO, Object aArg) {
		veryImportantData.setText(importantThings.getCurrentImportantThing());
	}
}

class StorageOfImportantThings extends Observable {
	String currentlyImportantThing;
	ArrayList<String> databaseOfImportantThings = new ArrayList<String>();
	
	public StorageOfImportantThings(String firstImportantThing){
		currentlyImportantThing = firstImportantThing;
		initDatabaseOfImportantThings();
	}
	
	private void initDatabaseOfImportantThings(){
		databaseOfImportantThings.add("Natürliches Mineralwasser mit Kohlensäure");
		databaseOfImportantThings.add("Stabilo Boss (R) Original");
		databaseOfImportantThings.add("Y U NO STOP PRESSING BUTTON??");
	}
	
    public int getRandomInRange(int min, int max){
    	return min + (int)(Math.random() * ((max - min) + 1));
    }
	
	public void changeImportantThingToMoreImportantThing(){
		currentlyImportantThing = databaseOfImportantThings.get(getRandomInRange(0,databaseOfImportantThings.size()-1));
		
		//Important part:
		setChanged(); //Marks this Observable Object as changed. So .hasChange() will now return true.
		notifyObservers(); //Notifies all the Observes that are watching this object and then changes it's state back to "no changes".
	}
	
	public String getCurrentImportantThing(){
		return currentlyImportantThing;
	}
	
}
