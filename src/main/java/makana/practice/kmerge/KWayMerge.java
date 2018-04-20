package makana.practice.kmerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {

    private PriorityQueue<Node> queue;

    public KWayMerge() {
        queue = new PriorityQueue<>(new NodeComparator());
    }

    public List<Integer> merge(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        if (lists == null) {
            return null;
        }
        if (lists.isEmpty()) {
            return result;
        }
        int[] indexes = new int[lists.size()];
        populateHeap(lists, indexes);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int listIndex = node.getListIndex();
            result.add(node.getValue());
            if (indexes[listIndex] < lists.get(listIndex).size()) {
                queue.add(
                        new Node(
                                lists.get(listIndex).get(indexes[listIndex]),
                                listIndex
                                )
                );
                indexes[listIndex] = ++indexes[listIndex];
            }
        }
        return result;
    }

    private void populateHeap(List<List<Integer>> lists, int[] indexes) {
        for (int x = 0; x < lists.size(); x++) {
            if (!lists.get(x).isEmpty()) {
                queue.add(new Node(lists.get(x).get(0), x));
                indexes[x] = ++indexes[x];
            } else {
                lists.remove(x);
            }
        }
    }


}
