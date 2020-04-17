import java.nio.channels.spi.AbstractInterruptibleChannel;

class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    left = null;
    right = null;

  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.

    myValue = A[0]; // assigns first value of array as the root
      // loop populates the tree using insert method to define correct side for array values
    for(int i = 1; i < A.length; i++){
      this.insert(A[i]);
    }

  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken.

    if(inValue > myValue){  // in case the value inserted is more than my current root, it is sent to the right child
      if(right == null){  // if my right child is empty, the new value takes its place
        right = new myBinarySearchTreeNode(inValue);
      }
      else{ // if right child exists I make a recursive call to traverse further down the tree
        right.insert(inValue);
      }
    }
    else if(inValue < myValue){ // in case value inserted is less than my current root, it is sent to the left child
      if(left == null){ // if my left child is empty, the new value takes its place
        left = new myBinarySearchTreeNode(inValue);
      }
      else{ // if left child exists I make a recursive call to traverse further down the tree
        left.insert(inValue);
      }
    }
    else {  // in case the value already exists within the tree, an error is sent and nothing is added
      System.out.println("Error: No duplicates allowed");
    }
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int leftH = 0;
    int rightH = 0;
    if(left != null){   // begins traversing the left subtree and keeps track of the edges counted
      leftH = left.height() + 1;
    }
    if(right != null){  // begins traversing the right subtree while keeping track of the edges counted
      rightH = right.height() + 1;
    }
    return Math.max(rightH, leftH); // returns the greater value between both counters collected
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).

      // begins by determining whether the value is found in the left or right subtree
    if(search < myValue){ // less than my root means it is in my left subtree
      if(left != null) {
        int leftDepth = left.depth(search); // recursively traverses tree while counting edges traversed
        if(leftDepth == -1){  // if the value is not found the method reverses all additions previously made
          return -1;
        }
        else{
          return 1 + left.depth(search);
        }
      }
    }
    else if(search > myValue){  // more than my root means it is in my right subtree
      if(right != null) {
        int rightDepth = right.depth(search); // recursively traverses tree while counting edges traversed
        if(rightDepth == -1){ // if the value is not found the method reverses all additions previously made
          return -1;
        }
        else{
          return 1 + right.depth(search);
        }
      }
    }
    else {  // if the value is found a zero is returned and the counts are called back and returned
      return 0;
    }
    return -1;  // if the value is not found within the tree a -1 is returned by default
  }

  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.
    int sum = 1;  // counts my root to begin with
    if(left != null){ // traverses left subtree if it is not null and keeps track of nodes encountered with sum variable
      sum += left.size();
    }
    if(right != null){  //traverses right subtree if it is not null and keeps track of nodes in the same sum variable
      sum += right.size();
    }
    return sum; // returns the sum of all nodes in both subtrees
  }
  
  // Utility function included so you can debug your solution.
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
}
