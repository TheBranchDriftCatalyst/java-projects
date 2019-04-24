package Project1;
public class DVD extends Video
{
        private int chapters;
        public DVD(String title, int year, double runningTime, int chapters)
        {
                super(title, year, runningTime);
                this.chapters = chapters;
        }
        public String getType()
        {
                return "DVD";
        }
        public String toString()
        {
                return super.toString() + " " + this.chapters + " chapters.";
        }
        public int getNumChapters() {
                return this.chapters;
        }
}
