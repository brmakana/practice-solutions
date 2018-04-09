package makana.practice.dequeue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class UniqueIntegersTest {

    @Parameterized.Parameters(name = "{index}: max unique({0},{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1 2 3 4 5 6 7", 3, 3},
                {"1 2 2 4 4 6 6", 4, 3},
                {"1 1 1 4 5 6 7 7 7", 3, 3}
        });
    }

    private String input;
    private int size;
    private int expected;

    public UniqueIntegersTest(String input, int size, int expected) {
        this.input = input;
        this.size = size;
        this.expected = expected;
    }

    @Test
    public void maxUnique() {
        UniqueIntegers u = new UniqueIntegers();
        int[] iArr = new int[input.length()];
        char[] cArr = input.toCharArray();
        for (int x = 0; x < cArr.length; x++) {
            iArr[x] = Integer.valueOf(cArr[x]);
        }
        int actual = u.maxUnique(iArr, size);
        assertEquals(expected, actual);
    }
}