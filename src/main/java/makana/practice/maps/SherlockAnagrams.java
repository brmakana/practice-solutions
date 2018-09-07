package makana.practice.maps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int anagramCount = 0;
        Map<Integer, List<String>> substringsMap = new HashMap<>();
        for (int x = 0; x < s.length(); x++) {
            for (int y = x+1; y <= s.length(); y++) {
                String sub = s.substring(x,y);
                int subLength = sub.length();
                List<String> strings;
                if (substringsMap.containsKey(subLength)) {
                    strings = substringsMap.get(subLength);
                } else {
                    strings = new ArrayList<>();
                }
                strings.add(sub);
                substringsMap.put(sub.length(), strings);
            }
        }
        for (Integer i : substringsMap.keySet()) {
            if (substringsMap.get(i).size() > 1) {
                List<String> subStrings = substringsMap.get(i);
                for (int x = 0; x < subStrings.size(); x++) {
                    for (int y = x+1; y < subStrings.size(); y++) {
                        if (isAnagram(subStrings.get(x), subStrings.get(y))) {
                            anagramCount++;
                        }
                    }
                }
            }
        }
        return anagramCount;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length() || "".equals(s1) || "".equals(s2)) {
            return false;
        }
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int x = 0; x < first.length; x++) {
            int charCount = charCountMap.getOrDefault(first[x], 0);
            charCount++;
            charCountMap.put(first[x], charCount);
        }
        int counter = 0;
        boolean failed = false;
        while (counter < first.length && !failed) {
            char c = second[counter];
            if (!charCountMap.containsKey(c)) {
                return false;
            } else if (charCountMap.get(c) == 0){
                return false;
            } else {
                int count = charCountMap.get(c);
                count--;
                charCountMap.put(c,count);
            }
            counter++;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


