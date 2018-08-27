package makana.practice.maps;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long tripletCount = 0;
        if (arr == null || arr.size() < 3) {
            return 0;
        }
        Map<Long, Long> multMap = new HashMap<>();
        Map<Long, Long> countMap = new HashMap<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);
            if (countMap.containsKey(a * r)) {
                tripletCount += countMap.get(a * r);
            }
            if (multMap.containsKey(a * r)) {
                long c = multMap.get(a * r);
                countMap.put(a, countMap.getOrDefault(a, 0L) + c);
            }
            multMap.put(a, multMap.getOrDefault(a, 0L) + 1);
        }

        return tripletCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
