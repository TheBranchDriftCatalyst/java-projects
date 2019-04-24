package mainPackage;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;



public class PasswordList extends Observable {
        private String fileName;
        private Vector<Password> passVector = new Vector<Password>();
        private int mergeProgress = 0;
        private double mergeAvgCase = passVector.size()*.2645;

        public PasswordList(String filename){
                this.fileName = filename;
                int lineNum = 0;

                try{
                        FileInputStream fileStream = new FileInputStream(fileName);
                        DataInputStream dataStream = new DataInputStream(fileStream);
                        BufferedReader bReader = new BufferedReader(new InputStreamReader(dataStream));

                        String currentLine;

                        while ( ( currentLine = bReader.readLine() ) != null) {
                                lineNum++;
                                String[] temp = null;
                                try{
                                        temp = currentLine.split(" ");
                                        passVector.addElement(new Password(temp[0], temp[1]));
                                }catch (ArrayIndexOutOfBoundsException e) {
                                        JOptionPane.showMessageDialog (null,
                                                                       "Possible Corrupt Password at Line " + lineNum + "\nFormating Error Caught" +
                                                                       "\nCheck Password File if Results are Inconsistent",
                                                                       "File Format Warning\n", JOptionPane.WARNING_MESSAGE);
                                }

                        }

                }catch (Exception e) {
                        System.err.println("Error Caught: " + e);
                } //CLOSE TRY BLOCK

        } //CLOSE CONSTRUCTOR


        public void selectionSort() {

                int x = passVector.size();
                double comparisons = 0;
                double avgCase = ((passVector.size()-1)/2)*passVector.size();

                for (int i=0; i < x - 1; i++) {

                        for (int j=i+1; j<x; j++) {
                                /*
                                 * I discovered if you don't notify observers every time you can cut them sort time in half.
                                 */
                                if (comparisons % (avgCase*.02) == 0) {
                                        this.setChanged();
                                        selectionSortProgress(comparisons, avgCase);
                                }

                                comparisons++;
                                if ( passVector.elementAt(i).compareTo(passVector.elementAt(j)) == -1) {
                                        Collections.swap(passVector, i, j);

                                }
                        }
                }

        }

        public void selectionSortProgress(double comparisons, double avgCase){
                int selSort = 1;

                int prog = (int) ((comparisons * 100)/avgCase);
                ObserverPackageObject obsData = new ObserverPackageObject(selSort, prog);

                this.notifyObservers(obsData);
        }

        /**
         * This is the main method that initiates the merge sort
         */
        public void mergeSort(){
                mergeSort(passVector);
        }

        private Vector<Password> mergeSort(Vector<Password> mainVector){
                if (mainVector.size() <= 1) {
                        return mainVector;
                }

                Vector<Password> left = new Vector<Password>();
                Vector<Password> right = new Vector<Password>();
                Vector<Password> result = new Vector<Password>();

                int middle = mainVector.size()/2;

                for (int i = 0; i < middle; i++) {
                        left.add(mainVector.elementAt(i));
                }
                for (int j = middle; j < mainVector.size(); j++) {
                        right.add(mainVector.elementAt(j));
                }

                left = mergeSort(left);
                right = mergeSort(right);
                result = merge(left, right);

                return result;

        }


        private Vector<Password> merge(Vector<Password> left, Vector<Password> right){

                Vector<Password> result = new Vector<Password>();

                while (left.size() > 0 || right.size() > 0) {

                        if (left.size() > 0 && right.size() > 0) {
                                if (left.elementAt(0).compareTo(right.elementAt(0)) <= 0) {
                                        result.add(left.elementAt(0));
                                        left.removeElementAt(0);
                                }else{
                                        result.add(right.elementAt(0));
                                        right.removeElementAt(0);
                                }

                                this.setChanged();
                                mergeSortProgress(mergeProgress, mergeAvgCase);
                                mergeProgress++;

                        }else if(left.size() > 0) {
                                result.add(left.elementAt(0));
                                left.removeElementAt(0);
                        }else if (right.size() > 0) {
                                result.add(right.elementAt(0));
                                right.removeElementAt(0);
                        }

                }
                return result;
        }



        public void mergeSortProgress(double comparisons, double avgCase){
                int mergeSort = 0;

                int prog = (int) ((comparisons * 100)/avgCase);
                ObserverPackageObject obsData = new ObserverPackageObject(mergeSort, prog);

                this.notifyObservers(obsData);
        }

        @Override
        public String toString(){
                return passVector.toString();
        }

        /*
         * Methods From Assignment 1, Unused
         */

        public String getPasswordBySequentialSearch(String name){

                Iterator<Password> itr = passVector.iterator();

                while (itr.hasNext()) {
                        Password currentPass = itr.next();

                        if (currentPass.getName().equals(name)) {
                                return currentPass.getPassword();
                        }else
                                continue;
                }

                return "Password Not Found.";
        }

        public String getPasswordByBinarySearch(String name){

                int index = binarySearch(new Password(name, null));

                if (index < 0) {
                        return "Password Not Found.";
                }else
                        return passVector.elementAt(index).getPassword();

        }

        public int binarySearch(Password name){
                int first = 0;
                int last = passVector.size();

                while(first < last) {

                        int middle = (first + last) / 2;

                        if (name.compareTo(passVector.elementAt(middle)) < 0) {
                                last = middle;
                        }else if (name.compareTo(passVector.elementAt(middle)) > 0) {
                                first = middle + 1;
                        }else{
                                return middle;
                        }
                }
                return -(first + 1);
        }

}
