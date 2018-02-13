public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root) {
      if(root==null){
          return true;
      }else if(root.left == null&&root.right==null){
          return true;
      }else if(root.left == null || root.right==null){
          return false;
      }else if(root.left.val!=root.right.val){
          return false;
      }

      return helper(root.left,root.right);

    }


    public boolean helper (TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val!=q.val){
            return false;
        }

        if(!helper(p.right,q.left)){
            return false;
        }
        if(! helper(p.left,q.right)){
            return false;
        }

        return true;

    }


}
