import java.util.Arrays;
import java.util.LinkedList;

public class TrappingRainWater {
    //find the peak and get the amount of "water"

    public static void main(String[] args) {
        int[] x = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(trap(x));
    }

    public static int trap(int[] height) {
        int amount_of_water = 0;
        LinkedList<Integer> peaks = find_peak(height);
        if (peaks == null) {
            return 0;
        }
        while (peaks.size() > 1) {
            for (int i = 0; i < peaks.size() - 1; i++) {
                int left_peak = peaks.get(i);
                int right_peak = peaks.get(i + 1);
                int current_max = Math.min(height[left_peak], height[right_peak]);
                if (height[left_peak] <= height[right_peak]) {
                    current_max = height[left_peak];
                    peaks.remove(i);
                } else {
                    current_max = height[right_peak];
                    peaks.remove(i + 1);
                }

                for (int j = left_peak; j < right_peak; j++) {
                    int water_add = current_max - height[j];
                    if (water_add < 0) {
                        water_add = 0;
                    }
                    height[j] += water_add;
                    amount_of_water = amount_of_water + water_add;
                   // System.out.println("index=" + j + " currentmax=" + current_max + " addwater=" + (current_max - height[j]));
                }

            }
        }
        System.out.println(Arrays.toString(height));
        //System.out.println(peaks.toString());
        return amount_of_water;

    }


    public static LinkedList<Integer> find_peak(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return null;
        }
        LinkedList<Integer> peaks = new LinkedList<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {if (height[0] > height[1]) {
                    peaks.add(i);
                }
                continue;
            }


            if (i == height.length - 1) {
                if (height[height.length - 1] > height[height.length - 2]) {
                    peaks.add(i);
                }
                continue;

            }

            if (height[i] >= height[i + 1] && height[i] >= height[i - 1]) {
                peaks.add(i);
                continue;
            }
        }


        return peaks;

    }


}
