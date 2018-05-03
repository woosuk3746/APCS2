//Woosuk Lee
//APCS2 pd08
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
        return height(_root);
    }

    public int height( TreeNode t ){
        if(t==null) return -1; //null is -1
        else if(t.getLeft() == null && t.getRight() == null) return 0; //the very bottom has height 0
        else{
            if(height(t.getLeft()) > height(t.getRight())){
                return height(t.getLeft()) + 1; //if the height of the left is bigger, return the height of the left and increment
            }
            else{
                return height(t.getRight()) + 1; //else return the height of the right and increment
            }
        }
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
      return numLeaves(_root);
    }

    public int numLeaves(TreeNode t){
        if(t==null) return 0; //null treenode has no leaves
        else if ( t.getLeft() == null && t.getRight() == null ) return 1; //the very bottom returns 1
        else return numLeaves(t.getLeft())+ numLeaves(t.getRight()); //recursively add number of leaves from left and right
    }

    
    /*****************************************************
     * TreeNode remove()
     * remove a target node
     * help received from Wenting Li period 1
     *****************************************************/
    public void remove( int target ){
        _root = remove( _root, target );
    }
    
    public TreeNode remove( TreeNode currNode, int target ){
        if ( currNode == null ) return currNode; //base case
        //recursively move down the tree to find the target
        else if ( target < currNode.getValue() ) currNode.setLeft( remove(currNode.getLeft(), target) );   else if ( target > currNode.getValue() ) currNode.setRight( remove( currNode.getRight(), target) );
        else{ //target found
          if (currNode.getLeft() == null) //case 1 and 2: 1 or no child
            return currNode.getRight();
          else if (currNode.getRight() == null) 
            return currNode.getLeft();
          else //case 3: 2 children
          {
            int successor = minValue(currNode.getRight());
            remove( currNode, successor ); 
            currNode.setValue( successor );
          }  
        }
        return currNode; 
    }    
      
  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
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
    
    System.out.println( "\n-----------------------------");
    System.out.println( "height:" );
    System.out.println(arbol.height());
      
    System.out.println( "\n-----------------------------");
    System.out.println( "number of leaves:" );
    System.out.println(arbol.numLeaves());
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      
    System.out.println("\n-----------------------------");
    System.out.println("REMOVED 6");
    arbol.remove( 6 );    
 
    System.out.println("NEW pre-order traversal:");
    arbol.preOrderTrav(); //42135
    System.out.println("\nNEW in-order traversal:");
    arbol.inOrderTrav(); //12345
    System.out.println("\nNEW post-order traversal:");
    arbol.postOrderTrav(); //13254 
  }

}//end class
