//Wenting Li, Hasif Ahmed
//APCS2 pd01
//HW #44: Prune Your Tree
//2018-05-03 R


/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
      return search( _root, target );
    }

    //recursive helper for search()
    public TreeNode search( TreeNode currNode, int target )
    {
      if (currNode.getValue() == target) //base case: if target found, return node containing target
        return currNode; 
      if (currNode == null) //base case: if target not found, return null
        return null;
      if (target < currNode.getValue()) //compare target and recursively search LEFT or RIGHT subtree
        return search( currNode.getLeft(), target );
      else 
        return search( currNode.getRight(), target );
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
      return height( _root );
    }

    //recursive helper for height()
    public int height( TreeNode currNode )
    {
      if ( currNode == null) //base case: if node is empty, return height of -1 (1 lower than leaf)
        return -1;
      else if ( currNode.getLeft() == null && currNode.getRight() == null ) //base case: if node is a leaf, return height of 0
        return 0;
      else if ( height(currNode.getLeft()) > height(currNode.getRight()) ) //compare height of LEFT and RIGHT subtrees and return greater height + 1
        return height(currNode.getLeft()) + 1;
      else 
        return height(currNode.getRight()) + 1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
      return numLeaves( _root );
    }

    //recursive helper for numLeaves()
    public int numLeaves( TreeNode currNode )
    {
      if ( currNode == null ) ///base case: if node is empty, not a leaf and return 0
        return 0;
      else if ( currNode.getLeft() == null && currNode.getRight() == null ) //base case: if node is leaf, return 1
        return 1;
      else
        return numLeaves(currNode.getLeft()) 
             + numLeaves(currNode.getRight()); //recursively return sum of leaves in LEFT and RIGHT subtrees
    }


  /*****************************************************
   * void remove(int) 
   * removes target element from tree
   * or null if target not found
   *****************************************************/
  public void remove( int target )
  {
    _root = remove( _root, target ); //transfers changes made to _root from alias
  }

  //recursive helper for remove()
  public TreeNode remove( TreeNode currNode, int target )
  {
    if ( currNode == null ) //base case: if tree ir empty or target not found, return null
      return currNode;
    else if ( target < currNode.getValue() ) //compare target and recursively remove target in LEFT or RIGHT subtree
      currNode.setLeft( remove(currNode.getLeft(), target) );
    else if ( target > currNode.getValue() )
      currNode.setRight( remove( currNode.getRight(), target) );
    else //if target node is found...
    {
      if (currNode.getLeft() == null) //if target node is a leaf or only has one child...return null or that child
        return currNode.getRight();
      else if (currNode.getRight() == null) 
        return currNode.getLeft();
      else //if target node has two children, remove the in-order successor and set currNode to that value
      {
        int successor = minValue(currNode.getRight());
        remove( currNode, successor ); 
        currNode.setValue( successor );
         
      }  
    }
    return currNode; 
  }

  //helper method that returns in-order successor (smallest value in the right subtree)
  public int minValue( TreeNode currNode )
  {
    while ( currNode.getLeft() != null )
      currNode = currNode.getLeft();
    return currNode.getValue();
  }

 
  //main method for testing
  public static void main( String[] args )
  {    

    BST arbol = new BST();

    /* 1st BST arbol after the following insertions 
           4
         /   \
        2     5
       / \     \
      1   3     6   */


    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav(); //421356

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav(); //123456

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav(); //132654

    System.out.println( "\n-----------------------------");
    System.out.println( "number of leaves:" );
    System.out.print( arbol.numLeaves() ); //3

    System.out.println( "\n-----------------------------");
    System.out.println( "height of tree:" );
    System.out.print( arbol.height() ); //2


    //*************test cases for remove()*************
    System.out.println("\n-----------------------------");
    System.out.println("REMOVED 6");
    arbol.remove( 6 );    
    /* 1st BST arbol after remove 
           4
         /   \
        2     5
       / \     
      1   3      */ 
    System.out.println("NEW pre-order traversal:");
    arbol.preOrderTrav(); //42135
    System.out.println("\nNEW in-order traversal:");
    arbol.inOrderTrav(); //12345
    System.out.println("\nNEW post-order traversal:");
    arbol.postOrderTrav(); //13254    



    System.out.println("\n-----------------------------");
    System.out.println("REMOVED 2");
    arbol.remove( 2 );    
    /* 2ndt BST arbol after remove
           4
         /   \
        3     5
       /      
      1          */ 
    System.out.println("NEW pre-order traversal:");
    arbol.preOrderTrav(); //4315
    System.out.println("\nNEW in-order traversal:");
    arbol.inOrderTrav(); //1345
    System.out.println("\nNEW post-order traversal:");
    arbol.postOrderTrav(); //1354



    System.out.println("\n-----------------------------");
    System.out.println("REMOVED 3");
    arbol.remove( 3 );    
    /* 3rd BST arbol after remove 
           4
         /   \
        1     5   */
    System.out.println("NEW pre-order traversal:");
    arbol.preOrderTrav(); //415
    System.out.println("\nNEW in-order traversal:");
    arbol.inOrderTrav(); //145
    System.out.println("\nNEW post-order traversal:");
    arbol.postOrderTrav(); //154

    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /* 2nd BST arbol after the following insertions 
       1
         \
          2
           \
            3
             \
              4
               \
                6
               /
              5   */
              
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
    arbol.insert(1);
    arbol.insert(2);
    arbol.insert(3);
    arbol.insert(4);
    arbol.insert(6);
    arbol.insert(5);

    System.out.println("\n-----------------------------");
    System.out.println("pre-order traversal:");
    arbol.preOrderTrav(); //123465

    System.out.println("\n-----------------------------");
    System.out.println("in-order traversal:");
    arbol.inOrderTrav(); //123456

    System.out.println("\n-----------------------------");
    System.out.println("post-order traversal:");
    arbol.postOrderTrav(); //564321

    System.out.println("\n-----------------------------");
    System.out.println("number of leaves:");
    System.out.print(arbol.numLeaves()); //1

    System.out.println("\n-----------------------------");
    System.out.println("height of tree:");
    System.out.println(arbol.height()); //5

     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
