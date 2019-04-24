/*    */ package Project1;
/*    */ 
/*    */ public class DVD extends Video
/*    */ {
/*    */   private int chapters;
/*    */ 
/*    */   public DVD(String title, int year, double runningTime, int chapters)
/*    */   {
/* 15 */     super(title, year, runningTime);
/* 16 */     this.chapters = chapters;
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 21 */     return "DVD";
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 26 */     return super.toString() + " " + this.chapters + " chapters.";
/*    */   }
/*    */   public int getNumChapters() {
/* 29 */     return this.chapters;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.DVD
 * JD-Core Version:    0.6.0
 */