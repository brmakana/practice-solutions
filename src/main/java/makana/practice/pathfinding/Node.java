package makana.practice.pathfinding;

import java.util.HashMap;
import java.util.Map;


public class Node {

    private String name;
    private Map<Node, Integer> childrenAndDistances = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Node, Integer> getChildrenAndDistances() {
        return childrenAndDistances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return getName().equals(node.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

}
