import java.util.*;
public class CombinationSum3 {
    public static void main (String[] agrs){
        int k =3;
        int n =9;
        List<List<Integer>> test = combinationSum3(k,n);
        for (List i: test) {
            System.out.println(i.toString());
        }

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new LinkedList<>();
        List<List<Integer>> final_list = new LinkedList<>();
        if(k==0||n==0){
            return final_list;
        }
        helper(temp,final_list,k,n,9);
        return final_list;
    }

    public static void helper(List<Integer> temp, List<List<Integer>> final_list, int k, int n, int cur_number){
       // System.out.println(temp.toString()+"   "+cur_number);
        if(n==0&&k==0){

            List<Integer> temp_add=new LinkedList<>(temp);
            final_list.add(temp_add);
            return;
        }
        while(k>0 && cur_number>0){
            if(cur_number<=n){
                temp.add(cur_number);
                helper(temp,final_list,k-1,n-cur_number,cur_number-1);
                temp.remove(temp.size()-1);
            }
            cur_number--;
        }
        return;
    }
}
