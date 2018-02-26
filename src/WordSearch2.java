import java.util.LinkedList;
import java.util.List;
public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        LinkedList<String> s_list=new LinkedList<>();
        for (int i=0; i<words.length;i++){
            if(!s_list.contains(words[i])&&exist(board,words[i])){
                s_list.add(words[i]);
            }
        }
        return s_list;

    }


    public static boolean exist(char[][] board, String word) {
        for (int colom=0; colom<board[0].length; colom++ ) {
            for (int row = 0; row <board.length; row++) {
                if(board[row][colom]==word.charAt(0)){
                    if(checkifTrue(board,row,colom,word,0)){
                        return true;
                    }
                }
            }
        }


        return false;

    }

    public static boolean checkifTrue(char[][] board,int row, int colom, String word, int cur_index){
        System.out.println("row="+row+" colom="+colom+" cur="+cur_index);
        if(row<0||colom<0||row>board.length-1||colom>board[0].length-1) return false;
        if(board[row][colom]!=word.charAt(cur_index)) return false;
        if(cur_index==word.length()-1) return true;

        char temp=board[row][colom];
        board[row][colom]='.';
        boolean searched=checkifTrue(board,row+1,colom,word,cur_index+1)||checkifTrue(board,row-1,colom,word,cur_index+1)||checkifTrue(board,row,colom+1,word,cur_index+1)||checkifTrue(board,row,colom-1,word,cur_index+1);
        board[row][colom]=temp;


        return searched;
    }
}
