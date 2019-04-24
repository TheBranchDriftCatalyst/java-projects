package project1REDO;

public class Book extends LibraryItem {
        private String authorFirst;
        private String authorLast;
        private int pageCount;

        public Book(String title, int year, String authorFirst, String authorLast, int pageCount) {
                super(title, year);
                this.authorFirst = authorFirst;
                this.authorLast = authorLast;
                this.pageCount = pageCount;

        }

        @Override
        public String getType() {
                // TODO Auto-generated method stub
                return "Book";
        }

        public String toString(){

                return super.toString() + "Author: " + this.authorLast + ", " + this.authorFirst + ".  " + this.pageCount + " pages.";

        }

        public String getAuthorFirst(){
                return this.authorFirst;
        }

        public String getAuthorLast(){
                return this.authorLast;
        }

        public int getNumPages(){
                return this.pageCount;
        }

}
