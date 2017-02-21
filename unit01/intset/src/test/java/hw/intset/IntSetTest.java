package hw.intset;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MM8 on 19.02.2017.
 */
public class IntSetTest {

    private final static int[] TESTING_VALUES = new int[]{0, 45, -45, 432, 654, 652, 6545, -432, -43, -8648};
    private final static int[] OTHER_VALUES = new int[]{1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 32, -67};
    private final static int[] SAME_WITH_TESTING_VALUES = new int[]{0, 45, -45, 432};

    private final static IntSet TESTING_SET = new IntSet(TESTING_VALUES);
    private final static IntSet SET_WITH_SAME_ELEMENTS = new IntSet(SAME_WITH_TESTING_VALUES);
    private final static IntSet SET_OF_OTHER_VALUES = new IntSet(OTHER_VALUES);


    @Test
    public void containsTest() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
        for (int value : TESTING_VALUES) {
            assertTrue(set.contains(value));
        }


        for (int value : OTHER_VALUES) {
            assertFalse(set.contains(value));
        }
    }

    @Test
    public void removeTest() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
        set.remove(45);
        set.remove(-45);
        set.remove(0);
        assertFalse(set.contains(45));
        assertFalse(set.contains(-45));
        assertFalse(set.contains(0));
    }

    @Test
    public void add() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
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
    public void isSubsetOf() throws Exception {
        IntSet set = new IntSet(TESTING_SET);
        assertFalse(SET_OF_OTHER_VALUES.isSubsetOf(set));
        assertTrue(set.isSubsetOf(TESTING_SET));
        assertTrue(SET_WITH_SAME_ELEMENTS.isSubsetOf(set));
    }

    @Test
    public void union() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
        int[] unionValues = new int[]{13, 14, 15, 16, -15, -16};
        IntSet setForUnion = new IntSet(unionValues);

        IntSet union = set.union(setForUnion);

        for (int value : TESTING_VALUES) {
            assertTrue(union.contains(value));
        }

        for (int value : unionValues) {
            assertTrue(union.contains(value));
        }

        for (int value : OTHER_VALUES) {
            assertFalse(union.contains(value));
        }
    }

    @Test
    public void difference() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
        IntSet forDiff = new IntSet(new int[]{0, -45, 45, 432, 1, -1});

        IntSet difference = set.symmDifference(forDiff);

        assertFalse(difference.contains(0));
        assertFalse(difference.contains(45));
        assertFalse(difference.contains(-45));
        assertFalse(difference.contains(432));
        assertTrue(difference.contains(1));
        assertTrue(difference.contains(-1));
    }

    @Test
    public void intersect() throws Exception {
        IntSet set = new IntSet(TESTING_VALUES);
        int[] sameWithTestingValues = new int[]{0, 45, -45, 432, 654, 652};
        IntSet setWithSameElements = new IntSet(sameWithTestingValues);

        IntSet intersect = set.intersect(setWithSameElements);

        assertTrue(intersect.contains(0));
        assertTrue(intersect.contains(45));
        assertTrue(intersect.contains(-45));
        assertTrue(intersect.contains(432));
        assertTrue(intersect.contains(654));
        assertTrue(intersect.contains(652));

        for (int value : OTHER_VALUES) {
            assertFalse(intersect.contains(value));
        }
    }


}
