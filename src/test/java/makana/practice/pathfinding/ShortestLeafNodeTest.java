package makana.practice.pathfinding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestLeafNodeTest {

    @Test
    public void shortestDistanceToLeafNode() {
        ShortestLeafNode slf = new ShortestLeafNode();
        // given a node in a tree with vertices of different distances,
        // find the shortest distance to a leaf node
        int actual = slf.shortestDistanceToLeafNode(createTree());
        int expected = 4;
        assertEquals(expected, actual);
    }

    /**
     * ROOT
     * 1      4     3
     * A      B     C
     * 9  4    8     1
     * D    E   F     G
     * Shortest: 4 (C -> G)
     */
    private Node createTree() {
        Node root = new Node("root");
        Node a = new Node("a"),
                b = new Node("b"),
                c = new Node("c"),
                d = new Node("d"),
                e = new Node("e"),
                f = new Node("f"),
                g = new Node("g");
        root.getChildrenAndDistances().put(a, 1);
        root.getChildrenAndDistances().put(b, 4);
        root.getChildrenAndDistances().put(c, 3);
        a.getChildrenAndDistances().put(d, 9);
        a.getChildrenAndDistances().put(e, 4);
        b.getChildrenAndDistances().put(f, 8);
        c.getChildrenAndDistances().put(g, 1);
        return root;
    }


}