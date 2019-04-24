package project3;

public class LetterInventory
{
        private int[] alphabetCount = new int[26];
        private String originalString;
        private int size;
        private int ignoredErrors = 0;

        public int size()
        {
                return this.size;
        }

        public int getErrors()
        {
                return this.ignoredErrors;
        }

        public boolean isEmpty()
        {
                return this.size == 0;
        }

        public LetterInventory(String data)
        {
                this.originalString = data.toLowerCase();
                this.size = 0;
                for (int i = 0; i < this.originalString.length(); i++) {
                        char countChar = this.originalString.charAt(i);
                        set(countChar);
                }
        }

        private void set(char letter)
        {
                try
                {
                        if ((!Character.isLetter(letter)) || (!Character.isLowerCase(letter))) {
                                throw new IllegalArgumentException("Letter input (" + letter + ") is not a letter, or uppercase");
                        }
                        int charToOffset = letter - 'a';
                        this.alphabetCount[charToOffset] += 1;
                        this.size += 1;
                }
                catch (IllegalArgumentException e)
                {
                        this.ignoredErrors += 1;
                }
        }

        public void set(char letter, int value)
        throws IllegalArgumentException
        {
                letter = Character.toLowerCase(letter);
                if ((!Character.isLetter(letter)) || (!Character.isLowerCase(letter)))
                        throw new IllegalArgumentException("Letter input (" + letter + ") is not a letter");
                if (value < 0) {
                        throw new IllegalArgumentException("Value input (" + value + ") is invalid");
                }
                int charToOffset = letter - 'a';
                this.size -= this.alphabetCount[charToOffset];
                this.alphabetCount[charToOffset] = value;
                this.size += value;
        }

        public int get(char letter)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException
        {
                letter = Character.toLowerCase(letter);

                if (!Character.isLetter(letter)) {
                        throw new IllegalArgumentException("Letter input " + letter + " is not a letter!");
                }
                int charToOffset = letter - 'a';
                return this.alphabetCount[charToOffset];
        }

        public String toString()
        {
                String bufferString = new String("[");
                for (int i = 0; i < this.alphabetCount.length; i++)
                {
                        for (int j = 0; j < this.alphabetCount[i]; j++) {
                                char result = (char)(97 + i);
                                bufferString = bufferString + Character.toString(result);
                        }
                }

                return bufferString + "]";
        }

        LetterInventory add(LetterInventory other)
        {
                LetterInventory newAddInventory = new LetterInventory("");
                for (int i = 0; i < this.alphabetCount.length; i++) {
                        this.alphabetCount[i] += other.alphabetCount[i];
                }
                return newAddInventory;
        }

        LetterInventory subtract(LetterInventory other)
        {
                LetterInventory newAddInventory = new LetterInventory("");
                for (int i = 0; i < this.alphabetCount.length; i++) {
                        this.alphabetCount[i] -= other.alphabetCount[i];
                        if (newAddInventory.alphabetCount[i] < 0) {
                                newAddInventory.alphabetCount[i] = 0;
                        }
                }

                return newAddInventory;
        }
}
