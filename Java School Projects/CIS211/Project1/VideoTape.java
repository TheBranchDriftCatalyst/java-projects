/*    */ package Project1;
/*    */ 
/*    */ public class VideoTape extends Video
/*    */ {
/*    */   public VideoTape(String title, int year, double runningTime)
/*    */   {
/* 13 */     super(title, year, runningTime);
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 18 */     return super.getType() + " Tape";
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.VideoTape
 * JD-Core Version:    0.6.0
 */