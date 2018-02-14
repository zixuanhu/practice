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
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19};
        TreeNode root = buildTree(arr, arr.length / 2, arr.length);
        System.out.println(root.left.val);
    }

    public static TreeNode buildTree(int[] arr, int i, int size) {
        int length = 0;
        if(i<0 || i>arr.length-1){
            return null;
        }
        if (size==1 && i>0&&i<arr.length-1){
            length=1;
            TreeNode a = new TreeNode(arr[i]);
            return null;
        } else if(size==2){
            length=1;
        } else if(size==3){
            length=1;
        } else if (size == 1) {
            length = 0;
        } else if (i < arr.length-1 && i > 0) {
            length=size/4;
        } else {
            return null;
        }

        TreeNode a = new TreeNode(arr[i]);
        System.out.println("i="+i+"  left="+(i-length)+"  right="+(i + length)+"  size="+size);

        a.left = buildTree(arr, i - length , size / 2);
        a.right = buildTree(arr, i + length, size-size / 2);

        return a;
    }
}
