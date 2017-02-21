package hw.intset;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MM8 on 19.02.2017.
 */
public class IntSetTest {

    private static int[] testingValues = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE,
            0, 45, -45, 432, 654, 652, 6545, -432, -43, -8648};

    private static int[] otherValues = new int[]{1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 32, -67};

    private static IntSet set = new IntSet(testingValues);
    private static IntSet setOfOtherValues = new IntSet(otherValues);


    @Test
    public void containsTest() throws Exception {
        for (int value : testingValues) {
            assertTrue(set.contains(value));
        }


        for (int value : otherValues) {
            assertFalse(set.contains(value));
        }
    }

    @Test
    public void removeTest() throws Exception {
        set.remove(45);
        set.remove(-45);
        set.remove(0);
        assertFalse(set.contains(45));
        assertFalse(set.contains(-45));
        assertFalse(set.contains(0));
    }

    @Test
    public void add() throws Exception {
        set.remove(45);
        set.remove(-45);
        set.remove(0);
        set.add(45);
        set.add(-45);
        set.add(0);
        assertTrue(set.contains(45));
        assertTrue(set.contains(-45));
        assertTrue(set.contains(0));
    }

    @Test
    public void union() throws Exception {
        int[] unionValues = new int[]{13, 14, 15, 16, -15, -16};
        IntSet setForUnion = new IntSet(unionValues);

        set.union(setForUnion);

        for (int value : testingValues) {
            assertTrue(set.contains(value));
        }

        for (int value : unionValues) {
            assertTrue(set.contains(value));
        }

        for (int value : otherValues) {
            assertFalse(set.contains(value));
        }
    }

    @Test
    public void difference() throws Exception {
        int[] forDiffValues = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE,
                0, 45, -45, 432};
        IntSet forDiff = new IntSet(forDiffValues);

        IntSet difference = set.difference(forDiff);

        assertFalse(difference.contains(Integer.MIN_VALUE));
        assertFalse(difference.contains(Integer.MAX_VALUE));
        assertFalse(difference.contains(0));
        assertFalse(difference.contains(45));
        assertFalse(difference.contains(-45));
        assertFalse(difference.contains(432));

        for (int value : otherValues) {
            assertTrue(difference.contains(value));
        }
    }

    @Test
    public void intersect() throws Exception {
        int[] sameWithTestingValues = new int[]{0, 45, -45, 432, 654, 652};
        IntSet setWithSameElements = new IntSet(sameWithTestingValues);

        IntSet intersect = set.intersect(setWithSameElements);

        assertTrue(intersect.contains(0));
        assertTrue(intersect.contains(45));
        assertTrue(intersect.contains(-45));
        assertTrue(intersect.contains(432));
        assertTrue(intersect.contains(654));
        assertTrue(intersect.contains(652));

        for (int value : otherValues) {
            assertFalse(intersect.contains(value));
        }
    }

    @Test
    public void isSubsetOf() throws Exception {
        int[] sameWithTestingValues = new int[]{0, 45, -45, 432, 654, 652};
        IntSet setWithSameElements = new IntSet(sameWithTestingValues);

        assertFalse(setOfOtherValues.isSubsetOf(set));
        assertTrue(set.isSubsetOf(set));
        assertTrue(setWithSameElements.isSubsetOf(set));
    }

}
