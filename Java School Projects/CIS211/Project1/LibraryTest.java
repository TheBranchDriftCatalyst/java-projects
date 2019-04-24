package Project1;

import java.io.PrintStream;
import java.util.Arrays;

public class LibraryTest
{
        public static void main(String[] args)
        {
                Book a = new Book("Frankenstein", 1818, "Mary", "Shelley", 100);
                Book b = new Book("Fankenstein", 1818, "Mary", "Shelley", 100);
                VideoTape c = new VideoTape("Tron", 1982, 96.0D);
                DVD d = new DVD("Blade Runner", 1982, 112.0D, 12);
                Magazine e = new Magazine("Newsweek", 2010, 6);

                Book f = new Book("bade runner", 1818, "Mary", "Shelley", 100);
                Book g = new Book("123", 1818, "Mary", "Shelley", 100);
                VideoTape h = new VideoTape("123", 1982, 96.0D);
                DVD ii = new DVD("321 butt", 1982, 112.0D, 12);
                Magazine j = new Magazine("Fox", 2010, 6);

                LibraryItem[] items = { a, b, c, d, e, f, g, h, ii, j };
                Arrays.sort(items);

                for (LibraryItem i : items) {
                        System.out.println(i.getTitle() + " is a " + i.getType());
                        System.out.println("Full description: " + i);
                }

                b.setCheckedOut(true);
                a.setCheckedOut(true);
                h.setCheckedOut(true);

                b.setCheckedOut(false);

                System.out.println(c.compareTo(e));
                System.out.println(a.compareTo(e));
                System.out.println(h.compareTo(a));
                System.out.println(b.compareTo(ii));
        }
}
