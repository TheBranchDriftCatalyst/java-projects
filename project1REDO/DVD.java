package project1REDO;

public class DVD extends Video {

        private int chapterCount;

        public DVD(String title, int year, int runTime, int chapterCount) {
                super(title, year, runTime);
                this.chapterCount = chapterCount;
        }

        @Override
        public String getType() {
                return "DVD";
        }

        public String toString(){
                return super.toString() + "Number of Chapters: " + this.chapterCount;

        }

        public int getNumChapters(){
                return chapterCount;
        }



}
