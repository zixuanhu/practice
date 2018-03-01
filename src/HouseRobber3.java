import java.util.LinkedList;

public class HouseRobber3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int sumOdd=0;
        int sumEven=0;
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        if(root==null){
            return 0;
        }
        sumOdd=root.val;

        boolean Isodd = false;
        while(!level.isEmpty()){
            LinkedList<TreeNode> temp_level= new LinkedList<>();
            for (TreeNode node: level){
                if(node.left!=null){
                    temp_level.add(node.left);
                    if(Isodd){
                        sumOdd+=node.left.val;
                    }else {
                        sumEven+=node.left.val;
                    }
                }
                if(node.right!=null){
                    temp_level.add(node.right);
                    if(Isodd){
                        sumOdd+=node.right.val;
                    }else {
                        sumEven+=node.right.val;
                    }
                }
            }
            Isodd=!Isodd;
            level=temp_level;

        }
        return Math.max(sumOdd,sumEven);

    }



}
