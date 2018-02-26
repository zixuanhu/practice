import java.util.LinkedList;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        //check horizontal
        LinkedList<Character> check = new LinkedList<>();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[x][y] != '.') {
                    check.add(board[x][y]);
                }
            }
            if (reapeated(check)) {
                return false;
            }
            check.clear();
        }

        //check vertical
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    check.add(board[x][y]);
                }
            }
            if (reapeated(check)) {
                return false;
            }
            check.clear();
        }
        //check square

            for (int begin_x=0; begin_x<9; begin_x+=3){
                for (int begin_y=0; begin_y<9; begin_y+=3){
                    if(board[begin_x][begin_y]!='.')check.add(board[begin_x][begin_y]);
                    if(board[begin_x+1][begin_y]!='.')check.add(board[begin_x+1][begin_y]);
                    if(board[begin_x+2][begin_y]!='.')check.add(board[begin_x+2][begin_y]);
                    if(board[begin_x][begin_y+1]!='.')check.add(board[begin_x][begin_y+1]);
                    if(board[begin_x+1][begin_y+1]!='.')check.add(board[begin_x+1][begin_y+1]);
                    if(board[begin_x+2][begin_y+1]!='.')check.add(board[begin_x+2][begin_y+1]);
                    if(board[begin_x][begin_y+2]!='.')check.add(board[begin_x][begin_y+2]);
                    if(board[begin_x+1][begin_y+2]!='.')check.add(board[begin_x+1][begin_y+2]);
                    if(board[begin_x+2][begin_y+2]!='.')check.add(board[begin_x+2][begin_y+2]);

                    if(reapeated(check)){
                        return false;
                    }
                    check.clear();
                }
        }



        return true;

    }

    public static boolean reapeated(LinkedList<Character> val) {
        while (val.size()>1) {
            char temp = val.getFirst();
            val.removeFirst();
            if (val.contains(temp)) {
                return true;
            }
        }
        return false;
    }

}
