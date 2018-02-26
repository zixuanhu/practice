import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int val=-1;
    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left=true;

        left=isValidBST(root.left);

        if(val>=root.val){
            return false;
        }

        val=root.val;
        System.out.println(val);

        boolean right=isValidBST(root.right);


        return left&&right;
    }
}
