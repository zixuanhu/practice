import java.util.*;
public class PathSum2 {
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
        LinkedList <Integer> node_record=new LinkedList<>();

        TreeNodeplus(TreeNode node) {
            this.val = node.val;
            if(node.left!=null)this.left = new TreeNodeplus(node.left);
            if(node.right!=null)this.right = new TreeNodeplus(node.right);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> final_list=new LinkedList<>();
        if(root==null){
            return final_list;
        }

        Stack<TreeNodeplus> tree= new Stack<>();
        tree.add(new TreeNodeplus(root));
        tree.peek().sum=root.val;
        tree.peek().node_record.add(tree.peek().val);

        while(!tree.isEmpty()){
            TreeNodeplus temp= tree.pop();
            if(temp.right==null&&temp.left==null){
                if(temp.sum==sum){
                    final_list.add(temp.node_record);
                }
            }

            if(temp.right!=null){
                temp.right.sum=temp.sum+temp.right.val;
                LinkedList<Integer> x= (LinkedList<Integer>)temp.node_record.clone();
                x.add(temp.right.val);
                temp.right.node_record=x;
                tree.push(temp.right);
            }
            if(temp.left!=null){
                temp.left.sum=temp.sum+temp.left.val;
                LinkedList<Integer> x= (LinkedList<Integer>)temp.node_record.clone();
                x.add(temp.left.val);
                temp.left.node_record=x;
                tree.push(temp.left);
            }


        }
        return final_list;

    }
}
