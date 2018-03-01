import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> num_map=new HashMap();
        for (int i=0; i<nums.length; i++) {

            if (num_map.containsKey(nums[i])){
                return new int[] {num_map.get(nums[i]),i};
            }
            num_map.put(target-nums[i], i);
        }
        return null;

    }
}
