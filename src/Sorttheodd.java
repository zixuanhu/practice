import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class Sorttheodd {
    public static void main(String[] args) {
        int[] n = {5, 3, 2, 8, 1, 4};
        System.out.println(Arrays.toString(sortArray(n)));

    }



    public static int[] sortArray(int[] array) {
        LinkedList<Integer>odd = new LinkedList<Integer>();
        for (int i =0; i<array.length; i++){
            if(array[i]%2==1){
                odd.add(array[i]);
            }
        }

        Collections.sort(odd);
        for (int i = 0; i < array.length ; i++) {
            if(array[i]%2==1){
                array[i]=odd.removeFirst();
            }
        }

//        //System.out.println("input is: " + Arrays.toString(array));
//        if (array.length == 0) {
//            return array;
//        }
//        int[] res = new int[array.length];
//        Arrays.fill(res, -1);
//        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            int num = array[i];
//            if (num % 2 == 0) {
//                res[i] = num;
//            } else {
//                q.offer(num);
//            }
//        }
//
//        for (int j = 0; j < res.length; j++) {
//            if (res[j] == -1) {
//                res[j] = q.poll();
//            }
//        }
//        return res;


        return array;
    }

}
