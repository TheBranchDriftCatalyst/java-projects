/*     */ package Project2;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ 
/*     */ public class Test3
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  22 */     for (int testSize = 0; testSize < 25; testSize++) {
/*  23 */       System.out.print("Testing with size " + testSize + ": ");
/*  24 */       for (int i = 0; i < 10; i++) {
/*  25 */         SortedIntList list1 = new SortedIntList(testSize);
/*  26 */         testTrue(list1, testSize);
/*  27 */         SortedIntList list2 = new SortedIntList(2 * testSize);
/*  28 */         testFalse(list2, testSize);
/*     */       }
/*  30 */       System.out.println("Passed");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void testTrue(SortedIntList list, int testSize)
/*     */   {
/*  36 */     Set result = new TreeSet();
/*  37 */     String history = "adding with unique=true:";
/*  38 */     Random r = new Random();
/*     */ 
/*  40 */     setAndTestUnique(list, true);
/*     */ 
/*  44 */     while (result.size() < testSize) {
/*  45 */       int next = r.nextInt(testSize);
/*  46 */       history = history + " " + next;
/*  47 */       result.add(Integer.valueOf(next));
/*  48 */       list.add(next);
/*  49 */       check(list, result, history);
/*     */     }
/*     */ 
/*  53 */     setAndTestUnique(list, false);
/*  54 */     setAndTestUnique(list, true);
/*  55 */     check(list, result, history);
/*     */ 
/*  58 */     for (int i = 0; i < testSize * 10; i++) {
/*  59 */       int next = r.nextInt(testSize);
/*  60 */       history = history + " " + next;
/*  61 */       list.add(next);
/*  62 */       result.add(Integer.valueOf(next));
/*  63 */       check(list, result, history);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void testFalse(SortedIntList list, int testSize)
/*     */   {
/*  69 */     List result = new ArrayList();
/*  70 */     String history = "adding with unique=false:";
/*  71 */     Random r = new Random();
/*     */ 
/*  73 */     setAndTestUnique(list, false);
/*     */ 
/*  76 */     while (result.size() < testSize) {
/*  77 */       int next = r.nextInt(testSize);
/*  78 */       if (!result.contains(Integer.valueOf(next))) {
/*  79 */         history = history + " " + next;
/*  80 */         result.add(Integer.valueOf(next));
/*  81 */         Collections.sort(result);
/*  82 */         list.add(next);
/*  83 */         check(list, result, history);
/*     */       }
/*     */     }
/*     */ 
/*  87 */     for (int i = 1; i <= testSize; i++) {
/*  88 */       int next = r.nextInt(testSize);
/*  89 */       history = history + " " + next;
/*  90 */       result.add(Integer.valueOf(next));
/*  91 */       Collections.sort(result);
/*  92 */       list.add(next);
/*  93 */       check(list, result, history);
/*     */     }
/*     */ 
/*  97 */     setAndTestUnique(list, true);
/*  98 */     history = history + " unique=true";
/*  99 */     result = new ArrayList(new TreeSet(result));
/* 100 */     check(list, new TreeSet(result), history);
/*     */ 
/* 103 */     setAndTestUnique(list, false);
/* 104 */     history = history + " unique=false";
/* 105 */     for (int i = 1; i <= testSize; i++) {
/* 106 */       int next = r.nextInt(testSize);
/* 107 */       history = history + " " + next;
/* 108 */       result.add(Integer.valueOf(next));
/* 109 */       Collections.sort(result);
/* 110 */       list.add(next);
/* 111 */       check(list, result, history);
/*     */     }
/*     */ 
/* 115 */     setAndTestUnique(list, true);
/* 116 */     history = history + " unique=true";
/* 117 */     check(list, new TreeSet(result), history);
/*     */   }
/*     */ 
/*     */   public static void setAndTestUnique(SortedIntList list, boolean unique)
/*     */   {
/* 123 */     list.setUnique(unique);
/* 124 */     boolean result = list.getUnique();
/* 125 */     if (result != unique) {
/* 126 */       System.out.println(" error: getUnique = " + result + 
/* 127 */         " after setting it to " + unique);
/* 128 */       System.exit(1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void check(SortedIntList list, Collection<Integer> result, String history)
/*     */   {
/* 135 */     String correct = result.toString();
/* 136 */     String test = list.toString();
/* 137 */     if (!correct.equals(test)) {
/* 138 */       System.out.println("error occurred after these actions:");
/* 139 */       System.out.println("    " + history);
/* 140 */       System.out.println("    list should = " + correct);
/* 141 */       System.out.println("    actual list = " + test);
/* 142 */       System.exit(1);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.Test3
 * JD-Core Version:    0.6.0
 */