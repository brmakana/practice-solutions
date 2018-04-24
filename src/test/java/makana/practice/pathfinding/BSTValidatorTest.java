package makana.practice.pathfinding;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTValidatorTest {

    @Test
    public void checkValidBST() {
        BSTValidator.Node root = buildValidTree();
        BSTValidator validator = new BSTValidator();
        boolean expected = true;
        boolean actual = validator.checkBST(root);
        assertEquals(expected, actual);
    }

    @Test
    public void checkInvalidBST() {
        BSTValidator.Node root = buildInvalidTree();
        BSTValidator validator = new BSTValidator();
        boolean expected = false;
        boolean actual = validator.checkBST(root);
        assertEquals(expected, actual);
    }

    private BSTValidator.Node buildValidTree() {
        BSTValidator.Node one = new BSTValidator.Node();
        one.data = 1;
        BSTValidator.Node two = new BSTValidator.Node();
        two.data = 2;
        two.left = one;
        BSTValidator.Node three = new BSTValidator.Node();
        three.data = 3;
        two.right = three;
        BSTValidator.Node four = new BSTValidator.Node();
        four.data = 4;
        four.left = two;
        BSTValidator.Node five = new BSTValidator.Node();
        five.data = 5;
        four.right = five;
        return four;
    }

    private BSTValidator.Node buildInvalidTree() {
        BSTValidator.Node one = new BSTValidator.Node();
        one.data = 1;
        BSTValidator.Node two = new BSTValidator.Node();
        two.data = 2;
        two.left = one;
        BSTValidator.Node four = new BSTValidator.Node();
        four.data = 4;
        two.right = four;
        BSTValidator.Node three = new BSTValidator.Node();
        three.data = 3;
        three.left = two;
        BSTValidator.Node five = new BSTValidator.Node();
        five.data = 5;
        three.right = five;
        return three;
    }
}