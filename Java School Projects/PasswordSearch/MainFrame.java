import java.awt.*;
import javax.swing.*;
import java.sql.Timestamp;
import java.awt.event.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5940141265078811901L;

	private final static int DEFAULT_TEST_CYCLE = 1000;

	private JButton sequentialSearchButton = new JButton("Sequential Search Time Test");
	private JButton binarySearchButton = new JButton("Binary Search Time Test");
	private JLabel sequentialSearchLabel = new JLabel("seq search time");
	private JLabel binarySearchLabel = new JLabel("bin search time");
	private JTextField testCycleInput = new JTextField(Integer.toString(DEFAULT_TEST_CYCLE));
	private JLabel testCycleInputLabel = new JLabel("Test Duty Cycle");

	private JButton seqSearchPass = new JButton("Search Password (Sequential)");
	private JButton binSearchPass = new JButton("Search Password (Binary)");
	private JButton hideShowStatusFrame = new JButton("Show/Hide Status Window");
	private JTextField seqSearchInput = new JTextField("");
	private JTextField binSearchInput = new JTextField("");
	private JLabel searchResultsSeq = new JLabel("seq search results");
	private JLabel searchResultsBin = new JLabel("bin search results");

	private int testNum = 0;
	private String testName;
	private StatusFrame statFrame = new StatusFrame();

	//CHANGE VALUES TO CHANGE TEST CRITERIA
	private String[] testNameArray = {"1001c", "17749", "23765", "14850", "12504", "24990", "22396", "16669", "20588", "12344"};
	private final static String PASS_FILE_NAME = "passwords.txt";

	private PasswordList passList = new PasswordList(PASS_FILE_NAME);

	public static void main(String args[]){
		new MainFrame();
	}

	public MainFrame(){
		super("Password Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setResizable(false);

		Container mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel(new FlowLayout(20));
		northPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		testCycleInput.setColumns(8);

		northPanel.add(testCycleInputLabel);

		testCycleInput.setColumns(8);
		northPanel.add(testCycleInput);

		hideShowStatusFrame.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if (statFrame.isVisible()){
							statFrame.setVisible(false);
						}else
							statFrame.setVisible(true);
					}
		});

		northPanel.add(hideShowStatusFrame);

		mainContainer.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel(new GridLayout(2,0));
		JPanel testPanel = new JPanel(new GridLayout(2,2));

		mainContainer.add(centerPanel, BorderLayout.CENTER);

		sequentialSearchButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
							sequentialSearchLabel.setText(Long.toString(searchTest(false)) + "ms");
					}
		});

		binarySearchButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
								  binarySearchLabel.setText(Long.toString(searchTest(true)) + "ms");
					}
		});

		testPanel.add(sequentialSearchButton);
		testPanel.add(sequentialSearchLabel);
		testPanel.add(binarySearchButton);
		testPanel.add(binarySearchLabel);

		centerPanel.add(testPanel);

		JPanel searchPanel = new JPanel(new GridLayout(2,3));


		searchPanel.add(seqSearchPass);
		searchPanel.add(seqSearchInput);
		searchPanel.add(searchResultsSeq);
		searchPanel.add(binSearchPass);
		searchPanel.add(binSearchInput);
		searchPanel.add(searchResultsBin);


		seqSearchPass.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						searchResultsSeq.setText(passList.getPasswordBySequentialSearch(seqSearchInput.getText()));
					}
		});

		binSearchPass.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						searchResultsBin.setText(passList.getPasswordBySequentialSearch(binSearchInput.getText()));
					}
		});


		testCycleInputLabel.setSize(20, 1);
		centerPanel.add(searchPanel);

		pack();
		setVisible(true);
	}


	private long searchTest(boolean binarySearch){

		int TEST_CYCLE = DEFAULT_TEST_CYCLE;
		StringBuffer outputStatus = new StringBuffer();

		java.util.Date date = new java.util.Date();
		testNum++;
		testName = "\n Test Number: " + Integer.toString(testNum) + " (" + new Timestamp(date.getTime()).toString() + ")";

		try{
			TEST_CYCLE = Integer.parseInt(testCycleInput.getText());
		}catch (NumberFormatException e) {

		}

		long curTime = System.currentTimeMillis();

		for (int i = 0; i < testNameArray.length; i++){
			long testTime = System.currentTimeMillis();

			outputStatus.append((binarySearch?"Binary Search: ":"Sequential Search: ") + testNameArray[i] + " :: Status: ");

			for (int j = 0; j < TEST_CYCLE; j++){
				if (!binarySearch){
					passList.getPasswordBySequentialSearch(testNameArray[i]);
				}else if (binarySearch){
					passList.getPasswordByBinarySearch(testNameArray[i]);
				}

			}

			outputStatus.append("COMPLETED (" + TEST_CYCLE+ " Cycles) " + Long.toString(System.currentTimeMillis() - testTime) + "ms\n");

		}

		statFrame.setText(outputStatus, testName);
		return System.currentTimeMillis() - curTime;
	}


}
