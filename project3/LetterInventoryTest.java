package project3;

public class LetterInventoryTest
{
        public static void main(String[] args)
        {
                String[] stringArray = { "abcdefghijklmnopqrstuvwxyz", "1289734", "aaaaaa", "ttst12#@$234" };
                int[] sizeAnswers = { 26, 0, 6, 4 };

                LetterInventory inventory0 = new LetterInventory(stringArray[0]);
                LetterInventory inventory1 = new LetterInventory(stringArray[1]);
                LetterInventory inventory2 = new LetterInventory(stringArray[2]);
                LetterInventory inventory3 = new LetterInventory(stringArray[3]);

                LetterInventory[] inventoryArray = { inventory0, inventory1, inventory2, inventory3 };

                System.out.println("Test Set 1 :: " + testSet1(stringArray, sizeAnswers, inventoryArray));
                System.out.println("Test Set 2 :: " + testSet2(stringArray, sizeAnswers, inventoryArray));
                System.out.println("Test Set 3 :: " + testSet3());
                System.out.println("Test Set 4 :: " + testSet4());
        }

        private static String testSet1(String[] stringArray, int[] sizeArray, LetterInventory[] inventoryArray)
        {
                for (int i = 0; i < stringArray.length; i++)
                        if (inventoryArray[i].size() != sizeArray[i])
                        {
                                return "Error constructing Inventory" + i + " :: Got Size " + inventoryArray[i].size() + " Should Get Size " + sizeArray[i];
                        }
                for (int i = 0; i < stringArray.length; i++) {
                        char currentChar = (char)(97 + i);
                        if ((inventoryArray[0].get(currentChar) != 1) || (inventoryArray[1].get(currentChar) != 0))
                        {
                                return "Error getting values for Inventory 0 and 1 :: Get Character '" + currentChar + "'" +
                                       " got count inventory0(" + inventoryArray[0].get(currentChar) + ")," + "inventory1(" +
                                       inventoryArray[1].get(currentChar) + ") Should of gotten 1,0";
                        }
                }
                if (inventoryArray[2].get('a') != 6) {
                        return "Error getting values for Inventory2 :: Get Character 'a' got count inventory2(" +
                               inventoryArray[2].get('a') + "), " + "Should of gotten 6";
                }

                return "Passed (All Inventories Constructed Properly)";
        }

        private static String testSet2(String[] stringArray, int[] sizeArray, LetterInventory[] inventoryArray)
        {
                for (int i = 0; i < stringArray.length; i++) {
                        char currentCharLowercase = (char)(97 + i);
                        char currentCharUppercase = (char)(65 + i);
                        if (inventoryArray[0].get(currentCharLowercase) != 1) {
                                return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentCharLowercase) + " for char " + "'" + currentCharLowercase + "'" + " should get 1";
                        }
                        if (inventoryArray[0].get(currentCharUppercase) != 1) {
                                return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentCharUppercase) + " for char " + "'" + currentCharUppercase + "'" + " should get 1";
                        }
                }

                for (int i = 0; i < stringArray.length; i++) {
                        char currentChar = (char)(65 + i);
                        if (inventoryArray[0].get(currentChar) != 1)
                        {
                                return "Error Getting Value for inventory0 :: Got " + inventoryArray[0].get(currentChar) + " for char " + "'" + currentChar + "'" + " should get 1";
                        }
                }
                try {
                        if (inventoryArray[1].get('$') != 0)
                                return "Error Getting Value for '$' in inventory1 :: Got " + inventoryArray[1].get('$') + " Should get " + 0;
                }
                catch (IllegalArgumentException e) {
                        return "Passed (All Get Tests Returned Correct Values)";
                }

                return "Failed to Catch invalid Character!";
        }

        private static String testSet3()
        {
                LetterInventory inventorySetEmpty = new LetterInventory("");
                inventorySetEmpty.set('a', 10);

                if (inventorySetEmpty.get('a') != 10) {
                        return "Error setting character 'a' :: got a = " + inventorySetEmpty.get('a') + "; should be 10";
                }
                try
                {
                        inventorySetEmpty.set('b', -10);
                } catch (IllegalArgumentException e) {
                        if (inventorySetEmpty.get('a') == 0) {
                                return "Error setting character 'a' :: got a = " + inventorySetEmpty.get('a') + "; should be 0";
                        }
                }

                return "Passed (All Values Set Correctly)";
        }

        private static String testSet4() {
                LetterInventory inventoryAdd1 = new LetterInventory("acegikmoqsuwy");
                LetterInventory inventoryAdd2 = new LetterInventory("bdfhjlnprtvxz");
                LetterInventory inventorySum = inventoryAdd1.add(inventoryAdd2);
                LetterInventory inventorySubtract = inventorySum.subtract(inventoryAdd2);

                String st1 = inventorySubtract.toString();
                String st2 = inventoryAdd1.toString();

                if (!st1.equals(st2)) {
                        return "Error Adding/Subtracting Letter Inventories";
                }
                return "Passed (All Adding and Subtracting Correct)";
        }
}
