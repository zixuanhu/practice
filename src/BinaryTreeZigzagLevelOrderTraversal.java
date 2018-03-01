import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {


        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


            List<List<Integer>> final_list = new LinkedList<>();
            List<TreeNode> level_list = new LinkedList<>();


            level_list.add(root);
            if (root == null) {
                return final_list;
            }
            List<Integer> num = new LinkedList<>();
            num.add(root.val);
            final_list.add(num);
            boolean rightfirst = true;


            while (true) {
                List<TreeNode> temp = new LinkedList<>();
                List<Integer> num_temp = new LinkedList<>();
                if (!rightfirst) {
                    for (int i = level_list.size()-1; i>=0; i--) {
                        TreeNode node=level_list.get(i);
                        if (node.left != null) {
                            temp.add(node.left);
                            num_temp.add(node.left.val);
                        }
                        if (node.right != null) {
                            temp.add(node.right);
                            num_temp.add(node.right.val);
                        }
                    }
                }else {
                    for (int i = level_list.size()-1; i>=0; i--) {
                        TreeNode node=level_list.get(i);
                        if (node.right != null) {
                            temp.add(node.right);
                            num_temp.add(node.right.val);
                        }
                        if (node.left != null) {
                            temp.add(node.left);
                            num_temp.add(node.left.val);
                        }

                    }

                }
                rightfirst=!rightfirst;

                if (temp.isEmpty()) {
                    break;
                }
                final_list.add(num_temp);
                level_list = temp;


            }


            return final_list;


        }
    }
