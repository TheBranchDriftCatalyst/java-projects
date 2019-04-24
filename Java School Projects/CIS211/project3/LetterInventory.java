/*     */ package project3;
/*     */ 
/*     */ public class LetterInventory
/*     */ {
/*   5 */   private int[] alphabetCount = new int[26];
/*     */   private String originalString;
/*     */   private int size;
/*   8 */   private int ignoredErrors = 0;
/*     */ 
/*     */   public int size()
/*     */   {
/*  18 */     return this.size;
/*     */   }
/*     */ 
/*     */   public int getErrors()
/*     */   {
/*  26 */     return this.ignoredErrors;
/*     */   }
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/*  38 */     return this.size == 0;
/*     */   }
/*     */ 
/*     */   public LetterInventory(String data)
/*     */   {
/*  50 */     this.originalString = data.toLowerCase();
/*  51 */     this.size = 0;
/*  52 */     for (int i = 0; i < this.originalString.length(); i++) {
/*  53 */       char countChar = this.originalString.charAt(i);
/*  54 */       set(countChar);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void set(char letter)
/*     */   {
/*     */     try
/*     */     {
/*  68 */       if ((!Character.isLetter(letter)) || (!Character.isLowerCase(letter))) {
/*  69 */         throw new IllegalArgumentException("Letter input (" + letter + ") is not a letter, or uppercase");
/*     */       }
/*  71 */       int charToOffset = letter - 'a';
/*  72 */       this.alphabetCount[charToOffset] += 1;
/*  73 */       this.size += 1;
/*     */     }
/*     */     catch (IllegalArgumentException e)
/*     */     {
/*  77 */       this.ignoredErrors += 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void set(char letter, int value)
/*     */     throws IllegalArgumentException
/*     */   {
/*  88 */     letter = Character.toLowerCase(letter);
/*  89 */     if ((!Character.isLetter(letter)) || (!Character.isLowerCase(letter)))
/*  90 */       throw new IllegalArgumentException("Letter input (" + letter + ") is not a letter");
/*  91 */     if (value < 0) {
/*  92 */       throw new IllegalArgumentException("Value input (" + value + ") is invalid");
/*     */     }
/*  94 */     int charToOffset = letter - 'a';
/*  95 */     this.size -= this.alphabetCount[charToOffset];
/*  96 */     this.alphabetCount[charToOffset] = value;
/*  97 */     this.size += value;
/*     */   }
/*     */ 
/*     */   public int get(char letter)
/*     */     throws IllegalArgumentException, ArrayIndexOutOfBoundsException
/*     */   {
/* 109 */     letter = Character.toLowerCase(letter);
/*     */ 
/* 111 */     if (!Character.isLetter(letter)) {
/* 112 */       throw new IllegalArgumentException("Letter input " + letter + " is not a letter!");
/*     */     }
/* 114 */     int charToOffset = letter - 'a';
/* 115 */     return this.alphabetCount[charToOffset];
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 132 */     String bufferString = new String("[");
/* 133 */     for (int i = 0; i < this.alphabetCount.length; i++)
/*     */     {
/* 135 */       for (int j = 0; j < this.alphabetCount[i]; j++) {
/* 136 */         char result = (char)(97 + i);
/* 137 */         bufferString = bufferString + Character.toString(result);
/*     */       }
/*     */     }
/*     */ 
/* 141 */     return bufferString + "]";
/*     */   }
/*     */ 
/*     */   LetterInventory add(LetterInventory other)
/*     */   {
/* 154 */     LetterInventory newAddInventory = new LetterInventory("");
/* 155 */     for (int i = 0; i < this.alphabetCount.length; i++) {
/* 156 */       this.alphabetCount[i] += other.alphabetCount[i];
/*     */     }
/* 158 */     return newAddInventory;
/*     */   }
/*     */ 
/*     */   LetterInventory subtract(LetterInventory other)
/*     */   {
/* 171 */     LetterInventory newAddInventory = new LetterInventory("");
/* 172 */     for (int i = 0; i < this.alphabetCount.length; i++) {
/* 173 */       this.alphabetCount[i] -= other.alphabetCount[i];
/* 174 */       if (newAddInventory.alphabetCount[i] < 0) {
/* 175 */         newAddInventory.alphabetCount[i] = 0;
/*     */       }
/*     */     }
/*     */ 
/* 179 */     return newAddInventory;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project3.LetterInventory
 * JD-Core Version:    0.6.0
 */