package makana.practice.multiple;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TruckTourTest {

    private TruckTour cut;

    @Before
    public void start() {
        cut = new TruckTour();
    }

    @Test
    public void has_enough_fuel() {
        String input = "3\n1 5\n10 3\n3 4";
        StringReader stringReader = new StringReader(input);
        Scanner scanner = new Scanner(stringReader);
        int expected = 1;
        int actual = cut.truckTour(scanner);
        scanner.close();
        assertEquals(expected,actual);

    }

    @Value("classpath:multiple/TruckTour.txt")
    private Resource inputFile;

    @Test
    public void load_from_file() throws Exception {
        Scanner scanner = new Scanner(inputFile.getFile());
        int expected = 573;
        int actual = cut.truckTour(scanner);
        scanner.close();
        assertEquals(expected,actual);
    }
}