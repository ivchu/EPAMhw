package hw.epam.intarraylist;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by MM8 on 21.02.2017.
 */
public class IntArrayList {

    public static void main(String[] args) {
        int[] kek = new int[]{0, 1, 2, 3, 4, 5, 6 ,7 ,8, 9};
        IntArrayList test = new IntArrayList(kek);
        System.out.println(test.binarySearch(-15));
    }

    private int[] data;
    private int size;

    public IntArrayList(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getSize() {
        return size;
    }

    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }

    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length/2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sort(){
        mergeSort(data, 0, getSize(), new int[getSize()]);
    }


    /**
     * Expects collection to be sorted.
     *
     * @param value value to find in collection
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearch(int value) {
        return indexOf(data, 0, data.length, value);
    }

    private int indexOf(int[] data, int startInclusive, int endExlusive, int value){
        final int length = endExlusive - startInclusive;
        if (length == 1) {
            if (value != data[startInclusive]){
                return -startInclusive - 1;
            } else {
                return startInclusive;
            }
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }
        final int mid = startInclusive + length / 2;
        if (value == data[mid]){
            return mid;
        } else if (value < data[mid]){
            return indexOf(data, startInclusive, mid, value);
        } else {
            return indexOf(data, mid + 1, endExlusive, value);
        }
    }

    private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length/2;

        mergeSort(data, startInclusive, mid, free);
        mergeSort(data, mid, endExclusive, free);

        merger(data, startInclusive, mid, endExclusive, free);
    }

    private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapasity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapasity);
    }

    public void mergeUpper(int[] data){
        final int len = data.length;
        final int[] free = new int[len];
        for (int mass = 1; mass < len; mass = mass + mass){
            for (int index = 0; index < len - mass; index += mass + mass){
                merger(data, index, index + mass, Math.min(index + mass + mass, len), free);
            }
        }
    }
    /*
    Probably no need
    */

    private void mergerUpper(int[] data, int startInclusive, int midExclusive, int endExclusive) {
        int[] free = new int[endExclusive];
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);
        int i = 0;
        int j = midExclusive;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= midExclusive) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }


    private int getCapacity() {
        return data.length;
    }


}
