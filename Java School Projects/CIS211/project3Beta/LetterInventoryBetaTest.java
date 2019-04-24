/*     */ package project3Beta;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class LetterInventoryBetaTest
/*     */ {
/*     */   static final String TEST_1_STRING = "Hoyle H. Daniels The 4th";
/*     */   static final char TEST_1_LOWERCASE = 'a';
/*     */   static final String TEST_2_STRING = "Stargate SG1; How are you doing3";
/*  29 */   static final char[] TEST_2_GET_VARIABLES = { 'H', 'z', '%', '4', 'g', 'a', 'b', '8', '@', '(' };
/*     */   static final String TEST_3_STRING = "ab3cde4fghij!!";
/*  33 */   static final char[] TEST_3_SET_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
/*  34 */   static final int[] TEST_3_SET_VALUES = new int[26];
/*     */ 
/*  36 */   static final char[] TEST_3_SET2_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
/*  37 */   static final int[] TEST_3_SET2_VALUES = { 0, 5, -1, 1, 2, 3, 5, 2, 1, 4 };
/*     */ 
/*  39 */   static final char[] TEST_3_SET3_CHARS = { 'j', 'b', '!', 'd', 'e', '%', 'g', 'h', '1', 'j' };
/*  40 */   static final int[] TEST_3_SET3_VALUES = { 0, 5, 4, 1, 2, 3, 5, 2, 1, 4 };
/*     */   static final String ADD_TEST_STRING1 = "aaaaa";
/*     */   static final String ADD_TEST_STRING2 = "bbbbb";
/*     */   static final String ADD_TEST_STRING3 = "aaa$a";
/*     */   static final String ADD_TEST_STRING4 = "bb2b";
/*     */ 
/*     */   public static String testSet1(LetterInventoryBeta inventory, String st)
/*     */   {
/*  58 */     st = st.toLowerCase().replaceAll("[^a-z//s]", "");
/*     */ 
/*  60 */     if (inventory.size() != st.length()) {
/*  61 */       return "Size Mismatch ::  Inventory Size = " + inventory.size() + ", " + "String Size = " + st.length();
/*     */     }
/*     */ 
/*  65 */     String testChar = Character.toString('a');
/*  66 */     testChar = testChar;
/*  67 */     String stTruncated = st.replaceAll("[^" + testChar + "]", "");
/*     */ 
/*  69 */     if (inventory.get('a') != stTruncated.length()) {
/*  70 */       return "Get Error a = " + inventory.get('a') + ", " + "Should be = " + stTruncated.length();
/*     */     }
/*     */ 
/*  73 */     return "Passed";
/*     */   }
/*     */ 
/*     */   public static String testSet2(LetterInventoryBeta inventory, String st)
/*     */   {
/*  89 */     for (int i = 0; i < TEST_2_GET_VARIABLES.length; i++)
/*     */     {
/*  91 */       st = st.toLowerCase().replaceAll("[^a-z//s]", "");
/*  92 */       String testChar = Character.toString(TEST_2_GET_VARIABLES[i]);
/*  93 */       testChar = testChar;
/*  94 */       String stTruncated = st.replaceAll("[^" + testChar + "]", "");
/*     */ 
/*  96 */       if (inventory.get(TEST_2_GET_VARIABLES[i]) != stTruncated.length()) {
/*  97 */         return "Get Error " + TEST_2_GET_VARIABLES[i] + " = " + inventory.get(TEST_2_GET_VARIABLES[i]) + ", " + "Should be = " + stTruncated.length();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 102 */     return "Passed";
/*     */   }
/*     */ 
/*     */   public static String testSet3(LetterInventoryBeta inventory, String st)
/*     */   {
/* 107 */     for (int i = 0; i < 26; i++) {
/* 108 */       char letter = (char)(97 + i);
/* 109 */       inventory.set(letter, 0);
/*     */     }
/* 111 */     if (inventory.size() != 0) {
/* 112 */       return "Error Test Set 3.0 When Setting Size to 0 :: Size is " + inventory.size() + " Should be " + 0;
/*     */     }
/* 114 */     int newSize = 0;
/*     */ 
/* 116 */     for (int i = 0; i < 26; i++) {
/* 117 */       char letter = (char)(97 + i);
/* 118 */       inventory.set(letter, i + 1);
/* 119 */       newSize += i + 1;
/*     */     }
/* 121 */     if (inventory.size() != newSize) {
/* 122 */       return "Error Test Set 3.1 When Setting Size to  " + newSize + " :: " + "Size is " + inventory.size() + " Should be " + newSize;
/*     */     }
/* 124 */     return "Passed";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 133 */     LetterInventoryBeta inventory1 = new LetterInventoryBeta("Hoyle H. Daniels The 4th");
/* 134 */     LetterInventoryBeta inventory2 = new LetterInventoryBeta("Stargate SG1; How are you doing3");
/* 135 */     LetterInventoryBeta inventory3 = new LetterInventoryBeta("ab3cde4fghij!!");
/*     */ 
/* 138 */     System.out.println("Test Set 1.1 :: " + testSet1(inventory1, "Hoyle H. Daniels The 4th"));
/* 139 */     System.out.println("Test Set 1.2 :: " + testSet1(inventory2, "Stargate SG1; How are you doing3"));
/* 140 */     System.out.println("Test Set 1.3 :: " + testSet1(inventory3, "ab3cde4fghij!!"));
/*     */ 
/* 143 */     System.out.println("Test Set 2.1 :: " + testSet2(inventory1, "Hoyle H. Daniels The 4th"));
/* 144 */     System.out.println("Test Set 2.2 :: " + testSet2(inventory2, "Stargate SG1; How are you doing3"));
/* 145 */     System.out.println("Test Set 2.3 :: " + testSet2(inventory3, "ab3cde4fghij!!"));
/*     */ 
/* 148 */     System.out.println("Test Set 3.1 :: " + testSet3(inventory1, "Hoyle H. Daniels The 4th"));
/* 149 */     System.out.println("Test Set 3.2 :: " + testSet3(inventory2, "Stargate SG1; How are you doing3"));
/* 150 */     System.out.println("Test Set 3.3 :: " + testSet3(inventory3, "ab3cde4fghij!!"));
/*     */ 
/* 152 */     LetterInventoryBeta inventory4 = new LetterInventoryBeta("aaaaa");
/* 153 */     LetterInventoryBeta inventory5 = new LetterInventoryBeta("bbbbb");
/* 154 */     LetterInventoryBeta inventory6 = new LetterInventoryBeta("aaa$a");
/* 155 */     LetterInventoryBeta inventory7 = new LetterInventoryBeta("bb2b");
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project3Beta.LetterInventoryBetaTest
 * JD-Core Version:    0.6.0
 */