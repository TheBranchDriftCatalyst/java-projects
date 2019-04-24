/*     */ package Project2;
/*     */ 
/*     */ public class ArrayIntList
/*     */ {
/*     */   protected int[] elementData;
/*     */   protected int size;
/*     */   public static final int DEFAULT_CAPACITY = 100;
/*     */ 
/*     */   public ArrayIntList()
/*     */   {
/*  14 */     this(100);
/*     */   }
/*     */ 
/*     */   public ArrayIntList(int capacity)
/*     */   {
/*  22 */     this.elementData = new int[capacity];
/*  23 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  31 */     return this.size;
/*     */   }
/*     */ 
/*     */   public int get(int index)
/*     */   {
/*  41 */     return this.elementData[index];
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  50 */     if (this.size == 0) {
/*  51 */       return "[]";
/*     */     }
/*  53 */     String result = "[" + this.elementData[0];
/*  54 */     for (int i = 1; i < this.size; i++) {
/*  55 */       result = result + ", " + this.elementData[i];
/*     */     }
/*  57 */     result = result + "]";
/*  58 */     return result;
/*     */   }
/*     */ 
/*     */   public int indexOf(int value)
/*     */   {
/*  70 */     for (int i = 0; i < this.size; i++) {
/*  71 */       if (this.elementData[i] == value) {
/*  72 */         return i;
/*     */       }
/*     */     }
/*  75 */     return -1;
/*     */   }
/*     */ 
/*     */   public void add(int value)
/*     */   {
/*  83 */     this.elementData[this.size] = value;
/*  84 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void add(int index, int value)
/*     */   {
/*  94 */     for (int i = this.size; i >= index + 1; i--) {
/*  95 */       this.elementData[i] = this.elementData[(i - 1)];
/*     */     }
/*  97 */     this.elementData[index] = value;
/*  98 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void remove(int index)
/*     */   {
/* 107 */     for (int i = index; i < this.size - 1; i++) {
/* 108 */       this.elementData[i] = this.elementData[(i + 1)];
/*     */     }
/* 110 */     this.size -= 1;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project2.ArrayIntList
 * JD-Core Version:    0.6.0
 */