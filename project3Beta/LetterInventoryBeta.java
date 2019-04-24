package project3Beta;

public class LetterInventoryBeta
{
        private int[] alphabetCount = new int[26];
        private String originalString;
        private int arraySum;
        private int arrayID;

        public LetterInventoryBeta(String data)
        {
                this.originalString = data.replaceAll(" ", "").toLowerCase();
                this.arraySum = 0;
                this.arrayID += 1;
                for (int i = 0; i < this.originalString.length(); i++) {
                        char countChar = this.originalString.charAt(i);
                        set(countChar);
                }
        }

        private void set(char letter)
        throws IllegalArgumentException
        {
                try
                {
                        int charToOffset = letter - 'a';
                        this.alphabetCount[charToOffset] += 1;
                        this.arraySum += 1;
                }
                catch (IllegalArgumentException localIllegalArgumentException)
                {
                }
                catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
                {
                }
        }

        public void set(char letter, int value)
        {
                try {
                        int charToOffset = letter - 'a';

                        this.arraySum -= this.alphabetCount[charToOffset];

                        this.alphabetCount[charToOffset] = value;

                        this.arraySum += value;
                }
                catch (IllegalArgumentException localIllegalArgumentException)
                {
                }
                catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
                {
                }
        }

        public int get(char letter)
        {
                try
                {
                        int index = letter - 'a';
                        return this.alphabetCount[index];
                }
                catch (IllegalArgumentException e) {
                        return 0;
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                return 0;
        }

        public int size()
        {
                return this.arraySum;
        }

        public boolean isEmpty()
        {
                return this.arraySum == 0;
        }

        public String toString()
        {
                String bufferString = new String("");
                for (int i = 0; i < this.alphabetCount.length; i++)
                {
                        for (int j = 0; j < this.alphabetCount[i]; j++) {
                                char result = (char)(97 + i);
                                bufferString = bufferString + Character.toString(result);
                        }
                }
                return bufferString;
        }

        LetterInventoryBeta add(LetterInventoryBeta other)
        {
                LetterInventoryBeta newAddInventory = new LetterInventoryBeta("");
                for (int i = 0; i < this.alphabetCount.length; i++) {
                        this.alphabetCount[i] += other.alphabetCount[i];
                }
                return newAddInventory;
        }

        LetterInventoryBeta subtract(LetterInventoryBeta other)
        {
                LetterInventoryBeta newAddInventory = new LetterInventoryBeta("");
                for (int i = 0; i < this.alphabetCount.length; i++) {
                        this.alphabetCount[i] -= other.alphabetCount[i];
                        if (newAddInventory.alphabetCount[i] < 0) {
                                newAddInventory.alphabetCount[i] = 0;
                        }
                }

                return newAddInventory;
        }
}
