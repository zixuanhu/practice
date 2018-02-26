import java.util.Arrays;
import java.util.Queue;

public class SurroundedRegions {

    public static void main(String[] agrs) {
        char[][] x = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(x);
        for(char[] row:x){
            System.out.println(Arrays.toString(row));
        }

    }



    public static void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        //up and down
        for(int col=0; col<board[0].length; col++){
            if(board[0][col]=='O')occupy(board, 0, col);
            if(board[board.length-1][col]=='O')occupy(board,board.length-1,col);
        }
        //left and right
        for (int row = 1; row < board.length-1; row++) {
            if(board[row][0]=='O') occupy(board,row,0);
            if(board[row][board[0].length-1]=='O') occupy(board,row,board[0].length-1);
        }

        //fill all O
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[0].length ; col++) {
                if(board[row][col]=='O'){
                    board[row][col]='X';
                }
                if(board[row][col]=='1'){
                    board[row][col]='O';
                }
            }

        }

    }


    public static void occupy(char[][] board, int row, int col){
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!='O') return;
        board[row][col]='1';
        occupy(board,row+1,col);
        occupy(board,row-1,col);
        occupy(board,row,col+1);
        occupy(board,row,col-1);


    }

}
