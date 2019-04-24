package Project2;

public class ArrayIntList
{
        protected int[] elementData;
        protected int size;
        public static final int DEFAULT_CAPACITY = 100;

        public ArrayIntList()
        {
                this(100);
        }

        public ArrayIntList(int capacity)
        {
                this.elementData = new int[capacity];
                this.size = 0;
        }

        public int size()
        {
                return this.size;
        }

        public int get(int index)
        {
                return this.elementData[index];
        }

        public String toString()
        {
                if (this.size == 0) {
                        return "[]";
                }
                String result = "[" + this.elementData[0];
                for (int i = 1; i < this.size; i++) {
                        result = result + ", " + this.elementData[i];
                }
                result = result + "]";
                return result;
        }

        public int indexOf(int value)
        {
                for (int i = 0; i < this.size; i++) {
                        if (this.elementData[i] == value) {
                                return i;
                        }
                }
                return -1;
        }

        public void add(int value)
        {
                this.elementData[this.size] = value;
                this.size += 1;
        }

        public void add(int index, int value)
        {
                for (int i = this.size; i >= index + 1; i--) {
                        this.elementData[i] = this.elementData[(i - 1)];
                }
                this.elementData[index] = value;
                this.size += 1;
        }

        public void remove(int index)
        {
                for (int i = index; i < this.size - 1; i++) {
                        this.elementData[i] = this.elementData[(i + 1)];
                }
                this.size -= 1;
        }
}
