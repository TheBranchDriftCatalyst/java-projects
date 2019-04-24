package project1REDO;

public class LibraryTest {
    public static void main(String args[])
    {
        // Construct a new example of each type
        Book b = new Book("Frankenstein", 1818, "Mary", "Shelley", 100);
        VideoTape v = new VideoTape("Tron", 1982, 96);
        DVD dvd = new DVD("Blade Runner", 1982, 112, 12);
        Magazine m = new Magazine("Newsweek", 2010, 6);

        // Use accessors to print out some descriptive sentences.
        System.out.println(b.getTitle() + " was written by " +
            b.getAuthorFirst() + " " + b.getAuthorLast() + " and has "
            + b.getNumPages() + " pages.");

        System.out.println(dvd.getTitle() + " was released in " +
            dvd.getYear() + " and has a runtime of " + dvd.getRunTime() +
            " minutes, split into " + dvd.getNumChapters() + " chapters.");

        System.out.println("Magazine copy of " + m.getTitle() + ", issue " 
            + m.getIssue() + " from " + m.getYear());

        // Place items in an array and sort them
        LibraryItem[] items = {b, v, dvd, m};
        java.util.Arrays.sort(items);

        // Print out the sorted list
        for (LibraryItem i: items) {
            System.out.println(i.getTitle() + " is a " + i.getType());
            System.out.println("Full description: " + i);
        }

        // Check out some items.  (This code should already work.)
        b.setCheckedOut(true);
        v.setCheckedOut(true);

        // Check the book back in.  (This code should already work.)
        b.setCheckedOut(false);
    }
}
