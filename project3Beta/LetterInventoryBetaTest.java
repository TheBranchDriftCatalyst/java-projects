package project3Beta;

import java.io.PrintStream;

public class LetterInventoryBetaTest
{
        static final String TEST_1_STRING = "Hoyle H. Daniels The 4th";
        static final char TEST_1_LOWERCASE = 'a';
        static final String TEST_2_STRING = "Stargate SG1; How are you doing3";
        static final char[] TEST_2_GET_VARIABLES = { 'H', 'z', '%', '4', 'g', 'a', 'b', '8', '@', '(' };
        static final String TEST_3_STRING = "ab3cde4fghij!!";
        static final char[] TEST_3_SET_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        static final int[] TEST_3_SET_VALUES = new int[26];

        static final char[] TEST_3_SET2_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        static final int[] TEST_3_SET2_VALUES = { 0, 5, -1, 1, 2, 3, 5, 2, 1, 4 };

        static final char[] TEST_3_SET3_CHARS = { 'j', 'b', '!', 'd', 'e', '%', 'g', 'h', '1', 'j' };
        static final int[] TEST_3_SET3_VALUES = { 0, 5, 4, 1, 2, 3, 5, 2, 1, 4 };
        static final String ADD_TEST_STRING1 = "aaaaa";
        static final String ADD_TEST_STRING2 = "bbbbb";
        static final String ADD_TEST_STRING3 = "aaa$a";
        static final String ADD_TEST_STRING4 = "bb2b";

        public static String testSet1(LetterInventoryBeta inventory, String st)
        {
                st = st.toLowerCase().replaceAll("[^a-z//s]", "");

                if (inventory.size() != st.length()) {
                        return "Size Mismatch ::  Inventory Size = " + inventory.size() + ", " + "String Size = " + st.length();
                }

                String testChar = Character.toString('a');
                testChar = testChar;
                String stTruncated = st.replaceAll("[^" + testChar + "]", "");

                if (inventory.get('a') != stTruncated.length()) {
                        return "Get Error a = " + inventory.get('a') + ", " + "Should be = " + stTruncated.length();
                }

                return "Passed";
        }

        public static String testSet2(LetterInventoryBeta inventory, String st)
        {
                for (int i = 0; i < TEST_2_GET_VARIABLES.length; i++)
                {
                        st = st.toLowerCase().replaceAll("[^a-z//s]", "");
                        String testChar = Character.toString(TEST_2_GET_VARIABLES[i]);
                        testChar = testChar;
                        String stTruncated = st.replaceAll("[^" + testChar + "]", "");

                        if (inventory.get(TEST_2_GET_VARIABLES[i]) != stTruncated.length()) {
                                return "Get Error " + TEST_2_GET_VARIABLES[i] + " = " + inventory.get(TEST_2_GET_VARIABLES[i]) + ", " + "Should be = " + stTruncated.length();
                        }

                }

                return "Passed";
        }

        public static String testSet3(LetterInventoryBeta inventory, String st)
        {
                for (int i = 0; i < 26; i++) {
                        char letter = (char)(97 + i);
                        inventory.set(letter, 0);
                }
                if (inventory.size() != 0) {
                        return "Error Test Set 3.0 When Setting Size to 0 :: Size is " + inventory.size() + " Should be " + 0;
                }
                int newSize = 0;

                for (int i = 0; i < 26; i++) {
                        char letter = (char)(97 + i);
                        inventory.set(letter, i + 1);
                        newSize += i + 1;
                }
                if (inventory.size() != newSize) {
                        return "Error Test Set 3.1 When Setting Size to  " + newSize + " :: " + "Size is " + inventory.size() + " Should be " + newSize;
                }
                return "Passed";
        }

        public static void main(String[] args)
        {
                LetterInventoryBeta inventory1 = new LetterInventoryBeta("Panda Man");
                LetterInventoryBeta inventory2 = new LetterInventoryBeta("Stargate SG1; How are you doing3");
                LetterInventoryBeta inventory3 = new LetterInventoryBeta("ab3cde4fghij!!");

                System.out.println("Test Set 1.1 :: " + testSet1(inventory1, "Panda Man"));
                System.out.println("Test Set 1.2 :: " + testSet1(inventory2, "Stargate SG1; How are you doing3"));
                System.out.println("Test Set 1.3 :: " + testSet1(inventory3, "ab3cde4fghij!!"));

                System.out.println("Test Set 2.1 :: " + testSet2(inventory1, "Panda Man"));
                System.out.println("Test Set 2.2 :: " + testSet2(inventory2, "Stargate SG1; How are you doing3"));
                System.out.println("Test Set 2.3 :: " + testSet2(inventory3, "ab3cde4fghij!!"));

                System.out.println("Test Set 3.1 :: " + testSet3(inventory1, "Panda Man"));
                System.out.println("Test Set 3.2 :: " + testSet3(inventory2, "Stargate SG1; How are you doing3"));
                System.out.println("Test Set 3.3 :: " + testSet3(inventory3, "ab3cde4fghij!!"));

                LetterInventoryBeta inventory4 = new LetterInventoryBeta("aaaaa");
                LetterInventoryBeta inventory5 = new LetterInventoryBeta("bbbbb");
                LetterInventoryBeta inventory6 = new LetterInventoryBeta("aaa$a");
                LetterInventoryBeta inventory7 = new LetterInventoryBeta("bb2b");
        }
}
