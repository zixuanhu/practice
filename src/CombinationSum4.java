import java.util.*;
public class CombinationSum4 {
    public static void main (String[] agrs){
        int[] nums = {3,2,1};

        int n =32;
        System.out.println(combinationSum4(nums,n));



    }
    public static Integer sum=0;
    public static int combinationSum4(int[] nums, int target) {
        if(target==0){
            return 0;
        }
        Arrays.sort(nums);
        helper(target, nums);
        return sum;
    }

    public static void helper( int n, int[] nums){

        if(n==0){
            sum++;
            return;
        }


        for(int i=0; i<nums.length;i++){
            int number=nums[i];
            if(number<=n){
                helper(n-number,nums);
            }else {
                return;
            }

        }
        return;
    }
}
