package makana.practice.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of integers, with each element representing a plant with a number of applications
 * of pesticide. If a plant has more applications of pesticide than it's previous neighbor, it dies.
 * Calculate the number of days until no plants die.
 */
public class PoisonousPlants {
    public static int poisonousPlants(int[] p) {
        int days = 0;
        List<LinkedList<Integer>> all = listify(p);
        while (all.size() > 1) {
            popAndMerge(all);
            days++;
        }
        return days;
    }

    public static void popAndMerge(List<LinkedList<Integer>> all) {
        if (all == null || all.isEmpty()) {
            return;
        }
        Iterator<LinkedList<Integer>> iterator = all.iterator();
        LinkedList<Integer> last = iterator.next();
        while (iterator.hasNext()) {
            LinkedList<Integer> current = iterator.next();
            current.pop();
            if (current.isEmpty()) {
                iterator.remove();
            } else if (current.getFirst() <= last.getLast()) {
                last.addAll(current);
                iterator.remove();
            } else {
                last = current;
            }
        }
    }

    public static List<LinkedList<Integer>> listify(int[] p) {
        List<LinkedList<Integer>> all = new LinkedList<>();
        LinkedList<Integer> one = new LinkedList<>();
        one.add(p[0]);
        all.add(one);
        LinkedList<Integer> latest = one;
        for (int x = 1; x < p.length; x++) {
            int e = p[x];
            if (latest.getLast() >= e) {
                latest.add(e);
            } else {
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(e);
                all.add(newList);
                latest = newList;
            }
        }
        return all;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] p = new int[n];
        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }
        int result = poisonousPlants(p);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
