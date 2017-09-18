package omssrjgd;

//Recursive Java program for level order traversal of Binary Tree

/* Class containing left and right child of current 
node and key value*/
class Node
{
 int data;
 Node left, right;
 public Node(int item)
 {
     data = item;
     left = right = null;
 }
}

class MirrorTree
{
 // Root of the Binary Tree
 Node root;

 public MirrorTree()
 {
     root = null;
 }

 /* function to print level order traversal of tree*/
 void checkMirrorAtEachLevel()
 {
    // int h = height(root);
     int i=2, result=0;
     if(root.left.data != root.right.data)
     {
    	 System.out.println("not mirror tree");
    	 return;
     }
     /*for (i=2; i<=h; i++)
     {
         result = printGivenLevel(root.left, root.right, i);
         if (result==-1)
         {
        	 System.out.println("not a mirror tree");
        	 break;
         }
     }*/
     
     while (true)
     {
    	 result = printGivenLevel(root.left, root.right, i);
    	 if(result==-1)
    	 {
    		 System.out.println("not a mirror tree");
    		 break;
    	 }
    	 else
    	 {
    		 System.out.println("this is a mirror tree");
    		 break;
    	 }
//    	 i++;
    }
     if(result==1)
     {
    	 System.out.println("this is a mirror tree");
     }
 }

 /* Compute the "height" of a tree -- the number of
 nodes along the longest path from the root node
 down to the farthest leaf node.*/
 int height(Node root)
 {
     if (root == null)
        return 0;
     else
     {
         /* compute  height of each subtree */
         int lheight = height(root.left);
         int rheight = height(root.right);
          
         /* use the larger one */
         if (lheight > rheight)
             return(lheight+1);
         else return(rheight+1); 
     }
 }

 /* Print nodes at the given level */
 int printGivenLevel (Node lefttree ,Node righttree, int level)
 {
	 int x=0;
     if (lefttree==null && righttree!=null)
         return -1;
     else if(righttree==null && lefttree!=null)
    	 return -1;
     else if (lefttree==null && righttree==null)
    	 return 1;
     if (level == 1)
     {
    	 if(lefttree.data!=righttree.data)
    	 {
    		// System.out.print("not a mirror tree");
    		 return -1;
    	 }
     }
     else if (level > 1)
     {
        x= printGivenLevel(lefttree.left, righttree.right, level-1);  //doubt -- use two separate variables and for a tree of infinite depth what needs to be done. probably queue only as recursion will waste time. 
         x = printGivenLevel(lefttree.right, righttree.left, level-1);
     }
     return x;
 }
  
 /* Driver program to test above functions */
 public static void main(String args[])
 {
    MirrorTree tree = new MirrorTree();
    tree.root= new Node(1);
    tree.root.left= new Node(2);
    tree.root.right= new Node(2);
    tree.root.left.right= new Node(4);
    tree.root.right.left= new Node(3);
       
    tree.checkMirrorAtEachLevel();
 }
}