
public class PasswordMainTest {

	public static void main(String args[]){

		PasswordList listTest = new PasswordList("passwords.txt");

		System.out.println(listTest.getPasswordBySequentialSearch("24998") + " :: " + listTest.getPasswordByBinarySearch("24998"));
		System.out.println(listTest.getPasswordBySequentialSearch("24938") + " :: " + listTest.getPasswordByBinarySearch("24938"));
		System.out.println(listTest.getPasswordBySequentialSearch("20614") + " :: " + listTest.getPasswordByBinarySearch("20614"));
		System.out.println(listTest.getPasswordBySequentialSearch("16107") + " :: " + listTest.getPasswordByBinarySearch("16107"));
		System.out.println(listTest.getPasswordBySequentialSearch("14941") + " :: " + listTest.getPasswordByBinarySearch("14941"));
		System.out.println(listTest.getPasswordBySequentialSearch("11193") + " :: " + listTest.getPasswordByBinarySearch("11193"));
		System.out.println(listTest.getPasswordBySequentialSearch("129334") + " :: " + listTest.getPasswordByBinarySearch("129334"));

	}
}
