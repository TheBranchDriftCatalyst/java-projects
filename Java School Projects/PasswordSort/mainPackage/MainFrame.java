package mainPackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;



public class MainFrame extends JFrame {
	
	/*
	 * Global constants
	 */
	private static final long serialVersionUID = 3155683265180122669L;
	private static String PASS_FILE_NAME = "unsorted.txt";
	private Dimension LABEL_DIMS = new Dimension(57,16);
	private Dimension BUTTON_DIMS = new Dimension(114,26);
	
	/*
	 * Components for top panel selection sort
	 */
	protected JButton selectionSortButton = new JButton("Selection Sort");
	protected JLabel selectionSortResultLabel = new JLabel("selSrtLbl");
	protected JProgressBar selectionSortProgress = new JProgressBar();
	
	/*
	 * Components for bottom panel merge sort
	 */
	protected JButton mergeSortButton = new JButton("Merge Sort");
	protected JLabel mergeSortResultLabel = new JLabel("mrgSrtLbl");
	protected JProgressBar mergeSortProgress = new JProgressBar();
	
	/*
	 * Main Method Just Initializes Window
	 */
	public static void main(String args[]){
		new MainFrame();
	}
	
	/*
	 * MainFrame Creation
	 */
	public MainFrame(){
		super("Password Sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}   
		
		Container mainCont = this.getContentPane();
		mainCont.setLayout(new GridLayout(2,1));
		
		/*
		 * Upper Panel Creation
		 */
		JPanel upperPanel = new JPanel(new FlowLayout());
		upperPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		selectionSortButton.setPreferredSize(BUTTON_DIMS);
		selectionSortResultLabel.setPreferredSize(LABEL_DIMS);
		
		upperPanel.add(selectionSortButton);
		upperPanel.add(selectionSortResultLabel);
		upperPanel.add(selectionSortProgress);
		
		mainCont.add(upperPanel);
		
		/*
		 * Lower Panel Creation
		 */
		JPanel lowerPanel = new JPanel(new FlowLayout());
		lowerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		mergeSortButton.setPreferredSize(BUTTON_DIMS);
		mergeSortResultLabel.setPreferredSize(LABEL_DIMS);
		
		lowerPanel.add(mergeSortButton);
		lowerPanel.add(mergeSortResultLabel);
		lowerPanel.add(mergeSortProgress);
		
		mainCont.add(lowerPanel);
		/*
		 *Button Action Listeners 
		 */
		selectionSortButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						selectionSortResultLabel.setText("-");
						selectionSortProgress.setValue(0);
						PasswordList passList = new PasswordList(PASS_FILE_NAME);
						passList.addObserver(new runSort("selectionSortThread", passList));
						
					}
		});
		
		mergeSortButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						mergeSortResultLabel.setText("-");
						mergeSortProgress.setValue(0);
						PasswordList mergeList = new PasswordList(PASS_FILE_NAME);
						mergeList.addObserver(new runSort("mergeSortThread", mergeList));
					}
		});
		
		
		/*
		 * Window pack and visibility
		 */
		pack();
		setVisible(true);
	}
	
	/*
	 * Anonymous implementation of runnable to create thread and run the correct sort method
	 */
	class runSort implements Observer{
	  
	  private Thread sortThread;

	  public runSort(String name, final PasswordList list) {
	    sortThread = new Thread(new Runnable() {
	   
	      public void run() {	  
	    	  Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
	    	  
	    	  long curTime = System.currentTimeMillis();
	    	  
	    	  if(this.toString().equals("selectionSortThread")){
	    		  selectionSortButton.setEnabled(false);
	    		  selectionSortButton.setText("Sorting...");
	    		  list.selectionSort();
	    		  
	    	  }else{
	    		  mergeSortButton.setEnabled(false);
	    		  mergeSortButton.setText("Sorting...");
	    		  list.mergeSort();
	    	  }
	    	  
	    	  String endTime = Long.toString(System.currentTimeMillis() - curTime);
	    	  
	    	  if(this.toString().equals("selectionSortThread")){
	    		  selectionSortResultLabel.setText(endTime);
	    		  selectionSortButton.setText("Selection Sort");
	    		  selectionSortButton.setEnabled(true);
	    	  }else{
	    		  mergeSortResultLabel.setText(endTime);
	    		  mergeSortButton.setText("Merge Sort");
	    	  	  mergeSortButton.setEnabled(true);
	    	  }
	      }

	      public String toString() {
	        return Thread.currentThread().getName();
	      }
	      
	    }, name);
	    sortThread.start();
	  }

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof ObserverPackageObject){
			if (((ObserverPackageObject) arg).sortType == 1){
				selectionSortProgress.setValue(((ObserverPackageObject) arg).progUpdate);
			}else{
				mergeSortProgress.setValue(((ObserverPackageObject) arg).progUpdate);
				
			}
		}else
			System.err.print("Observer Data Package Invalid");
		
	}


	}


	
	
	

}
