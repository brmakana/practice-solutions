package makana.practice.maps;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SherlockAnagramsTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "mom", 2 },
                { "abcd", 0 },
                { "abba", 4 }
        });
    }
    private String inputString;
    private int expectedCount;

    public SherlockAnagramsTest(String input, int expected) {
        this.inputString = input;
        this.expectedCount = expected;
    }

    private SherlockAnagrams cut;

    @Before
    public void start() {
        cut = new SherlockAnagrams();
    }

    @Test
    public void sherlockAndAnagrams() {
        System.out.println("Checking string " + inputString + ", expected count: " + expectedCount);
        int actual = cut.sherlockAndAnagrams(inputString);
        System.out.println("Actual count: " + actual);
        assertEquals(expectedCount, actual);
    }

}