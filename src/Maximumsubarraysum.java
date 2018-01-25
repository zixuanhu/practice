import java.util.Arrays;

public class Maximumsubarraysum {
    public static void main(String[] args) {
        int[] num_arr= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sequence(num_arr));

    }
    public static int sequence(int[] arr) {
        int current_max=0;
        int current_sum=0;
        for (int i = 0; i < arr.length; i++) {
            current_sum+=arr[i];
            current_max=Math.max(current_max,current_sum);
            if(current_sum<0){
                current_sum=0;
            }
        }
        return current_max;
    }
}
