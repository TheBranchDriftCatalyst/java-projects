/*    */ package Project2;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import java.util.TreeSet;
/*    */ 
/*    */ public class Test2
/*    */ {
/*    */   public static final int TEST_SIZE = 25;
/*    */   public static final int MAX_INT = 10;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 24 */     System.out.println("Testing SortedIntList()");
/* 25 */     SortedIntList list = new SortedIntList();
/* 26 */     test(list, 100, false);
/*    */ 
/* 28 */     System.out.println("Testing SortedIntList(25)");
/* 29 */     list = new SortedIntList(25);
/* 30 */     test(list, 25, false);
/*    */ 
/* 32 */     System.out.println("Testing SortedIntList(false)");
/* 33 */     list = new SortedIntList(false);
/* 34 */     test(list, 100, false);
/*    */ 
/* 36 */     System.out.println("Testing SortedIntList(true)");
/* 37 */     list = new SortedIntList(true);
/* 38 */     test(list, 100, true);
/*    */ 
/* 40 */     System.out.println("Testing SortedIntList(false, 25)");
/* 41 */     list = new SortedIntList(false, 25);
/* 42 */     test(list, 25, false);
/*    */ 
/* 44 */     System.out.println("Testing SortedIntList(true, 25)");
/* 45 */     list = new SortedIntList(true, 25);
/* 46 */     test(list, 25, true);
/*    */   }
/*    */ 
/*    */   public static void test(SortedIntList list, int size, boolean unique)
/*    */   {
/* 53 */     List result = new ArrayList();
/* 54 */     String history = "";
/* 55 */     Random r = new Random();
/*    */ 
/* 57 */     for (int i = 0; i < size; i++) {
/* 58 */       int next = r.nextInt(10);
/* 59 */       history = history + " " + next;
/* 60 */       result.add(Integer.valueOf(next));
/* 61 */       Collections.sort(result);
/* 62 */       list.add(next);
/*    */       String correct;
/*    */       
/* 64 */       if (unique)
/* 65 */         correct = new TreeSet(result).toString();
/*    */       else {
/* 67 */         correct = result.toString();
/*    */       }
/* 69 */       String test = list.toString();
/* 70 */       if (!correct.equals(test)) {
/* 71 */         System.out.println("error when adding these values to list:" + 
/* 72 */           history);
/* 73 */         System.out.println("list should = " + correct);
/* 74 */         System.out.println("actual list = " + test);
/* 75 */         if (result.size() > 1) {
/* 76 */           System.out.println("was working properly prior to adding last value of " + 
/* 77 */             next);
/*    */         }
/* 79 */         System.exit(1);
/*    */       }
/*    */     }
/* 82 */     System.out.println("    Passed");
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.Test2
 * JD-Core Version:    0.6.0
 */