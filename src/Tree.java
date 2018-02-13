public class Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = buildTree(arr, 1);
        System.out.println(root.left.val);
    }

    public static TreeNode buildTree(int[] arr, int i) {
        if (i <= arr.length) {
            TreeNode a = new TreeNode(arr[i-1]);
            a.left=buildTree(arr,2*i);
            a.right=buildTree(arr,2*i+1);
            return a;
        }
        return null;
    }
}

