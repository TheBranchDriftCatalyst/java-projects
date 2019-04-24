/*     */ package Project2;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class SortedIntList extends ArrayIntList
/*     */ {
/*     */   protected boolean uniqueOn;
/*     */   protected int[] backUpData;
/*     */   protected int backUpSize;
/*     */ 
/*     */   public SortedIntList()
/*     */   {
/*  19 */     this(100);
/*  20 */     this.uniqueOn = false;
/*     */   }
/*     */ 
/*     */   public SortedIntList(int capacity)
/*     */   {
/*  28 */     this.elementData = new int[capacity];
/*  29 */     this.size = 0;
/*  30 */     this.uniqueOn = false;
/*     */   }
/*     */ 
/*     */   public SortedIntList(boolean unique, int capacity)
/*     */   {
/*  39 */     this.elementData = new int[capacity];
/*  40 */     this.size = 0;
/*  41 */     this.uniqueOn = unique;
/*     */   }
/*     */ 
/*     */   public SortedIntList(boolean unique)
/*     */   {
/*  49 */     this(100);
/*  50 */     this.size = 0;
/*  51 */     this.uniqueOn = unique;
/*     */   }
/*     */ 
/*     */   public void add(int value)
/*     */   {
/*  65 */     if ((this.uniqueOn) && (checkDoubles(value))) {
/*  66 */       return;
/*     */     }
/*  68 */     super.add(findIndex(value), value);
/*     */   }
/*     */ 
/*     */   private int findIndex(int value)
/*     */   {
/*  79 */     int index = Arrays.binarySearch(this.elementData, 0, this.size, value);
/*  80 */     if (index < 0) {
/*  81 */       return -index - 1;
/*     */     }
/*  83 */     return index;
/*     */   }
/*     */ 
/*     */   public void add(int index, int value)
/*     */   {
/*  94 */     add(value);
/*     */   }
/*     */ 
/*     */   public int indexOf(int value)
/*     */   {
/* 103 */     int index = Arrays.binarySearch(this.elementData, 0, this.size, value);
/* 104 */     if (index < -1) {
/* 105 */       index = -1;
/*     */     }
/* 107 */     return index;
/*     */   }
/*     */ 
/*     */   private boolean checkDoubles(int value)
/*     */   {
/* 115 */     return indexOf(value) >= 0;
/*     */   }
/*     */ 
/*     */   public boolean getUnique()
/*     */   {
/* 128 */     return this.uniqueOn;
/*     */   }
/*     */ 
/*     */   public void setUnique(boolean unique)
/*     */   {
/* 139 */     if ((unique) && (!this.uniqueOn)) {
/* 140 */       this.uniqueOn = true;
/* 141 */       backUp(this.elementData, this.size);
/* 142 */       createUniqueList(); } else {
/* 143 */       if ((unique) && (this.uniqueOn)) {
/* 144 */         System.out.println("List is Already set to True, No changes Made");
/* 145 */         return;
/* 146 */       }if ((!unique) && (!this.uniqueOn)) {
/* 147 */         System.out.println("List is Already set to False, No changes Made");
/* 148 */         return;
/* 149 */       }if ((!unique) && (this.uniqueOn)) {
/* 150 */         this.uniqueOn = false;
/* 151 */         restore(this.backUpData, this.backUpSize);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void restore(int[] list, int size) {
/* 156 */     this.elementData = list;
/* 157 */     this.size = size;
/*     */   }
/*     */ 
/*     */   private void backUp(int[] list, int size) {
/* 161 */     this.backUpData = list;
/* 162 */     this.backUpSize = size;
/*     */   }
/*     */ 
/*     */   private void createUniqueList() {
/* 166 */     SortedIntList newList = new SortedIntList(true, this.size);
/* 167 */     for (int i = 0; i < this.size; i++) {
/* 168 */       int value = this.elementData[i];
/* 169 */       newList.add(value);
/*     */     }
/* 171 */     this.size = newList.size;
/* 172 */     this.elementData = newList.elementData;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.SortedIntList
 * JD-Core Version:    0.6.0
 */