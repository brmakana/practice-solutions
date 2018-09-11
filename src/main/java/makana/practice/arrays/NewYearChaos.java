package makana.practice.arrays;

import java.util.Scanner;

public class NewYearChaos {

    static int minimumBribes(int[] input) {
        int count = 0;
        for (int x = input.length-1; x >= 0; x--) {
            if (input[x] - (x+1) > 2) {
                return -1;
            }
            for (int y = Math.max(0,input[x]-2); y < x; y++) {
                if (input[y] > input[x]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            int answer = minimumBribes(q);
            if (answer >= 0) {
                System.out.println(answer);
            } else {
                System.out.println("Too chaotic");
            }
        }

        scanner.close();
    }
}

