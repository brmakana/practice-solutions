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
    private ShortestLeafNode.Node createTree() {
        ShortestLeafNode.Node root = new ShortestLeafNode.Node("root");
        ShortestLeafNode.Node a = new ShortestLeafNode.Node("a"),
                b = new ShortestLeafNode.Node("b"),
                c = new ShortestLeafNode.Node("c"),
                d = new ShortestLeafNode.Node("d"),
                e = new ShortestLeafNode.Node("e"),
                f = new ShortestLeafNode.Node("f"),
                g = new ShortestLeafNode.Node("g");
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