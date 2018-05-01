//Wenting Li
//APCS2 pd01
//HW #43: BSTs is the Perfect Place for Shade
//2018-05-02 W

import javax.lang.model.util.ElementScanner6;

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



  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    /* BST arbol after the following insertions 
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
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "number of leaves:" );
    System.out.print( arbol.numLeaves() ); //3

    System.out.println( "\n-----------------------------");
    System.out.println( "height of tree:" );
    System.out.println( arbol.height() ); //2
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
