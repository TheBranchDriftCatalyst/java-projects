/*     */ package project3Beta;
/*     */ 
/*     */ public class LetterInventoryBeta
/*     */ {
/*   9 */   private int[] alphabetCount = new int[26];
/*     */   private String originalString;
/*     */   private int arraySum;
/*     */   private int arrayID;
/*     */ 
/*     */   public LetterInventoryBeta(String data)
/*     */   {
/*  22 */     this.originalString = data.replaceAll(" ", "").toLowerCase();
/*  23 */     this.arraySum = 0;
/*  24 */     this.arrayID += 1;
/*  25 */     for (int i = 0; i < this.originalString.length(); i++) {
/*  26 */       char countChar = this.originalString.charAt(i);
/*  27 */       set(countChar);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void set(char letter)
/*     */     throws IllegalArgumentException
/*     */   {
/*     */     try
/*     */     {
/*  41 */       int charToOffset = letter - 'a';
/*  42 */       this.alphabetCount[charToOffset] += 1;
/*  43 */       this.arraySum += 1;
/*     */     }
/*     */     catch (IllegalArgumentException localIllegalArgumentException)
/*     */     {
/*     */     }
/*     */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void set(char letter, int value)
/*     */   {
/*     */     try {
/*  56 */       int charToOffset = letter - 'a';
/*     */ 
/*  58 */       this.arraySum -= this.alphabetCount[charToOffset];
/*     */ 
/*  60 */       this.alphabetCount[charToOffset] = value;
/*     */ 
/*  62 */       this.arraySum += value;
/*     */     }
/*     */     catch (IllegalArgumentException localIllegalArgumentException)
/*     */     {
/*     */     }
/*     */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public int get(char letter)
/*     */   {
/*     */     try
/*     */     {
/*  81 */       int index = letter - 'a';
/*  82 */       return this.alphabetCount[index];
/*     */     }
/*     */     catch (IllegalArgumentException e) {
/*  85 */       return 0;
/*     */     } catch (ArrayIndexOutOfBoundsException e) {
/*     */     }
/*  88 */     return 0;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/* 100 */     return this.arraySum;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 110 */     return this.arraySum == 0;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 123 */     String bufferString = new String("");
/* 124 */     for (int i = 0; i < this.alphabetCount.length; i++)
/*     */     {
/* 126 */       for (int j = 0; j < this.alphabetCount[i]; j++) {
/* 127 */         char result = (char)(97 + i);
/* 128 */         bufferString = bufferString + Character.toString(result);
/*     */       }
/*     */     }
/* 131 */     return bufferString;
/*     */   }
/*     */ 
/*     */   LetterInventoryBeta add(LetterInventoryBeta other)
/*     */   {
/* 146 */     LetterInventoryBeta newAddInventory = new LetterInventoryBeta("");
/* 147 */     for (int i = 0; i < this.alphabetCount.length; i++) {
/* 148 */       this.alphabetCount[i] += other.alphabetCount[i];
/*     */     }
/* 150 */     return newAddInventory;
/*     */   }
/*     */ 
/*     */   LetterInventoryBeta subtract(LetterInventoryBeta other)
/*     */   {
/* 164 */     LetterInventoryBeta newAddInventory = new LetterInventoryBeta("");
/* 165 */     for (int i = 0; i < this.alphabetCount.length; i++) {
/* 166 */       this.alphabetCount[i] -= other.alphabetCount[i];
/* 167 */       if (newAddInventory.alphabetCount[i] < 0) {
/* 168 */         newAddInventory.alphabetCount[i] = 0;
/*     */       }
/*     */     }
/*     */ 
/* 172 */     return newAddInventory;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project3Beta.LetterInventoryBeta
 * JD-Core Version:    0.6.0
 */