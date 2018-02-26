import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class ConvertSortedListtoBinarySearchTree {

    public static void main(String[] agrs){
        LinkedList<Integer> a= new LinkedList<Integer>();
        a.add(2);
        a.add(5);
        a.add(1);

        Collections.sort(a);
        System.out.println(a);
    }

    public TreeNode sortedListToBST(ListNode head) {
        LinkedList<Integer> node_list= new LinkedList();
        node_list.add(head.val);
        while(head.next!=null){
            node_list.add(head.next.val);
            head=head.next;
        }
        Collections.sort(node_list);
        return LinkedListtoTree(node_list,0,node_list.size()-1);

    }


    public TreeNode LinkedListtoTree(LinkedList<Integer> node_list, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root=new TreeNode(node_list.get(mid));
        root.left=LinkedListtoTree(node_list,start,mid-1);
        root.right=LinkedListtoTree(node_list,mid+1,end);
        return root;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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
