import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] agrs) {
        char[][] x = new char[10][8];
        solve(x);
    }

    static int[][] int_board;

    public static void solve(char[][] board) {
        int_board = new int[board.length][board.clone().length];
        for (int y = 0; y < board.clone().length; y++) {
            for (int x = 0; x < board.length; x++) {
                int_board[x][y] = y * board.length + x + 1;
            }
        }

        for(int x = 0; x<board.length; x++){
            if(board[x][0]=='O'){
                int_board[x][0]=-1;
            }
            if(board[x][board.clone().length-1]=='O'){
                int_board[x][board.clone().length-1]=-1;
            }
        }

        for(int y = 0; y<board.length; y++){
            if(board[0][y]=='O'){
                int_board[0][y]=-1;
            }
            if(board[board.length-1][y]=='O'){
                int_board[board.length-1][y]=-1;
            }
        }

        for (int y = 0; y < board.clone().length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (int_board[x][y] == 'O') {
                    if (x + 1 < board.length) {
                        if (int_board[x + 1][y] == 'O') {
                            connect(x, y, x + 1, y);
                        }
                    }
//
////                    if (x - 1 >= 0) {
////                        if (int_board[x - 1][y] == 'O') {
////                            connect(x, y, x - 1,y);
////                        }
////                    }
////                    if (y - 1 >= 0) {
////                        if (int_board[x - 1][y] == 'O') {
////                            connect(x, y, x, y-1);
////                        }
////                    }
                    if (y + 1 >= 0) {
                        if (int_board[x - 1][y] == 'O') {
                            connect(x, y, x ,y+1);
                        }
                    }
                }
            }
        }

        for (int y = 0; y < int_board.clone().length; y++) {
            for (int x = 0; x < int_board.length; x++) {

            }
        }

    }

    public static void connect(int x1, int y1, int x2, int y2) {

    }
    public static int root (int x, int y){
        return 0;
    }
    public boolean check (int x, int y){
        return  true;
    }
}
