package client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClientEncrypted extends JFrame {

	private static final long serialVersionUID = 1L;
	Socket      _socket;
    JTextArea   _textArea;
    JTextField  _textField;
    JScrollPane _scrollPane;
         
    public ChatClientEncrypted() {
        super("Chat Client");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                try {
                    InetAddress host = InetAddress.getLocalHost();
                    sendText(host.getHostAddress() + " Left.");
                    _socket.close();
                }
                catch (IOException ex) {
                    System.err.println("Close failed. " + ex);
                }
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());

        _textArea = new JTextArea(10, 40);
        _textArea.setLineWrap(true);
        _textArea.setEditable(false);

        _scrollPane = new JScrollPane(_textArea);
        add(_scrollPane, BorderLayout.CENTER);

        _textField = new JTextField(30);
        _textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sendText(_textField.getText());

                _textField.setText("");
            }
        });

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sendText(_textField.getText());

                _textField.setText("");
            }
        });

        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.add(_textField, BorderLayout.CENTER);
        entryPanel.add(sendButton, BorderLayout.EAST);
        add(entryPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        try {
            InetAddress host    = InetAddress.getLocalHost();
            String      address = host.getHostAddress();
            _textArea.append("Connecting to: " + address + "\n");
            _socket = new Socket(host, 7777);
            _textArea.append("Connected\n");

            sendText(address + " Joined.");

            while (!_socket.isClosed()) {
                try {
                    InputStream input     = _socket.getInputStream();
                    int         available = input.available();
                    if (available > 0) {
                        byte[] bytes = new byte[available];
                        input.read(bytes);

                        _textArea.append(decrypt(new String(bytes)) + "\n");

                        JScrollBar scroll = _scrollPane.getVerticalScrollBar();
                        scroll.setValue(scroll.getMaximum());
                    }

                    Thread.sleep(100);
                }
                catch (IOException ex) {
                    System.err.println("Listen failed " + ex);
                }
                catch (InterruptedException ex) {
                    System.err.println("Sleep interrupted " + ex);
                }
            }
        }
        catch (IOException ex) {
            System.err.println("Connection failed. " + ex);
            System.exit(1);
        }
    }

    private void sendText(String s) {
        try {
            OutputStream output = _socket.getOutputStream();
            output.write(encrypt(s).getBytes());
            output.flush();
        }
        catch (IOException ex) {
            System.err.println("Send error: " + ex);
        }
    }

    public static void main(String[] args) {
        new ChatClientEncrypted();
    }
    
    /*
     * ChA = character in string to encrypt
     * ChB = character in string to encrypt A+1
     * matrixB = the key matrix
     */
    private static String transform(char chA, char chB, int[][] matrixB){
    	/*
		 * Resultant matrix is AB[2] such that AB = {AE+BG, AF+BH} & 
		 * AE+BG = C, AF+BH = D given A = {A, B} & B = {{E, F}, {G, H}}
		 */
    	
    	int[] matrixA = {(int)chA, (int)chB};
    	
    	int c_asci = matrixA[0] * matrixB[0][0] + matrixA[1] * matrixB[1][0];
    	int d_asci = matrixA[0] * matrixB[0][1] + matrixA[1] * matrixB[1][1];
    	
    	c_asci %= 128;
    	d_asci %= 128;
    	
    	if (c_asci < 0 ){
    		c_asci += 128;
    	}
    	if (d_asci < 0 ){
    		d_asci += 128;
    	}
    	   	
    	return Character.toString((char)c_asci) + Character.toString((char)d_asci);
    }
    
    private String encrypt(String strA){
    	String encryptedString = "";
    	
    	int[][] key = {{4,3},{5,4}};
    	
    	if (strA.length() % 2 != 0){
    		strA += " ";
    	}
    	
    	for (int i = 0; i < strA.length(); i +=2 ){
    		char chrA = strA.charAt(i);
    		char chrB = strA.charAt(i+1);
    		
    		encryptedString += transform(chrA, chrB, key);
    				
    	}
    		
    	return encryptedString;
    }
    
    private String decrypt(String strA){
    	String decryptedString = "";
    	int[][] dKey = {{4,-3},{-5,4}}; 
    	
    	if (strA.length() % 2 != 0){
    		strA += " ";
    	}
    	
    	for (int i = 0; i < strA.length(); i +=2 ){
    		char chrA = strA.charAt(i);
    		char chrB = strA.charAt(i+1);
    		
    		decryptedString += transform(chrA, chrB, dKey);
    				
    	}
    		
    	return decryptedString;
    	
    	
    	
    }
    
}
