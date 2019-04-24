/*     */ package project3;
/*     */ 
/*     */ public class LetterInventoryTest
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  13 */     String[] stringArray = { "abcdefghijklmnopqrstuvwxyz", "1289734", "aaaaaa", "ttst12#@$234" };
/*  14 */     int[] sizeAnswers = { 26, 0, 6, 4 };
/*     */ 
/*  16 */     LetterInventory inventory0 = new LetterInventory(stringArray[0]);
/*  17 */     LetterInventory inventory1 = new LetterInventory(stringArray[1]);
/*  18 */     LetterInventory inventory2 = new LetterInventory(stringArray[2]);
/*  19 */     LetterInventory inventory3 = new LetterInventory(stringArray[3]);
/*     */ 
/*  21 */     LetterInventory[] inventoryArray = { inventory0, inventory1, inventory2, inventory3 };
/*     */ 
/*  23 */     System.out.println("Test Set 1 :: " + testSet1(stringArray, sizeAnswers, inventoryArray));
/*  24 */     System.out.println("Test Set 2 :: " + testSet2(stringArray, sizeAnswers, inventoryArray));
/*  25 */     System.out.println("Test Set 3 :: " + testSet3());
/*  26 */     System.out.println("Test Set 4 :: " + testSet4());
/*     */   }
/*     */ 
/*     */   private static String testSet1(String[] stringArray, int[] sizeArray, LetterInventory[] inventoryArray)
/*     */   {
/*  40 */     for (int i = 0; i < stringArray.length; i++)
/*  41 */       if (inventoryArray[i].size() != sizeArray[i])
/*     */       {
/*  44 */         return "Error constructing Inventory" + i + " :: Got Size " + inventoryArray[i].size() + " Should Get Size " + sizeArray[i];
/*     */       }
/*  46 */     for (int i = 0; i < stringArray.length; i++) {
/*  47 */       char currentChar = (char)(97 + i);
/*  48 */       if ((inventoryArray[0].get(currentChar) != 1) || (inventoryArray[1].get(currentChar) != 0))
/*     */       {
/*  51 */         return "Error getting values for Inventory 0 and 1 :: Get Character '" + currentChar + "'" + 
/*  52 */           " got count inventory0(" + inventoryArray[0].get(currentChar) + ")," + "inventory1(" + 
/*  53 */           inventoryArray[1].get(currentChar) + ") Should of gotten 1,0";
/*     */       }
/*     */     }
/*  55 */     if (inventoryArray[2].get('a') != 6) {
/*  56 */       return "Error getting values for Inventory2 :: Get Character 'a' got count inventory2(" + 
/*  57 */         inventoryArray[2].get('a') + "), " + "Should of gotten 6";
/*     */     }
/*     */ 
/*  60 */     return "Passed (All Inventories Constructed Properly)";
/*     */   }
/*     */ 
/*     */   private static String testSet2(String[] stringArray, int[] sizeArray, LetterInventory[] inventoryArray)
/*     */   {
/*  75 */     for (int i = 0; i < stringArray.length; i++) {
/*  76 */       char currentCharLowercase = (char)(97 + i);
/*  77 */       char currentCharUppercase = (char)(65 + i);
/*  78 */       if (inventoryArray[0].get(currentCharLowercase) != 1) {
/*  79 */         return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentCharLowercase) + " for char " + "'" + currentCharLowercase + "'" + " should get 1";
/*     */       }
/*  81 */       if (inventoryArray[0].get(currentCharUppercase) != 1) {
/*  82 */         return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentCharUppercase) + " for char " + "'" + currentCharUppercase + "'" + " should get 1";
/*     */       }
/*     */     }
/*     */ 
/*  86 */     for (int i = 0; i < stringArray.length; i++) {
/*  87 */       char currentChar = (char)(65 + i);
/*  88 */       if (inventoryArray[0].get(currentChar) != 1)
/*     */       {
/*  91 */         return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentChar) + " for char " + "'" + currentChar + "'" + " should get 1";
/*     */       }
/*     */     }
/*     */     try {
/*  94 */       if (inventoryArray[1].get('$') != 0)
/*  95 */         return "Error Getting Value for '$' in inventory1 :: Got " + inventoryArray[1].get('$') + " Should get " + 0;
/*     */     }
/*     */     catch (IllegalArgumentException e) {
/*  98 */       return "Passed (All Get Tests Returned Correct Values)";
/*     */     }
/*     */ 
/* 101 */     return "Failed to Catch invalid Character!";
/*     */   }
/*     */ 
/*     */   private static String testSet3()
/*     */   {
/* 113 */     LetterInventory inventorySetEmpty = new LetterInventory("");
/* 114 */     inventorySetEmpty.set('a', 10);
/*     */ 
/* 116 */     if (inventorySetEmpty.get('a') != 10) {
/* 117 */       return "Error setting character 'a' :: got a = " + inventorySetEmpty.get('a') + "; should be 10";
/*     */     }
/*     */     try
/*     */     {
/* 121 */       inventorySetEmpty.set('b', -10);
/*     */     } catch (IllegalArgumentException e) {
/* 123 */       if (inventorySetEmpty.get('a') == 0) {
/* 124 */         return "Error setting character 'a' :: got a = " + inventorySetEmpty.get('a') + "; should be 0";
/*     */       }
/*     */     }
/*     */ 
/* 128 */     return "Passed (All Values Set Correctly)";
/*     */   }
/*     */ 
/*     */   private static String testSet4() {
/* 132 */     LetterInventory inventoryAdd1 = new LetterInventory("acegikmoqsuwy");
/* 133 */     LetterInventory inventoryAdd2 = new LetterInventory("bdfhjlnprtvxz");
/* 134 */     LetterInventory inventorySum = inventoryAdd1.add(inventoryAdd2);
/* 135 */     LetterInventory inventorySubtract = inventorySum.subtract(inventoryAdd2);
/*     */ 
/* 137 */     String st1 = inventorySubtract.toString();
/* 138 */     String st2 = inventoryAdd1.toString();
/*     */ 
/* 140 */     if (!st1.equals(st2)) {
/* 141 */       return "Error Adding/Subtracting Letter Inventories";
/*     */     }
/* 143 */     return "Passed (All Adding and Subtracting Correct)";
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project3.LetterInventoryTest
 * JD-Core Version:    0.6.0
 */