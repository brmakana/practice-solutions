package makana.practice.kmerge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KWayMergeTest {

    @Test
    public void merge() {
        List<Integer> one = Arrays.asList(3,5,7,9);
        List<Integer> two = Arrays.asList(2,4,6,8,10);
        List<Integer> three = Arrays.asList(1, 11, 22);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(one);
        lists.add(two);
        lists.add(three);

        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,22);
        KWayMerge kWayMerge = new KWayMerge();
        List<Integer> actual = kWayMerge.merge(lists);
        assertEquals(expected, actual);
    }
}