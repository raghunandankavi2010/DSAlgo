
package programs.trees;

class TreeStructure {
    int data;
    TreeStructure left, right;

    public TreeStructure(int item) {
        data = item;
        left = right = null;
    }
}

public class Sol {
    //Root of the Binary Tree
    TreeStructure root;

	/* can give min and max value according to your code or
	can write a function to find min and max value of tree. */

    /* returns true if given search tree is binary
    search tree (efficient version) */
    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
    values are >= min and <= max. */
    boolean isBSTUtil(TreeStructure node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

		/* otherwise check the subtrees recursively
		tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data) &&
                isBSTUtil(node.right, node.data, max));
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        Sol tree = new Sol();
        tree.root = new TreeStructure(4);
        tree.root.left = new TreeStructure(2);
        tree.root.right = new TreeStructure(5);
        tree.root.left.left = new TreeStructure(1);
        tree.root.left.right = new TreeStructure(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
