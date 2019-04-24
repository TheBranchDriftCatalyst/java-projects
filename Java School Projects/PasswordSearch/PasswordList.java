import java.io.*;
import java.util.*;


public class PasswordList {
	private String fileName;
	private Vector<Password> passVector = new Vector<Password>();

	public PasswordList(String filename){
		this.fileName = filename;

		try{
			FileInputStream fileStream = new FileInputStream(fileName);
			DataInputStream dataStream = new DataInputStream(fileStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dataStream));

			String currentLine;

			while ( ( currentLine = bReader.readLine() ) != null){

				String[] temp = currentLine.split(" ");
				passVector.addElement(new Password(temp[0], temp[1]));

			}

		}catch (Exception e){
			System.err.println("Error Caught: " + e);
			e.printStackTrace();
		} //CLOSE TRY BLOCK


	} //CLOSE CONSTRUCTOR


	public String getPasswordBySequentialSearch(String name){

		Iterator<Password> itr = passVector.iterator();

		while (itr.hasNext()){
			Password currentPass = itr.next();

			if (currentPass.getName().equals(name)){
				return currentPass.getPassword();
			}else
				continue;
		}

		return "Password Not Found.";
	}

	public String getPasswordByBinarySearch(String name){

		int index = binarySearch(new Password(name, null));

		if (index < 0){
			return "Password Not Found.";
		}else
			return passVector.elementAt(index).getPassword();

	}

	public int binarySearch(Password name){
		int first = 0;
		int last = passVector.size();

		while(first < last){

			int middle = (first + last) / 2;

			if (name.compareTo(passVector.elementAt(middle)) < 0){
				last = middle;
			}else if (name.compareTo(passVector.elementAt(middle)) > 0){
				first = middle + 1;
			}else{
				return middle;
			}
		}
		return -(first + 1);
	}


}
