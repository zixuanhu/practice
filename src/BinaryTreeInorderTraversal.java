import java.util.*;
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> node_list=new LinkedList<>();
        List<Integer> return_list= new LinkedList<>();
        if(root==null){
            return return_list;
        }
        helper(node_list, root);

        for (TreeNode node:node_list){
            return_list.add(node.val);
        }
        return return_list;

    }

    public void helper(List<TreeNode> nodes_list, TreeNode root){
        if(root.left!=null){
            helper(nodes_list,root.left);
        }
        nodes_list.add(root);
        if(root.right!=null){
            helper(nodes_list,root.right);
        }
        return;
    }
}
