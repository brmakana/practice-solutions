package makana.practice.stacks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BalancedStringTest {

    @Parameterized.Parameters(name = "{index}: isBalanced({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"()(){}[]", true},
                {"((()))", true},
                {"[[[]]]", true},
                {"{{{}}}", true},
                {"{[()]}", true},
                {"(([]))", true},
                {"[][}", false},
                {"[[}}", false}
        });
    }

    private String input;
    private boolean expected;

    public BalancedStringTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void isBalanced() {
        assertEquals(expected, BalancedString.isBalanced(input));
    }
}