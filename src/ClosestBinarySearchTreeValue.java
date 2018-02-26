public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {

       Integer lesser=null;
       Integer larger=null;

        while(root!=null){
            if(root.val>target){
                larger=root.val;
                root=root.left;

            }else{
                lesser=root.val;
                root=root.right;
            }

        }


        if(lesser!=null&&larger==null){
            return lesser;
        }
        if(larger!=null&&lesser==null) {
            return larger;
        }

        if(larger-target>target-lesser){
            return lesser;
        }else {
            return larger;
        }


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
