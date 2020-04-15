import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class myBinarySearchTreeNodeTester {
    /*
    Test case 1 - height()
        This test case is meant to implement the use of the method height, which is able to go through the tree created
     in linear time and return the height of the deepest branch. The method compares the integer returned by the method
     call on a tree made from an array of ints. The method should return 2 since both sides of the tree hold a height of
     2.
     */
    @Test   // Passed
    public void height1(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{3, 1, 2, 4, 5});
        assertEquals(2, A.height());
    }

    /*
    Test case 2 - size()
        This test case ensures the method size works properly by counting every single node in the tree that is not null.
    THe test case also creates an instance in which there is a duplicate value, making sure an error message is sent,
    and the size is not increased by the problem value. The array is of size 8, but an expected value of 7 is to be
    returned due to the duplicate value.
     */
    @Test   // Passed
    public void size1(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{3, 4, 6, 7, 6, 1, 9, 19});
        assertEquals(7, A.size());
    }

    /*
    Test case 3 - depth()
        This test case implements the use of my depth method which chooses a specific value to be found within my tree.
    The method then returns the amount of edges passed through in order to get to the value I needed. The test is fairly
    standard and should return with no issues considering the value will be found within the tree. The expected depth to
    be returned is 2.
     */
    @Test   // Passed
    public void depth1(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{5, 3, 4, 8, 1, 10, 7});
        assertEquals(2,A.depth(7));
    }

    /*
    Test case 4 - depth()
        This test case implements the use of my depth method which chooses a specific value to be found within my tree.
    The method then returns the amount of edges passed through in order to get to the value I needed. The test is fairly
    standard and should return with no issues considering the value will be found within the tree. The expected depth to
    be returned is 2.
     */
    @Test   // Passed
    public void depth2(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{5, 3, 4, 8, 1, 10, 7, 19});
        A.print();
        assertEquals(-1,A.depth(11));
    }
}