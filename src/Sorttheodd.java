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




        return array;
    }

}
