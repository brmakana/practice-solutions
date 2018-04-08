package makana.practice.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunningMedianTest {

    @Test
    public void one() {
        double expected = 1d;
        int[] input = new int[]{1};
        RunningMedian m = new RunningMedian();
        for (int x = 0; x < input.length; x++) {
            m.add(input[x]);
        }
        assertEquals(expected, m.median(), 0d);
    }

    @Test
    public void two() {
        double expected = 2d;
        int[] input = new int[]{2, 2};
        RunningMedian m = new RunningMedian();
        for (int x = 0; x < input.length; x++) {
            m.add(input[x]);
        }
        assertEquals(expected, m.median(), 0d);
    }

    @Test
    public void three() {
        double expected = 2d;
        int[] input = new int[]{1, 2, 3};
        RunningMedian m = new RunningMedian();
        for (int x = 0; x < input.length; x++) {
            m.add(input[x]);
        }
        assertEquals(expected, m.median(), 0d);
    }

    @Test
    public void four() {
        double expected = 5d;
        int[] input = new int[]{1, 5, 5, 10};
        RunningMedian m = new RunningMedian();
        for (int x = 0; x < input.length; x++) {
            m.add(input[x]);
        }
        assertEquals(expected, m.median(), 0d);
    }

    @Test
    public void five() {
        double expected = 5d;
        int[] input = new int[]{1, 5, 4, 5, 6};
        RunningMedian m = new RunningMedian();
        for (int x = 0; x < input.length; x++) {
            m.add(input[x]);
        }
        assertEquals(expected, m.median(), 0d);
    }
}