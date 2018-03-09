import javafx.collections.transformation.SortedList;

import java.util.*;
public class CombinationSum2 {
    public static void main(String[] agrs){
        int[] a= {10,1,2,7,6,1,5};
        int b=8;

        List<List<Integer>> x= combinationSum2(a,b);

        for (List i: x) {
            System.out.println(i.toString());
        }

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> temp =new LinkedList<Integer>();
        List<List<Integer>> final_lsit = new LinkedList<>();
        if(target<=0)return final_lsit;
        Set<List<Integer>> final_set= new TreeSet<>();
        helper(temp,final_set,candidates,target,0);

        return final_lsit;

    }

    public static void helper(List<Integer> temp, Set<List<Integer>> final_set, int[] candidates, int target, int index){
        //System.out.println(temp);

        while(index<=candidates.length){
            if(target==0){
                //copy

                List<Integer> temp_add =new LinkedList<>();
                temp_add.addAll(temp);
                final_set.add(temp_add);
                return;
            }
            if(index==candidates.length) return;
            if(candidates[index]<=target){
                temp.add(candidates[index]);
                helper(temp,final_set,candidates,target-candidates[index],index+1);
                temp.remove(temp.size()-1);
            }
            index++;
        }
        return;
    }
}
