/*    */ package Project1;
/*    */ 
/*    */ public class Magazine extends LibraryItem
/*    */ {
/*    */   private int issueNum;
/*    */ 
/*    */   public Magazine(String title, int year, int issueNum)
/*    */   {
/* 15 */     super(title, year);
/* 16 */     this.issueNum = issueNum;
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 21 */     return "Magazine";
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 25 */     return super.toString() + " -- Issue # " + this.issueNum + ".";
/*    */   }
/*    */ 
/*    */   public int getIssue() {
/* 29 */     return this.issueNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.Magazine
 * JD-Core Version:    0.6.0
 */