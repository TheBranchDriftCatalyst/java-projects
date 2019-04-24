package Project1;

public class VideoTape extends Video
{
        public VideoTape(String title, int year, double runningTime)
        {
                super(title, year, runningTime);
        }

        public String getType()
        {
                return super.getType() + " Tape";
        }
}
