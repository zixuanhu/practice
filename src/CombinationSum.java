import java.util.*;
public class CombinationSum {
    public static void main(String[] agrs){
        int[] a= {2,3,6,7};
        int b=7;

       List<List<Integer>> x= combinationSum(a,b);

        for (List i: x) {
            System.out.println(i.toString());
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> temp =new LinkedList<>();
        List<List<Integer>> final_lsit = new LinkedList<>();
        if(target<=0)return final_lsit;
        helper(temp,final_lsit,candidates,target,0);
        return final_lsit;

    }

    public static void helper(List<Integer> temp, List<List<Integer>> final_list, int[] candidates, int target, int index){

        while(index<candidates.length){
            if(target==0){
                //copy
                List<Integer> temp_add =new LinkedList<>();
                temp_add.addAll(temp);
                final_list.add(temp_add);
                return;
            }
            if(candidates[index]<=target){
                temp.add(candidates[index]);
                helper(temp,final_list,candidates,target-candidates[index],index);
                temp.remove(temp.size()-1);
            }
            index++;
        }
        return;
    }
}
