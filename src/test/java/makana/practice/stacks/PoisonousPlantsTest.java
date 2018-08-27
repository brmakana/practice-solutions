package makana.practice.stacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PoisonousPlantsTest {

    @Test
    public void testPoisonPlants() {
        int[] plants = { 3, 6, 2, 7, 5};
        PoisonousPlants cut = new PoisonousPlants();
        int expected = 2;
        int actual = cut.poisonousPlants(plants);
        assertEquals(expected,actual);
    }
    
    @Test
    public void testLongerExample() {
        int[] plants = {1,3,5,2,7,6,4,2,1};
        PoisonousPlants cut = new PoisonousPlants();
        int expected = 4;
        int actual = cut.poisonousPlants(plants);
        assertEquals(expected,actual);
    }

    @Test
    public void testListify() {
        int[] plants = {6,5,8,7,4,7,3,1,1,10};
        PoisonousPlants cut = new PoisonousPlants();
        List<LinkedList<Integer>> expected = new ArrayList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addAll(Arrays.asList(6,5));
        expected.add(list1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(Arrays.asList(8,7,4));
        expected.add(list2);
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.addAll(Arrays.asList(7,3,1,1));
        expected.add(list3);
        LinkedList<Integer> list4 = new LinkedList<>();
        list4.addAll(Arrays.asList(10));
        expected.add(list4);

        List<LinkedList<Integer>> actual = cut.listify(plants);
        assertEquals(expected, actual);
    }

    @Test
    public void testPopAndMerge() {
        PoisonousPlants cut = new PoisonousPlants();
        List<LinkedList<Integer>> input = new ArrayList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addAll(Arrays.asList(6,5));
        input.add(list1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(Arrays.asList(8,7,4));
        input.add(list2);
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.addAll(Arrays.asList(7,3,1,1));
        input.add(list3);
        LinkedList<Integer> list4 = new LinkedList<>();
        list4.addAll(Arrays.asList(10));
        input.add(list4);

        List<LinkedList<Integer>> expected = new ArrayList<>();
        LinkedList<Integer> newList1 = new LinkedList<>();
        newList1.addAll(Arrays.asList(6,5));
        expected.add(newList1);
        LinkedList<Integer> newList2 = new LinkedList<>();
        newList2.addAll(Arrays.asList(7,4,3,1,1));
        expected.add(newList2);

        cut.popAndMerge(input);
        assertEquals(expected, input);
    }

}