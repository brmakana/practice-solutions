package makana.practice.pathfinding;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ShortestLeafNode {

    /**
     * Returns the shortest distance to a leaf node, from a given start node.
     *
     * @param start the node to start from
     * @return the shortest distance to a leaf node, 0 if the start is a leaf.
     */
    public int shortestDistanceToLeafNode(Node start) {
        if (start.getChildrenAndDistances().isEmpty()) {
            return 0;
        } else {
            int shortestDistance = -1;
            Map<String, Boolean> visited = new HashMap<>();
            Queue<Path> queue = new ArrayDeque<>();
            queue.add(new Path(start, 0));
            visited.put(start.getName(), true);
            while (!queue.isEmpty()) {
                Path path = queue.poll();
                Map<Node, Integer> childrenAndDistances = path.getNode().getChildrenAndDistances();
                if (!childrenAndDistances.isEmpty()) {
                    for (Node child : childrenAndDistances.keySet()) {
                        if (!visited.containsKey(child.getName())) {
                            visited.put(child.getName(), true);
                            int distance = path.getDistance() + childrenAndDistances.get(child);
                            queue.add(new Path(child, distance));
                        }
                    }
                } else {
                    if (shortestDistance == -1) {
                        shortestDistance = path.getDistance();
                    } else if (shortestDistance > path.getDistance()) {
                        shortestDistance = path.getDistance();
                    }
                }
            }
            return shortestDistance;
        }
    }

}
