package Project2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Test2
{
        public static final int TEST_SIZE = 25;
        public static final int MAX_INT = 10;

        public static void main(String[] args)
        {
                System.out.println("Testing SortedIntList()");
                SortedIntList list = new SortedIntList();
                test(list, 100, false);

                System.out.println("Testing SortedIntList(25)");
                list = new SortedIntList(25);
                test(list, 25, false);

                System.out.println("Testing SortedIntList(false)");
                list = new SortedIntList(false);
                test(list, 100, false);

                System.out.println("Testing SortedIntList(true)");
                list = new SortedIntList(true);
                test(list, 100, true);

                System.out.println("Testing SortedIntList(false, 25)");
                list = new SortedIntList(false, 25);
                test(list, 25, false);

                System.out.println("Testing SortedIntList(true, 25)");
                list = new SortedIntList(true, 25);
                test(list, 25, true);
        }

        public static void test(SortedIntList list, int size, boolean unique)
        {
                List result = new ArrayList();
                String history = "";
                Random r = new Random();

                for (int i = 0; i < size; i++) {
                        int next = r.nextInt(10);
                        history = history + " " + next;
                        result.add(Integer.valueOf(next));
                        Collections.sort(result);
                        list.add(next);
                        String correct;

                        if (unique)
                                correct = new TreeSet(result).toString();
                        else {
                                correct = result.toString();
                        }
                        String test = list.toString();
                        if (!correct.equals(test)) {
                                System.out.println("error when adding these values to list:" +
                                                   history);
                                System.out.println("list should = " + correct);
                                System.out.println("actual list = " + test);
                                if (result.size() > 1) {
                                        System.out.println("was working properly prior to adding last value of " +
                                                           next);
                                }
                                System.exit(1);
                        }
                }
                System.out.println("    Passed");
        }
}
