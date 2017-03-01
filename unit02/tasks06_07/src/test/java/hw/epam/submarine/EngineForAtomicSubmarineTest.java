package hw.epam.submarine;

import junit.framework.TestCase;

/**
 * Created by MM8 on 01.03.2017.
 */
public class EngineForAtomicSubmarineTest extends TestCase {
    public void testAtomicSubmarineCanSail() {
        assertEquals(1, new AtomicSubmarine.EngineForAtomicSubmarine().startEngine());
    }
}