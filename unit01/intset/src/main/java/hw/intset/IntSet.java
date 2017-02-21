package hw.intset;


/**
 * Created by MM8 on 19.02.2017.
 */
public class IntSet {
    private long[][] data = new long[][]{{0}, {0}};

    public IntSet() {

    }

    public IntSet(long[][] data) {
        this.data = data;
    }

    public IntSet(int value) {
        add(value);
    }

    public IntSet(int[] data) {
        for (int forAdd : data) {
            add(forAdd);
        }
    }

    public void remove(int value) {
        getArray(value)[getInsertIndex(value)] &= ~(1L << Math.abs(value));
    }

    public void add(int value) {
        resize(value);
        data[getArrayIndex(value)][getInsertIndex(value)] |= 1L << Math.abs(value);
    }

    public boolean contains(int value) {
        if (getInsertIndex(value) > getArray(value).length) {
            return false;
        }
        final long mask = 1L << Math.abs(value);
        final long res = data[getArrayIndex(value)][getInsertIndex(value)] & mask;
        return res != 0;
    }

    public IntSet union(IntSet other) {
        long[][] result = new long[2][];
        int shortArray;
        int longArray;
        for (int i = 0; i < 2; i++) {
            if (this.getData()[i].length > other.getData()[i].length) {
                longArray = this.getData()[i].length;
                shortArray = other.getData()[i].length;
            } else {
                longArray = other.getData()[i].length;
                shortArray = this.getData()[i].length;
            }
            long[] temp = new long[longArray];
            System.arraycopy(this.getData()[i], 0, temp, 0, longArray);
            for (int j = 0; j < shortArray; j++) {
                temp[j] |= other.getData()[i][j];
            }
            result[i] = temp;
        }
        return new IntSet(result);
    }

    public IntSet difference(IntSet other) {
        int commonWords = Math.min(getSize(), other.getSize());
        int maxLength = Math.max(getSize(), other.getSize());

        long[] newData = new long[getSize() < other.getSize() ? getSize() : other.getSize()];

        for (int i = 0; i < commonWords; i++) {
            newData[i] = getData()[i] ^ other.getData()[i];
        }

        if (commonWords < other.getSize()) {
            System.arraycopy(other.data,
                    commonWords,
                    newData,
                    commonWords,
                    maxLength - commonWords);
        }
        return new IntSet(newData);
        return null;
    }

    public IntSet intersect(IntSet other) {
        int newLength;
        if (this.getData().length > other.getData().length) {
            newLength = this.getData().length;
        } else {
            newLength = other.getData().length;
        }
        final long[] result = new long[newLength];
        for (int i = 0; i < newLength; i++) {
            result[i] = this.getData()[i] & other.getData()[i];
        }
        return new IntSet(result);
        return null;
    }


    public boolean isSubsetOf(IntSet other) {
        int newLength;
        if (other.getData().length < this.getData().length) {
            return false;
        }
        for (int i = 0; i < this.getData().length; i++) {
            if (this.getData()[i] == 0) {
                continue;
            }
            if (this.getData()[i] != other.getData()[i]) {
                return false;
            }
        }
        return true;
    }

    private void resize(int value) {
        int insertIndex = getInsertIndex(value);
        long[] arrayForInsert = getArray(value);

        if (insertIndex >= arrayForInsert.length) {
            final long[] result = new long[insertIndex + 1];
            System.arraycopy(arrayForInsert, 0, result, 0, arrayForInsert.length);
            this.data[getArrayIndex(value)] = result;
        }
    }

    private long[] getArray(int value) {
        return data[getArrayIndex(value)];
    }

    private int getArrayIndex(int value) {
        if (value < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getInsertIndex(int value) {
        return Math.abs(value / 64);
    }

    public long[][] getData() {
        return data;
    }
}
