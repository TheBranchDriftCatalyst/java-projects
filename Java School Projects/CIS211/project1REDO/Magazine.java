package project1REDO;

public class Magazine extends LibraryItem {

        private int issueNum;

        public Magazine(String title, int year, int issueNum) {
                super(title, year);
                this.issueNum = issueNum;
        }

        @Override
        public String getType() {
                return "Magazine";
        }

        public String toString(){
                return super.toString() + "Issue number: " + this.issueNum;
        }

        public int getIssue(){
                return this.issueNum;
        }
}
