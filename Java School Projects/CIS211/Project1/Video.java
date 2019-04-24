/*    */ package Project1;
/*    */ 
/*    */ public class Video extends LibraryItem
/*    */ {
/*    */   private double runningTime;
/*    */ 
/*    */   public Video(String title, int year, double runningTime)
/*    */   {
/* 14 */     super(title, year);
/* 15 */     this.runningTime = runningTime;
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 20 */     return "Video";
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 24 */     return super.toString() + " -- " + this.runningTime + " minutes.";
/*    */   }
/*    */   public double getRunTime() {
/* 27 */     return this.runningTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.Video
 * JD-Core Version:    0.6.0
 */