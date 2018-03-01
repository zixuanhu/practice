import java.util.Stack;

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public class TreeNodeplus {
        int val;
        TreeNodeplus left;
        TreeNodeplus right;
        int sum;

        TreeNodeplus(TreeNode node) {
            this.val = node.val;
            if(node.left!=null)this.left = new TreeNodeplus(node.left);
            if(node.right!=null)this.right = new TreeNodeplus(node.right);
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return sum==0;
        }

        Stack<TreeNodeplus> tree= new Stack<>();
        tree.add(new TreeNodeplus(root));
        tree.peek().sum=root.val;
        while(!tree.isEmpty()){
            TreeNodeplus temp= tree.pop();
            if(temp.right==null&&temp.left==null){
                if(temp.sum==sum){
                    return true;
                }
            }

            if(temp.right!=null){
                temp.right.sum=temp.sum+temp.right.val;
                tree.push(temp.right);
            }
            if(temp.left!=null){
                temp.left.sum=temp.sum+temp.left.val;
                tree.push(temp.left);
            }


        }
        return false;

    }
}
