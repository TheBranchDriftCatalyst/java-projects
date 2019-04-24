package Project2;

import java.io.PrintStream;

public class SimpleTest
{
        private static int randomNum(int x)
        {
                int ranNum = 1 + (int)(Math.random() * x);
                return ranNum;
        }

        public static void main(String[] args) {
                SortedIntList list = new SortedIntList(false, 300);
                SortedIntList list2 = new SortedIntList(true, 300);

                for (int i = 0; i < 300; i++) {
                        int num = randomNum(300);
                        list.add(num);
                        list2.add(num);
                }

                System.out.println("list = " + list);
                System.out.println("size = " + list.size());
                System.out.println("list = " + list.size);
                System.out.println("uniqueness = " + list.getUnique());

                System.out.println("list2 = " + list2);
                System.out.println("size2 = " + list2.size());
                System.out.println("list2 = " + list2.size);
                System.out.println("uniqueness2 = " + list2.getUnique());

                System.out.println("Setting List to Unique = true");
                list.setUnique(true);

                System.out.println("list = " + list);
                System.out.println("size = " + list.size());
                System.out.println("list = " + list.size);
                System.out.println("uniqueness = " + list.getUnique());

                System.out.println("Reseting List Back to False");
                list.setUnique(false);

                System.out.println("list = " + list);
                System.out.println("size = " + list.size());
                System.out.println("list = " + list.size);
                System.out.println("uniqueness = " + list.getUnique());
        }
}
