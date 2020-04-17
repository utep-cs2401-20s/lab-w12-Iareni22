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
        This test case is meant to ensure the proper function of the depth method whenever the value is not found within
    tree, causing a value of -1 to be returned. Once the method exits the tree, it reverses all counts made and returns
    a -1 value since there is no depth to be taken from a non existent value.
     */
    @Test   // Passed
    public void depth2(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{5, 3, 4, 8, 1, 10, 7, 19});
        assertEquals(-1,A.depth(11));
    }

    /*
    Test case 5 - insert()
        This test case is meant to ensure the proper function of the insert method so that the values are placed in the
    correct place in the tree. The test case traverses the tree accordingly and compares the values in each tree after
    the insertions are made. After all values are checked I run the size method to make sure the amount of comparisons I
    made is accurate and no extra leaves or nodes exist within the tree I did not check. The method also explores the
    no duplicate rule by displaying an error message in the console.
     */
    @Test   // Passed
    public void insert1(){
        myBinarySearchTreeNode A = new myBinarySearchTreeNode(new int[]{3, 4});
        A.insert(4);
        A.insert(1);
        A.insert(6);
        A.insert(5);
        A.insert(6);
        myBinarySearchTreeNode B = new myBinarySearchTreeNode(new int[]{3, 4, 1, 6, 5});

        assertEquals(B.myValue, A.myValue);
        assertEquals(B.left.myValue, A.left.myValue);
        assertEquals(B.right.myValue, A.right.myValue);
        assertEquals(B.right.right.myValue, A.right.right.myValue);
        assertEquals(B.right.right.left.myValue, A.right.right.left.myValue);

        assertEquals(5, A.size());  // checks to make sure there is no extra nodes attached anywhere I did not
                                             //  traverse through in the tree
    }
}