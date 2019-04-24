package Project1;
public class Book extends LibraryItem
{
        private String firstName;
        private String lastName;
        private int pages;
        public Book(String title, int year, String firstName, String lastName, int pages)
        {
                super(title, year);
                this.firstName = firstName;
                this.lastName = lastName;
                this.pages = pages;
        }
        public String getType()
        {
                return "Book";
        }
        public String toString() {
                return super.toString() + " -- Author: " + this.lastName + ", " + this.firstName + ". " + this.pages + " pages.";
        }
        public String getAuthorFirst() {
                return this.firstName;
        }
        public String getAuthorLast() {
                return this.lastName;
        }
        public int getNumPages() {
                return this.pages;
        }
}
