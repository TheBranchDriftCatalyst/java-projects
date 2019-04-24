package mainPackage;


public class PasswordMainTest {

        public static void main(String args[]){

                PasswordList listTest = new PasswordList("unsorted.txt");

                System.out.println(listTest.toString());

                listTest.mergeSort();
                //listTest.selectionSort();

        }


}
