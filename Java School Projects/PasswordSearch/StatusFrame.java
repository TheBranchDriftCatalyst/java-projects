import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class StatusFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea();

	public StatusFrame(){
		
		super("Status Information");

		this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent evt) {
	            setVisible(false);          
	        }
	    });
		
		setSize(450,400);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainContainer.add(areaScrollPane, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	public void setText(StringBuffer testText, String testName){
		textArea.insert(testName + "\n" + testText.toString(), 0);
	}

}
