package makana.practice.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewYearChaosTest {

    @Test
    public void minimumBribes() {
        NewYearChaos cut = new NewYearChaos();
        int[] input = {2,1,5,3,4};
        int expected = 3;
        int actual = cut.minimumBribes(input);
        assertEquals(expected,actual);
    }
}