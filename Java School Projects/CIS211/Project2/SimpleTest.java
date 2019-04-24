/*    */ package Project2;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class SimpleTest
/*    */ {
/*    */   private static int randomNum(int x)
/*    */   {
/* 10 */     int ranNum = 1 + (int)(Math.random() * x);
/* 11 */     return ranNum;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 15 */     SortedIntList list = new SortedIntList(false, 300);
/* 16 */     SortedIntList list2 = new SortedIntList(true, 300);
/*    */ 
/* 18 */     for (int i = 0; i < 300; i++) {
/* 19 */       int num = randomNum(300);
/* 20 */       list.add(num);
/* 21 */       list2.add(num);
/*    */     }
/*    */ 
/* 24 */     System.out.println("list = " + list);
/* 25 */     System.out.println("size = " + list.size());
/* 26 */     System.out.println("list = " + list.size);
/* 27 */     System.out.println("uniqueness = " + list.getUnique());
/*    */ 
/* 29 */     System.out.println("list2 = " + list2);
/* 30 */     System.out.println("size2 = " + list2.size());
/* 31 */     System.out.println("list2 = " + list2.size);
/* 32 */     System.out.println("uniqueness2 = " + list2.getUnique());
/*    */ 
/* 36 */     System.out.println("Setting List to Unique = true");
/* 37 */     list.setUnique(true);
/*    */ 
/* 39 */     System.out.println("list = " + list);
/* 40 */     System.out.println("size = " + list.size());
/* 41 */     System.out.println("list = " + list.size);
/* 42 */     System.out.println("uniqueness = " + list.getUnique());
/*    */ 
/* 44 */     System.out.println("Reseting List Back to False");
/* 45 */     list.setUnique(false);
/*    */ 
/* 47 */     System.out.println("list = " + list);
/* 48 */     System.out.println("size = " + list.size());
/* 49 */     System.out.println("list = " + list.size);
/* 50 */     System.out.println("uniqueness = " + list.getUnique());
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.SimpleTest
 * JD-Core Version:    0.6.0
 */