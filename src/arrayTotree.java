public class arrayTotree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        TreeNode root = buildTree(arr, 0, arr.length-1);
        System.out.println(root.val);
    }

    public static TreeNode buildTree(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
       // System.out.println(mid + "  " + start + "   " + end);


        TreeNode root = new TreeNode(arr[mid]);
        if (mid == 1) {
            root.left = new TreeNode(arr[0]);
            //print(root);
        }
        if (mid == arr.length - 2) {
            root.right = new TreeNode(arr[arr.length - 1]);
           // print(root);
        }
        if (mid != 1 && mid - 1 > 0 && (mid + 1) != start && mid != start) {
            root.left = buildTree(arr, start, mid - 1);
        }
        if (mid != arr.length - 2 && mid + 1 < arr.length && (mid - 1) != end && mid != end) {
            root.right = buildTree(arr, mid + 1, end);
        }

        //print(root);
        return root;
    }


    public static void print(TreeNode root) {

        if (root.left == null && root.right == null) {
            System.out.println("root=" + root.val + " left=null" + " right= null");
        } else if (root.left == null) {
            System.out.println("root=" + root.val + " left=null" + " right=" + root.right.val);
        } else if (root.right == null) {
            System.out.println("root=" + root.val + " left=" + root.left.val + " right= null");
        } else {
            System.out.println("root=" + root.val + " left=" + root.left.val + " right=" + root.right.val);
        }
    }
}
