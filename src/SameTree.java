public class SameTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode (int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        three.parent = one;

        System.out.println(one.val);
        System.out.println(three.parent.val == one.val);
        //arr = [1,2,3, 4, 5, 6, 7, 8]
        TreeNode root = new TreeNode(1);
                //return root;
    }
}




