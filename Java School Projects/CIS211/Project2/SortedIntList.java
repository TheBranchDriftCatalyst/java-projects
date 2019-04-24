package Project2;

import java.io.PrintStream;
import java.util.Arrays;

public class SortedIntList extends ArrayIntList
{
        protected boolean uniqueOn;
        protected int[] backUpData;
        protected int backUpSize;

        public SortedIntList()
        {
                this(100);
                this.uniqueOn = false;
        }

        public SortedIntList(int capacity)
        {
                this.elementData = new int[capacity];
                this.size = 0;
                this.uniqueOn = false;
        }

        public SortedIntList(boolean unique, int capacity)
        {
                this.elementData = new int[capacity];
                this.size = 0;
                this.uniqueOn = unique;
        }

        public SortedIntList(boolean unique)
        {
                this(100);
                this.size = 0;
                this.uniqueOn = unique;
        }

        public void add(int value)
        {
                if ((this.uniqueOn) && (checkDoubles(value))) {
                        return;
                }
                super.add(findIndex(value), value);
        }

        private int findIndex(int value)
        {
                int index = Arrays.binarySearch(this.elementData, 0, this.size, value);
                if (index < 0) {
                        return -index - 1;
                }
                return index;
        }

        public void add(int index, int value)
        {
                add(value);
        }

        public int indexOf(int value)
        {
                int index = Arrays.binarySearch(this.elementData, 0, this.size, value);
                if (index < -1) {
                        index = -1;
                }
                return index;
        }

        private boolean checkDoubles(int value)
        {
                return indexOf(value) >= 0;
        }

        public boolean getUnique()
        {
                return this.uniqueOn;
        }

        public void setUnique(boolean unique)
        {
                if ((unique) && (!this.uniqueOn)) {
                        this.uniqueOn = true;
                        backUp(this.elementData, this.size);
                        createUniqueList();
                } else {
                        if ((unique) && (this.uniqueOn)) {
                                System.out.println("List is Already set to True, No changes Made");
                                return;
                        } if ((!unique) && (!this.uniqueOn)) {
                                System.out.println("List is Already set to False, No changes Made");
                                return;
                        } if ((!unique) && (this.uniqueOn)) {
                                this.uniqueOn = false;
                                restore(this.backUpData, this.backUpSize);
                        }
                }
        }

        private void restore(int[] list, int size) {
                this.elementData = list;
                this.size = size;
        }

        private void backUp(int[] list, int size) {
                this.backUpData = list;
                this.backUpSize = size;
        }

        private void createUniqueList() {
                SortedIntList newList = new SortedIntList(true, this.size);
                for (int i = 0; i < this.size; i++) {
                        int value = this.elementData[i];
                        newList.add(value);
                }
                this.size = newList.size;
                this.elementData = newList.elementData;
        }
}
