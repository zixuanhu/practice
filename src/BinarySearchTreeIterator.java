

class BSTIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode current=null;
    TreeNode end=null;

    TreeNode next=null;

    public BSTIterator(TreeNode root) {
        current.right=root;
        end = root;
        while (end.right!=null){
            end=end.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {


        return current!=end;

    }

    /** @return the next smallest number */
    public int next() {
        return this.next.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
