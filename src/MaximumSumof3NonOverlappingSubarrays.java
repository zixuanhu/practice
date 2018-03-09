import java.util.Arrays;
import java.util.LinkedList;

public class MaximumSumof3NonOverlappingSubarrays {
    public  static  void main(String[] agrs){
        int[] test = {1,2,1,2,6,7,5,1};
        test=maxSumOfThreeSubarrays(test,2);
        System.out.println(Arrays.toString(test)+"xxxxxxxx");

    }




    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int max_sum=0;
        int[] max_indexs = new int[3];
        if(k*3>nums.length){
            return new int[0];
        }
        //get sum
        int[] k_sum = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                k_sum[i] += nums[i+j];
            }
        }  //q(n)


        int[] right= new int[nums.length-k+1];
        for(int i = k_sum.length-1, j=k_sum.length-1; i>=0;i--,j--){
            if(i==k_sum.length-1||k_sum[right[i+1]]<k_sum[j]) right[i]= j;
            else right[i]=right[i+1];//q(n)
        }

        int[] left= new int[nums.length-k+1];
        for(int i = 0, j=0; i < k_sum.length;i++,j++){
            if(i==0||k_sum[left[i-1]]<k_sum[j]) left[i]= j;
            else left[i]=left[i-1];//q(n)
        }

        System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        //System.out.println(Arrays.toString(k_sum));



        int sec_index=k;

        while(sec_index>=k && sec_index<k_sum.length-k){


            int cur_sum = k_sum[left[sec_index-k]]+k_sum[sec_index]+k_sum[right[sec_index+k]];

            if(max_sum<cur_sum){
               // System.out.println("left="+maxLeft+" mid="+k_sum[sec_index]+" right="+maxRight);
               max_sum=cur_sum;
               max_indexs=new int[] {left[sec_index-k],sec_index , right[sec_index+k]};

            }
            sec_index++;
        }



        return max_indexs;
    }


}
