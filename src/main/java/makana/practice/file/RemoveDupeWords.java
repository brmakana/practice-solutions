package makana.practice.file;

import java.io.*;
import java.util.*;

public class RemoveDupeWords {

    public void removeDupes(Reader input, Writer output) throws IOException {
        String line;
        Map<String, Boolean> wordMap = new HashMap<>();
        try(BufferedReader in = new BufferedReader(input);
            BufferedWriter out = new BufferedWriter(output)) {
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                if (!sb.toString().isEmpty()) {
                    sb.append("\n");
                }
                String[] chunks = line.split(" ");
                Set<String> uniques = new TreeSet<>(Arrays.asList(chunks));
                Iterator<String> i = uniques.iterator();
                while (i.hasNext()) {
                    sb.append(i.next());
                    if (i.hasNext()) {
                        sb.append(" ");
                    }
                }
            }
            out.write(sb.toString());
        }
    }
}
