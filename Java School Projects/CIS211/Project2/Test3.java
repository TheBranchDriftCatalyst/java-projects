package Project2;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class Test3
{
        public static void main(String[] args)
        {
                for (int testSize = 0; testSize < 25; testSize++) {
                        System.out.print("Testing with size " + testSize + ": ");
                        for (int i = 0; i < 10; i++) {
                                SortedIntList list1 = new SortedIntList(testSize);
                                testTrue(list1, testSize);
                                SortedIntList list2 = new SortedIntList(2 * testSize);
                                testFalse(list2, testSize);
                        }
                        System.out.println("Passed");
                }
        }
        public static void testTrue(SortedIntList list, int testSize)
        {
                Set result = new TreeSet();
                String history = "adding with unique=true:";
                Random r = new Random();
                setAndTestUnique(list, true);
                while (result.size() < testSize) {
                        int next = r.nextInt(testSize);
                        history = history + " " + next;
                        result.add(Integer.valueOf(next));
                        list.add(next);
                        check(list, result, history);
                }
                setAndTestUnique(list, false);
                setAndTestUnique(list, true);
                check(list, result, history);
                for (int i = 0; i < testSize * 10; i++) {
                        int next = r.nextInt(testSize);
                        history = history + " " + next;
                        list.add(next);
                        result.add(Integer.valueOf(next));
                        check(list, result, history);
                }
        }
        public static void testFalse(SortedIntList list, int testSize)
        {
                List result = new ArrayList();
                String history = "adding with unique=false:";
                Random r = new Random();
                setAndTestUnique(list, false);
                while (result.size() < testSize) {
                        int next = r.nextInt(testSize);
                        if (!result.contains(Integer.valueOf(next))) {
                                history = history + " " + next;
                                result.add(Integer.valueOf(next));
                                Collections.sort(result);
                                list.add(next);
                                check(list, result, history);
                        }
                }
                for (int i = 1; i <= testSize; i++) {
                        int next = r.nextInt(testSize);
                        history = history + " " + next;
                        result.add(Integer.valueOf(next));
                        Collections.sort(result);
                        list.add(next);
                        check(list, result, history);
                }
                setAndTestUnique(list, true);
                history = history + " unique=true";
                result = new ArrayList(new TreeSet(result));
                check(list, new TreeSet(result), history);
                setAndTestUnique(list, false);
                history = history + " unique=false";
                for (int i = 1; i <= testSize; i++) {
                        int next = r.nextInt(testSize);
                        history = history + " " + next;
                        result.add(Integer.valueOf(next));
                        Collections.sort(result);
                        list.add(next);
                        check(list, result, history);
                }
                setAndTestUnique(list, true);
                history = history + " unique=true";
                check(list, new TreeSet(result), history);
        }
        public static void setAndTestUnique(SortedIntList list, boolean unique)
        {
                list.setUnique(unique);
                boolean result = list.getUnique();
                if (result != unique) {
                        System.out.println(" error: getUnique = " + result +
                                           " after setting it to " + unique);
                        System.exit(1);
                }
        }
        public static void check(SortedIntList list, Collection<Integer> result, String history)
        {
                String correct = result.toString();
                String test = list.toString();
                if (!correct.equals(test)) {
                        System.out.println("error occurred after these actions:");
                        System.out.println("    " + history);
                        System.out.println("    list should = " + correct);
                        System.out.println("    actual list = " + test);
                        System.exit(1);
                }
        }
}
