
import java.util.LinkedList;

public class NQueens2 {
    public static void main(String[] agrs){
        System.out.println(totalNQueens(8));
        //totalNQueens(3);

    }
    public static int totalNQueens(int n) {
        totalNQueens_helper(1,n);
        return valid_number;

    }


    static class  position{
        public int x;
        public int y;
        public int xy;
        public int xandy;
        public position(int x, int y){
            this.x=x;
            this.y=y;
            this.xy=x-y;
            this.xandy=x+y;
        }

    }
    public static int valid_number = 0;
    public static LinkedList<position> valid=new LinkedList();

    public static void totalNQueens_helper(int n, int size) {
            if (n>size) {
            printQueen();

            valid_number++;
            valid.removeLast();
        } else {
            for (int i = 1; i <=size; i++) {
                if (not_be_attacked(n, i)) {
                   // System.out.println("xxxxxxxx="+i+"yyyyyy="+n);
                    valid.add(new position(i,n));

                    totalNQueens_helper(n + 1,size);
                }
            }
            if(!valid.isEmpty()) valid.removeLast();
        }

    }


    public static boolean not_be_attacked(int y, int x) {
        for (position p: valid){
            if(p.x==x||p.y==y||x-y==p.xy||x+y==p.xandy){
                return false;
            }
        }
        return true;
    }


    public static void printQueen(){
        for(position x:valid){
            System.out.print("x="+x.x+"  y="+x.y+"  ");
        }
        System.out.println();
    }



}
