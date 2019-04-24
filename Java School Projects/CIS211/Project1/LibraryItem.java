package Project1;
import java.io.PrintStream;
public abstract class LibraryItem
        implements Comparable<LibraryItem>
{
        private String title;
        private int year;
        private boolean checkedOut;
        public LibraryItem(String title, int year)
        {
                this.title = title;
                this.year = year;
                this.checkedOut = false;
        }
        public void setCheckedOut(boolean checkedOut)
        {
                if (this.checkedOut != checkedOut) {
                        this.checkedOut = checkedOut;
                        System.out.println("Item " + this.title + " is now checked-" + (
                                                   checkedOut ? "out" : "in"));
                } else {
                        System.out.println("Item was already checked " + (
                                                   checkedOut ? "out" : "in") + "!");
                }
        }
        public boolean checkedOut()
        {
                return this.checkedOut;
        }
        public String getTitle() {
                return this.title;
        }
        public int getYear() {
                return this.year;
        }
        public int compareTo(LibraryItem other)
        {
                String title1 = this.title.toUpperCase().replaceAll(" ", "");
                String title2 = other.title.toUpperCase().replaceAll(" ", "");
                char ch1 = title1.charAt(0);
                char ch2 = title2.charAt(0);
                if (title1.equalsIgnoreCase(title2))
                        return 0;
                if (ch1 > ch2)
                        return 1;
                if (ch1 < ch2) {
                        return -1;
                }
                return compareUtil(title1, title2);
        }
        private int compareUtil(String title1, String title2)
        {
                for (int i = 0; (i < title1.length()) || (i < title2.length()); i++) {
                        if (title1.charAt(i) != title2.charAt(i)) {
                                if (title1.charAt(i) > title2.charAt(i)) {
                                        return 1;
                                }
                                return -1;
                        }
                }
                System.out.println("ERROR COMAPRE UTIL: " + title1 + ", " + title2);
                return -2;
        }
        public abstract String getType();
        public String toString()
        {
                return getType() + " -- " + this.title + " (" + this.year + ")";
        }
}
