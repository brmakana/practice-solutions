package makana.practice.file;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class RemoveDupeWordsTest {

    @Test
    public void removeDupes() throws IOException {
        StringReader in = new StringReader("a b c d e f g h i j k l m n o p a b c d e f g h i j k l m n o p qqqqq rrrr");
        StringWriter out = new StringWriter();
        RemoveDupeWords cut = new RemoveDupeWords();
        cut.removeDupes(new BufferedReader(in), new BufferedWriter(out));
        String expected = "a b c d e f g h i j k l m n o p qqqqq rrrr";
        String actual = out.toString();
        assertEquals(expected, actual);
    }
}