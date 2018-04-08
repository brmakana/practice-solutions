package makana.practice.stacks;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public void add(int x) {
        min.add(x);
        while (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }

    public double median() {
        if (min.isEmpty() && max.isEmpty()) {
            return 0;
        } else if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2d;
        } else {
            return min.peek();
        }
    }
}
