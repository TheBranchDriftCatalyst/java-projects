import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Vector;

import alu.*;
import logicGates.*;

public class Interpreter {

	@SuppressWarnings("unused")
	private ALU mainALU = new ALU(16);
	/*
	 * Memory holds variable, 1st string = label, 2nd string = data/binary
	 */
	private Hashtable<String, String> memory = new Hashtable<String, String>();
	/*
	 * Holds the operation code and line number integer
	 */
	private Hashtable<String, Integer> instructionTable = new Hashtable<String, Integer>();
	/*
	 * sequential list of instructions
	 */
	private Vector<Instruction> instructionList = new Vector<Instruction>();

	public static void main(String[] args){
		new Interpreter("multiply.asm");
	}

	@SuppressWarnings("resource")
	public Interpreter(String filename){

		String fileName = filename;

		try{
			FileInputStream fileStream = new FileInputStream(fileName);
			DataInputStream dataStream = new DataInputStream(fileStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dataStream));

			String currentLine;
			int lineNumber = 0;

			while ( ( currentLine = bReader.readLine() ) != null){

					lineNumber++;
					String[] lineArray = currentLine.split("\\t");

					if (lineArray[0].equals("")){
						instructionList.add(new Instruction(lineArray[1].trim(), lineArray[2].trim()));
					}else if (lineArray[1].equals(".DATA") && !lineArray[0].equals("")){
						memory.put(lineArray[0].trim(), lineArray[2]);
					}else if (lineArray[1].equals(".DATA") && lineArray[0].equals("")){
						if(lineArray.length == 3){
							instructionList.add(new Instruction(lineArray[1].trim(), lineArray[2].trim()));
						}else
							instructionList.add(new Instruction(lineArray[0], lineArray[1]));
					}else{
						instructionTable.put(lineArray[0], lineNumber);
					}
			}
			System.out.println(instructionTable.toString());
			System.out.println(instructionList.toString());
			System.out.println(memory.toString());
		}catch (Exception e){
			System.err.println("Error Caught: " + e);
			e.printStackTrace();
		} //CLOSE TRY BLOCK

	}

	public void execute(){
		@SuppressWarnings("unused")
		int progCounter = 0;
	}
}
