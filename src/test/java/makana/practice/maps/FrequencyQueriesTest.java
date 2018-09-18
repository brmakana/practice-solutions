package makana.practice.maps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FrequencyQueriesTest {

    @Value("classpath:maps/frequencyQueries/input.txt")
    private Resource input;

    @Value("classpath:maps/frequencyQueries/expected.txt")
    private Resource expectedOutput;

    @Test
    public void freqQuery() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,5));
        input.add(Arrays.asList(1,6));
        input.add(Arrays.asList(3,2));
        input.add(Arrays.asList(1,10));
        input.add(Arrays.asList(1,10));
        input.add(Arrays.asList(1,6));
        input.add(Arrays.asList(2,5));
        input.add(Arrays.asList(3,2));

        FrequencyQueries cut = new FrequencyQueries();
        List<Integer> result = cut.freqQuery(input);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(Integer.valueOf(0), result.get(0));
        assertEquals(Integer.valueOf(1), result.get(1));
    }

    @Test
    public void testWithLargeData() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(input.getFile()));
        StringWriter out = new StringWriter();
        BufferedWriter writer = new BufferedWriter(out);
        FrequencyQueries cut = new FrequencyQueries();
        cut.run(reader, writer);

        String msg = StreamUtils.copyToString( expectedOutput.getInputStream(), Charset.defaultCharset()  );

        assertEquals(msg, out.toString());
    }
}