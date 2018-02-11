import java.util.Arrays;
import java.util.LinkedList;

public class TrappingRainWater2 {

    public static void main(String[] args) {
        int[] x = {1,2,0,2,1};
        System.out.println(trap(x));
    }

    public static int trap(int[] height) {
        int left = 0;
        int left_max = height[0];
        int right = height.length - 1;
        int right_max = height[height.length-1];
        int amount_of_water = 0;

        while(left <= right){
            //left_max = Math.max(left_max, height[left]);
            //right_max = Math.max(right_max, height[right]);
            if(left_max <= right_max){
                if(height[left] < left_max){
                    amount_of_water += left_max - height[left];
                }else {
                    left_max = height[left];
                }
                //amount_of_water += left_max - height[left];
                System.out.println("left is: " + left);
                left++;

            }else{
                if(height[right] < right_max){

                    amount_of_water += right_max - height[right];
                }else {
                    right_max = height[right];
                }
                System.out.println("/right is: " + right);
                //amount_of_water += right_max - height[right];

                right--;
            }
            //System.out.println("left is: " + (left-1) + "; left_max is: " + left_max + "; right is: " + (right+1) + "; right_max is: " + right_max);
        }

        //System.out.println(left_max);
        //System.out.println(right_max);




        return amount_of_water;

    }

}
