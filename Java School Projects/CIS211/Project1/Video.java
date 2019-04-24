package Project1;
/*    */
public class Video extends LibraryItem
{
        private double runningTime;
/*    */
        public Video(String title, int year, double runningTime)
        {
                super(title, year);
                this.runningTime = runningTime;
        }
/*    */
        public String getType()
        {
                return "Video";
        }
/*    */
        public String toString() {
                return super.toString() + " -- " + this.runningTime + " minutes.";
        }
        public double getRunTime() {
                return this.runningTime;
        }
}
