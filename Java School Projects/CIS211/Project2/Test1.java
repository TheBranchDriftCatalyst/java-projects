/*     */ package Project2;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Test1
/*     */ {
/*     */   public static final int BASIC_TEST_SIZE = 10;
/*     */   public static final int SPEED_TEST_SIZE = 100000;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  28 */     checkAdd(10);
/*  29 */     checkIndexOf(10);
/*  30 */     checkSpeed(100000);
/*     */   }
/*     */ 
/*     */   public static void checkAdd(int testSize)
/*     */   {
/*  37 */     System.out.println("Beginning basic add test of size " + testSize);
/*  38 */     SortedIntList list = new SortedIntList(testSize);
/*  39 */     List result = new ArrayList();
/*  40 */     String history = "";
/*  41 */     Random r = new Random();
/*  42 */     for (int i = 0; i < testSize; i++)
/*     */     {
/*  44 */       int next = r.nextInt(2 * testSize + 1) - testSize;
/*  45 */       history = history + " " + next;
/*  46 */       result.add(Integer.valueOf(next));
/*  47 */       Collections.sort(result);
/*  48 */       list.add(next);
/*  49 */       boolean sizeOK = result.size() == list.size();
/*  50 */       boolean toStringOK = result.toString().equals(list.toString());
/*  51 */       if ((!sizeOK) || (!toStringOK)) {
/*  52 */         System.out.println("wrong size or toString when adding these values to list:" + 
/*  53 */           history);
/*  54 */         System.out.println("size should       = " + result.size());
/*  55 */         System.out.println("toString should   = " + result.toString());
/*  56 */         System.out.println("actual size       = " + list.size());
/*  57 */         System.out.println("actual toString   = " + list.toString());
/*  58 */         if (result.size() > 1) {
/*  59 */           System.out.println("size and ToString were working properly prior to adding last value of " + 
/*  61 */             next);
/*     */         }
/*  63 */         System.exit(1);
/*     */       } else {
/*  65 */         for (int j = 0; j < result.size(); j++) {
/*  66 */           if (list.get(j) != ((Integer)result.get(j)).intValue()) {
/*  67 */             System.out.println("wrong value for get(" + j + ")");
/*  68 */             System.out.println("list = " + result.toString());
/*  69 */             System.out.println("get should   = " + result.get(j));
/*  70 */             System.out.println("get actually = " + list.get(j));
/*  71 */             System.exit(1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  76 */     System.out.println("    Passed");
/*  77 */     System.out.println();
/*     */   }
/*     */ 
/*     */   public static void checkIndexOf(int testSize)
/*     */   {
/*  84 */     System.out.println("Beginning basic indexOf test of size " + testSize);
/*  85 */     SortedIntList list = new SortedIntList(testSize);
/*  86 */     List result = new ArrayList();
/*  87 */     Random r = new Random();
/*  88 */     checkIndexes(testSize, result, list);
/*  89 */     for (int i = 0; i < testSize; i++)
/*     */     {
/*  91 */       int next = r.nextInt(2 * testSize + 1) - testSize;
/*  92 */       result.add(Integer.valueOf(next));
/*  93 */       Collections.sort(result);
/*  94 */       list.add(next);
/*  95 */       checkIndexes(testSize, result, list);
/*     */     }
/*  97 */     System.out.println("    Passed");
/*  98 */     System.out.println();
/*     */   }
/*     */ 
/*     */   public static void checkSpeed(int testSize)
/*     */   {
/* 104 */     System.out.println("Beginning speed test of size " + testSize);
/*     */ 
/* 106 */     long start = System.currentTimeMillis();
/*     */ 
/* 108 */     int dot = testSize / 75;
/* 109 */     SortedIntList list = new SortedIntList(testSize);
/* 110 */     System.out.println("construction--should take a fraction of a second");
/* 111 */     System.out.println("done after 75 dots:");
/* 112 */     for (int i = 0; i < testSize; i++) {
/* 113 */       list.add(2 * i);
/* 114 */       if (i % dot == 0)
/* 115 */         System.out.print(".");
/*     */     }
/* 117 */     System.out.println();
/* 118 */     double elapsed = (System.currentTimeMillis() - start) / 1000.0D;
/* 119 */     System.out.println("construction took " + elapsed + " seconds");
/* 120 */     System.out.println();
/*     */ 
/* 123 */     start = System.currentTimeMillis();
/* 124 */     System.out.println("searching list--should take a second or two");
/* 125 */     System.out.println("done after 75 dots:");
/* 126 */     for (int i = 0; i < testSize; i++) {
/* 127 */       if (i % dot == 0)
/* 128 */         System.out.print(".");
/* 129 */       for (int j = 0; j < 100; j++) {
/* 130 */         int index = list.indexOf(2 * i);
/* 131 */         if (index != i) {
/* 132 */           System.out.println("wrong value for indexOf(" + 2 * i + ")");
/* 133 */           System.out.println("indexOf should = " + i);
/* 134 */           System.out.println("actual indexOf = " + index);
/* 135 */           System.exit(1);
/*     */         }
/*     */       }
/*     */     }
/* 139 */     System.out.println();
/* 140 */     elapsed = (System.currentTimeMillis() - start) / 1000.0D;
/* 141 */     System.out.println("searching took " + elapsed + " seconds");
/*     */   }
/*     */ 
/*     */   public static boolean checkIndexes(int testSize, List<Integer> result, SortedIntList list)
/*     */   {
/* 148 */     for (int i = -testSize; i < testSize; i++) {
/* 149 */       int index = list.indexOf(i);
/*     */       boolean bad;
/*     */      
/* 151 */       if (result.indexOf(Integer.valueOf(i)) == -1)
/* 152 */         bad = index != -1;
/*     */       else {
/* 154 */         bad = (index < 0) || (((Integer)result.get(index)).intValue() != i);
/*     */       }
/* 156 */       if (bad) {
/* 157 */         System.out.println("wrong value for indexOf(" + i + ")");
/* 158 */         System.out.println("list = " + result.toString());
/* 159 */         if (result.indexOf(Integer.valueOf(i)) == -1) {
/* 160 */           System.out.println("indexOf should = -1");
/* 161 */           System.out.println("actual indexOf = " + index);
/*     */         } else {
/* 163 */           System.out.println("indexOf is returning " + index);
/* 164 */           System.out.println(i + " is not at that index");
/*     */         }
/* 166 */         System.exit(1);
/*     */       }
/*     */     }
/* 169 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.Test1
 * JD-Core Version:    0.6.0
 */