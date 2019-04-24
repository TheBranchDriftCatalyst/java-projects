package Project1;

public class Magazine extends LibraryItem
{
        private int issueNum;

        public Magazine(String title, int year, int issueNum)
        {
                super(title, year);
                this.issueNum = issueNum;
        }

        public String getType()
        {
                return "Magazine";
        }

        public String toString() {
                return super.toString() + " -- Issue # " + this.issueNum + ".";
        }

        public int getIssue() {
                return this.issueNum;
        }
}
