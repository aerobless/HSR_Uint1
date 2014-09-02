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

/*
 * We have to implement Observer because we have to specify
 * what to do when notified inside the update Method. Observer is
 * a interface.
 */
public class ObserverGUI implements Observer{

	private JFrame frmObserverExample;
	private JLabel veryImportantData;
	
	private StorageOfImportantThings importantThings = new StorageOfImportantThings();

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
		
		//Important for OBSERVER:
		importantThings.addObserver(this); //1. We need to register the Observer with the Observable.
	}

	//Important for OBSERVER:
	@Override //2. Method is automatically created when we implement Observer
	public void update(Observable aO, Object aArg) {
		 //3. What we do when we get notified from the Observable:
		veryImportantData.setText(importantThings.getCurrentImportantThing());
	}
}

/*
 * Observable is only extended because we don't need to implement behavior, 
 * we only want to use the "setChanged" and "notifyObserver" from the Observable class.
 */
class StorageOfImportantThings extends Observable {
	String currentlyImportantThing;
	ArrayList<String> databaseOfImportantThings = new ArrayList<String>();
	
	public StorageOfImportantThings(){
		databaseOfImportantThings.add("Natürliches Mineralwasser mit Kohlensäure");
		databaseOfImportantThings.add("Stabilo Boss (R) Original");
		databaseOfImportantThings.add("Y U NO STOP PRESSING BUTTON??");
	}
	
    public int getRandomInRange(int min, int max){
    	return min + (int)(Math.random() * ((max - min) + 1));
    }
	
	public void changeImportantThingToMoreImportantThing(){
		currentlyImportantThing = databaseOfImportantThings.get(getRandomStringFromDB());
		
		//Important for OBSERVER:
		setChanged(); //4. Marks this Observable Object as changed. So .hasChange() will now return true.
		notifyObservers(); //5. Notifies all the Observes that are watching this object and then changes it's state back to "no changes".
	}

	private int getRandomStringFromDB() {
		return getRandomInRange(0,databaseOfImportantThings.size()-1);
	}
	
	public String getCurrentImportantThing(){
		return currentlyImportantThing;
	}
	
}
