package makana.practice.maps;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    private static class DataStructure {
        private Map<Integer, Integer> countsByNumber; // number -> freq count
        private Map<Integer, List<Integer>> numbersByCount; // freq count -> numbers with that freq

        public DataStructure() {
            countsByNumber = new HashMap<>();
            numbersByCount = new HashMap<>();
        }

        public void incrementCount(Integer number) {
            // update and store the new count for this number
            Integer count = countsByNumber.getOrDefault(number, 0);
            countsByNumber.put(number, count+1);
            // remove the number from the old frequency list, and add to the new
            List<Integer> numbersForOldCount = numbersByCount.getOrDefault(count, new ArrayList<>());
            if (!numbersForOldCount.isEmpty()) {
                numbersForOldCount.remove(number);
                numbersByCount.put(count, numbersForOldCount);
            }
            count += 1;
            List<Integer> numbersForNewCount = numbersByCount.getOrDefault(count, new ArrayList<>());
            numbersForNewCount.add(number);
            numbersByCount.put(count, numbersForNewCount);
        }

        public void decrementCount(Integer number) {
            Integer count = countsByNumber.getOrDefault(number, 0);
            if (count > 0) {
                countsByNumber.put(number, count - 1);
            } else {
                countsByNumber.put(number, 0);
            }
            // remove the number from the old frequency list, and add to the new
            List<Integer> numbersForOldCount = numbersByCount.getOrDefault(count, new ArrayList<>());
            if (!numbersForOldCount.isEmpty()) {
                numbersForOldCount.remove(number);
                numbersByCount.put(count, numbersForOldCount);
            }
            count -= 1;
            if (count > 0) { // don't maintain a list of numbers with 0 frequency
                List<Integer> numbersForNewCount = numbersByCount.getOrDefault(count, new ArrayList<>());
                numbersForNewCount.add(number);
                numbersByCount.put(count, numbersForNewCount);
            }
        }

        public boolean checkFrequency(Integer frequency) {
            if (frequency <= 0) {
                return false;
            }
            return numbersByCount.containsKey(frequency);
        }
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        DataStructure data = new DataStructure();
        List<Integer> results = new ArrayList<>();
        if (queries == null || queries.isEmpty()) {
            return results;
        }
        for (List<Integer> query : queries) {
            if (query.size() != 2) {
                throw new IllegalArgumentException("Query must have two integers!");
            }
            int command = query.get(0);
            int number = query.get(1);
            switch (command) {
                case 1: data.incrementCount(number); break;
                case 2: data.decrementCount(number); break;
                case 3: {
                    boolean result = data.checkFrequency(number);
                    if (result) {
                        results.add(1);
                    } else {
                        results.add(0);
                    }
                    break;
                }
                default: throw new RuntimeException("Invalid command: " + command);
            }
        }
        return results;
    }

    public static void run(BufferedReader in, BufferedWriter out) throws IOException {
        int q = Integer.parseInt(in.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(in.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        out.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        out.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        run(bufferedReader, bufferedWriter);
    }
}
