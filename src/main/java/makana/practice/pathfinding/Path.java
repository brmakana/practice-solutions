package makana.practice.pathfinding;

import lombok.Value;

@Value
public class Path {

    private ShortestLeafNode.Node node;
    private int distance;
}
