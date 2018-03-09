import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class SlidingWindowMaximum {
    public class Monotonequeue {
        LinkedList<Integer> mono;

        public Monotonequeue() {
            mono = new LinkedList<>();
        }

        public void add(int x) {
            while (!mono.isEmpty()&&mono.getLast()<x){
                mono.removeLast();
            }
            mono.add(x);
        }

        public void pop() {
            mono.removeFirst();
        }


        public int peek() {
            return mono.getFirst();
        }

        public int size() {
            return mono.size();
        }

        public String toString() {
            return mono.toString();
        }


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};


        int[] max = new int[nums.length - k + 1];

        if (k == 0) {
            return nums;
        }

        Monotonequeue que = new Monotonequeue();
        for (int i = 0; i < nums.length; i++) {
            if (i>=k && que.peek()==nums[i-k]) {
                que.pop();
            }
            que.add(nums[i]);
            if (i >= k - 1) {
                max[i - k + 1] = que.peek();
            }
            System.out.println(que.toString());

        }
        return max;

    }
}
