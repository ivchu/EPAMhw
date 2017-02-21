package hw.intset;


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

    public IntSet(IntSet intset) {
        this.data = intset.getData();
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
        long[] shortArray;
        long[] longArray;
        for (int i = 0; i < 2; i++) {
            if (this.getData()[i].length > other.getData()[i].length) {
                longArray = this.getData()[i];
                shortArray = other.getData()[i];
            } else {
                longArray = other.getData()[i];
                shortArray = this.getData()[i];
            }
            long[] temp = new long[longArray.length];
            System.arraycopy(longArray, 0, temp, 0, longArray.length);
            for (int j = 0; j < shortArray.length; j++) {
                temp[j] |= other.getData()[i][j];
            }
            result[i] = temp;
        }
        return new IntSet(result);
    }

    public IntSet difference(IntSet other) {
        long[][] result = new long[2][];
        int shortArrayLength;
        int longArrayLength;
        for (int i = 0; i < 2; i++) {
            shortArrayLength = Math.min(this.getData()[i].length, other.getData()[i].length);
            longArrayLength = Math.max(this.getData()[i].length, other.getData()[i].length);
            long[] temp = new long[longArrayLength];
            System.arraycopy(this.getData()[i].length > other.getData()[i].length ? this.getData()[i] : other.getData()[i]
                    , shortArrayLength, temp, shortArrayLength, longArrayLength - shortArrayLength);
            for (int j = 0; j < shortArrayLength; j++) {
                temp[j] = this.getData()[i][j] ^ other.getData()[i][j];
            }
            result[i] = temp;
        }
        return new IntSet(result);
    }

    public IntSet intersect(IntSet other) {
        long[][] result = new long[2][];
        int shortArrayLength;
        int longArrayLength;
        for (int i = 0; i < 2; i++) {
            if (this.getData()[i].length > other.getData()[i].length) {
                longArrayLength = this.getData()[i].length;
                shortArrayLength = other.getData()[i].length;
            } else {
                longArrayLength = other.getData()[i].length;
                shortArrayLength = this.getData()[i].length;
            }
            long[] temp = new long[longArrayLength];
            System.arraycopy(this.getData()[i].length > other.getData()[i].length ? this.getData()[i] : other.getData()[i]
                    , 0, temp, 0, longArrayLength);
            for (int j = 0; j < shortArrayLength; j++) {
                temp[j] &= other.getData()[i][j];
            }
            result[i] = temp;
        }
        return new IntSet(result);
    }

    public boolean isSubsetOf(IntSet other) {
        for (int i = 0; i < 2; i++) {
            if (other.getData()[i].length < this.getData()[i].length) {
                return false;
            }
            for (int j = 0; j < this.getData()[i].length; j++) {
                if (this.getData()[i][j] == 0) {
                    continue;
                }
                if ((this.getData()[i][j] & other.getData()[i][j]) == 0) {
                    return false;
                }
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
