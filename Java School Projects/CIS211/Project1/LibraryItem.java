/*     */ package Project1;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public abstract class LibraryItem
/*     */   implements Comparable<LibraryItem>
/*     */ {
/*     */   private String title;
/*     */   private int year;
/*     */   private boolean checkedOut;
/*     */ 
/*     */   public LibraryItem(String title, int year)
/*     */   {
/*  20 */     this.title = title;
/*  21 */     this.year = year;
/*  22 */     this.checkedOut = false;
/*     */   }
/*     */ 
/*     */   public void setCheckedOut(boolean checkedOut)
/*     */   {
/*  28 */     if (this.checkedOut != checkedOut) {
/*  29 */       this.checkedOut = checkedOut;
/*  30 */       System.out.println("Item " + this.title + " is now checked-" + (
/*  31 */         checkedOut ? "out" : "in"));
/*     */     } else {
/*  33 */       System.out.println("Item was already checked " + (
/*  34 */         checkedOut ? "out" : "in") + "!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean checkedOut()
/*     */   {
/*  40 */     return this.checkedOut;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  44 */     return this.title;
/*     */   }
/*     */ 
/*     */   public int getYear() {
/*  48 */     return this.year;
/*     */   }
/*     */ 
/*     */   public int compareTo(LibraryItem other)
/*     */   {
/*  58 */     String title1 = this.title.toUpperCase().replaceAll(" ", "");
/*  59 */     String title2 = other.title.toUpperCase().replaceAll(" ", "");
/*  60 */     char ch1 = title1.charAt(0);
/*  61 */     char ch2 = title2.charAt(0);
/*     */ 
/*  63 */     if (title1.equalsIgnoreCase(title2))
/*  64 */       return 0;
/*  65 */     if (ch1 > ch2)
/*  66 */       return 1;
/*  67 */     if (ch1 < ch2) {
/*  68 */       return -1;
/*     */     }
/*     */ 
/*  72 */     return compareUtil(title1, title2);
/*     */   }
/*     */ 
/*     */   private int compareUtil(String title1, String title2)
/*     */   {
/*  84 */     for (int i = 0; (i < title1.length()) || (i < title2.length()); i++) {
/*  85 */       if (title1.charAt(i) != title2.charAt(i)) {
/*  86 */         if (title1.charAt(i) > title2.charAt(i)) {
/*  87 */           return 1;
/*     */         }
/*  89 */         return -1;
/*     */       }
/*     */     }
/*  92 */     System.out.println("ERROR COMAPRE UTIL: " + title1 + ", " + title2);
/*  93 */     return -2;
/*     */   }
/*     */ 
/*     */   public abstract String getType();
/*     */ 
/*     */   public String toString()
/*     */   {
/* 102 */     return getType() + " -- " + this.title + " (" + this.year + ")";
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.LibraryItem
 * JD-Core Version:    0.6.0
 */