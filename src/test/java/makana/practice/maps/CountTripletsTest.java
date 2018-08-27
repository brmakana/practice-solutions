package makana.practice.maps;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountTripletsTest {

    @AllArgsConstructor
    private static class InputData {
        private List<Long> input;
        private long commonRatio;
        private long expectedCount;
    }

    private InputData inputData;

    public CountTripletsTest(InputData data) {
        this.inputData = data;
    }

    @Parameterized.Parameters(name = "{index}")
    public static Iterable<InputData> data() {
        List<InputData> data = new ArrayList<>();
        data.add(new InputData(Arrays.asList(1L, 4L, 16L, 64L), 4, 2));
        data.add(new InputData(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3, 6));
        return data;
    }


    @Test
    public void simpleList() {
        CountTriplets cut = new CountTriplets();
        long actual = CountTriplets.countTriplets(inputData.input, inputData.commonRatio);
        assertEquals(inputData.expectedCount, actual);
    }

    @Test
    public void longerList() {

    }
}