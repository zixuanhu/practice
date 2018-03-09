import java.util.Arrays;
import java.util.TreeSet;

public class kemptyslot {
    public static void main(String[] args){
        int[] a = {1,3,2};

        System.out.println(kEmptySlots(a,1));
    }
    public static int kEmptySlots(int[] flowers, int k) {
        if(flowers.length==0){
            return -1;
        }

        int[] min=new int[flowers.length/(k+1)+1];
        for (int i =0; i<min.length;i++){
            min[i]=Integer.MAX_VALUE;
        }


        int[] max=new int[flowers.length/(k+1)+1];

        for (int i = 0; i<flowers.length; i++) {
            int index=flowers[i]/(k+1);
            if(flowers[i]%(k+1)==0){
                index--;
            }
            if(flowers[i]>max[index]){
                max[index]=flowers[i];
                if(index!=max.length-1&&max[index]==min[index+1]-k-1){
                    return i+1;
                }
            }
            if(flowers[i]<min[index]){
                min[index]=flowers[i];
                if(index!=0&&min[index]==max[index-1]+k+1){
                    return i+1;
                }

            }


        }
        return -1;


    }
}
