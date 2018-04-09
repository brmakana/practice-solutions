package makana.practice.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class UniqueIntegers {

    public int maxUnique(int[] array, int subsize) {
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int x = 0; x < array.length; x++) {
            if (x >= subsize) {
                int old = deque.remove();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.put(old, map.get(old) -1);
                }
            }
            deque.add(array[x]);
            map.merge(array[x], 1, Integer::sum);
            max = Math.max(map.size(), max);
        }
        return max;
    }

}
