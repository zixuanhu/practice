import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<TreeNode> tree_list = new LinkedList<>();
        List<List<Integer>> final_list = new LinkedList<>();
        List<TreeNode> level_list = new LinkedList<>();


        tree_list.add(root);
        if(root==null){
            return  final_list;
        }
        int index=0;


        while (index!=tree_list.size()) {
            TreeNode temp = tree_list.get(index);
            if (temp.left != null) {
                tree_list.add(temp.left);
            }
            if (temp.right != null) {
                tree_list.add(temp.right);
            }
            index++;

        }
        index=0;
        while(index<tree_list.size()){
            if(!thislevel(level_list, tree_list.get(index))){
                List<Integer> int_list=new LinkedList<>();
                for (TreeNode node: level_list) {
                    int_list.add(node.val);
                }
                final_list.add(int_list);
                level_list.clear();
            }
            level_list.add(tree_list.get(index));
            index++;

        }


        return final_list;


    }


    public boolean thislevel(List<TreeNode> cur_level, TreeNode cur_Node) {
        for (TreeNode node : cur_level) {
            if (node.left == cur_Node || node.right == cur_Node) {
                return false;
            }
        }
        return true;
    }

}
