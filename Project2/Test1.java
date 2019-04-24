package Project2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test1
{
        public static final int BASIC_TEST_SIZE = 10;
        public static final int SPEED_TEST_SIZE = 100000;

        public static void main(String[] args)
        {
                checkAdd(10);
                checkIndexOf(10);
                checkSpeed(100000);
        }

        public static void checkAdd(int testSize)
        {
                System.out.println("Beginning basic add test of size " + testSize);
                SortedIntList list = new SortedIntList(testSize);
                List result = new ArrayList();
                String history = "";
                Random r = new Random();
                for (int i = 0; i < testSize; i++)
                {
                        int next = r.nextInt(2 * testSize + 1) - testSize;
                        history = history + " " + next;
                        result.add(Integer.valueOf(next));
                        Collections.sort(result);
                        list.add(next);
                        boolean sizeOK = result.size() == list.size();
                        boolean toStringOK = result.toString().equals(list.toString());
                        if ((!sizeOK) || (!toStringOK)) {
                                System.out.println("wrong size or toString when adding these values to list:" +
                                                   history);
                                System.out.println("size should       = " + result.size());
                                System.out.println("toString should   = " + result.toString());
                                System.out.println("actual size       = " + list.size());
                                System.out.println("actual toString   = " + list.toString());
                                if (result.size() > 1) {
                                        System.out.println("size and ToString were working properly prior to adding last value of " +
                                                           next);
                                }
                                System.exit(1);
                        } else {
                                for (int j = 0; j < result.size(); j++) {
                                        if (list.get(j) != ((Integer)result.get(j)).intValue()) {
                                                System.out.println("wrong value for get(" + j + ")");
                                                System.out.println("list = " + result.toString());
                                                System.out.println("get should   = " + result.get(j));
                                                System.out.println("get actually = " + list.get(j));
                                                System.exit(1);
                                        }
                                }
                        }
                }
                System.out.println("    Passed");
                System.out.println();
        }

        public static void checkIndexOf(int testSize)
        {
                System.out.println("Beginning basic indexOf test of size " + testSize);
                SortedIntList list = new SortedIntList(testSize);
                List result = new ArrayList();
                Random r = new Random();
                checkIndexes(testSize, result, list);
                for (int i = 0; i < testSize; i++)
                {
                        int next = r.nextInt(2 * testSize + 1) - testSize;
                        result.add(Integer.valueOf(next));
                        Collections.sort(result);
                        list.add(next);
                        checkIndexes(testSize, result, list);
                }
                System.out.println("    Passed");
                System.out.println();
        }

        public static void checkSpeed(int testSize)
        {
                System.out.println("Beginning speed test of size " + testSize);

                long start = System.currentTimeMillis();

                int dot = testSize / 75;
                SortedIntList list = new SortedIntList(testSize);
                System.out.println("construction--should take a fraction of a second");
                System.out.println("done after 75 dots:");
                for (int i = 0; i < testSize; i++) {
                        list.add(2 * i);
                        if (i % dot == 0)
                                System.out.print(".");
                }
                System.out.println();
                double elapsed = (System.currentTimeMillis() - start) / 1000.0D;
                System.out.println("construction took " + elapsed + " seconds");
                System.out.println();

                start = System.currentTimeMillis();
                System.out.println("searching list--should take a second or two");
                System.out.println("done after 75 dots:");
                for (int i = 0; i < testSize; i++) {
                        if (i % dot == 0)
                                System.out.print(".");
                        for (int j = 0; j < 100; j++) {
                                int index = list.indexOf(2 * i);
                                if (index != i) {
                                        System.out.println("wrong value for indexOf(" + 2 * i + ")");
                                        System.out.println("indexOf should = " + i);
                                        System.out.println("actual indexOf = " + index);
                                        System.exit(1);
                                }
                        }
                }
                System.out.println();
                elapsed = (System.currentTimeMillis() - start) / 1000.0D;
                System.out.println("searching took " + elapsed + " seconds");
        }

        public static boolean checkIndexes(int testSize, List<Integer> result, SortedIntList list)
        {
                for (int i = -testSize; i < testSize; i++) {
                        int index = list.indexOf(i);
                        boolean bad;

                        if (result.indexOf(Integer.valueOf(i)) == -1)
                                bad = index != -1;
                        else {
                                bad = (index < 0) || (((Integer)result.get(index)).intValue() != i);
                        }
                        if (bad) {
                                System.out.println("wrong value for indexOf(" + i + ")");
                                System.out.println("list = " + result.toString());
                                if (result.indexOf(Integer.valueOf(i)) == -1) {
                                        System.out.println("indexOf should = -1");
                                        System.out.println("actual indexOf = " + index);
                                } else {
                                        System.out.println("indexOf is returning " + index);
                                        System.out.println(i + " is not at that index");
                                }
                                System.exit(1);
                        }
                }
                return true;
        }
}
