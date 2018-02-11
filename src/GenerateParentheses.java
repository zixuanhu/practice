import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class GenerateParentheses {
    public static void main(String[] args) {
       List<String> x=generateParenthesis(3);
       System.out.println(Arrays.toString(x.toArray()));
       //use recursion to generate all possibilities and pick the valid one
        // idea from internet

    }


    public static List<String> generateParenthesis(int n) {
        List<String> list= new LinkedList<String>();
        generateParenthesis1(n, 0, 0, "",list);
        return list;
    }


    public static  void generateParenthesis1(int number_Parentheis, int left_Parentheis, int right_Parentheis, String s_Parentheis, List<String> list){
        if(left_Parentheis<right_Parentheis||left_Parentheis>number_Parentheis||right_Parentheis>number_Parentheis){
                return;
        }

            if (left_Parentheis==number_Parentheis && right_Parentheis== number_Parentheis){
                list.add(s_Parentheis);
            return;
        }
        generateParenthesis1(number_Parentheis, left_Parentheis+1,right_Parentheis,s_Parentheis+'（',list);
        generateParenthesis1(number_Parentheis, left_Parentheis,right_Parentheis+1,s_Parentheis+'）',list);




    }

//    public static List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        if(n == 0){
//            return result;
//        }
//        return helper(result, "", n, n);
//    }
//    private static List<String> helper(List<String> result, String tmp, int left, int right){
//        if(right == 0){
//            result.add(tmp);
//        }
//        //注意right是倒着走的
//        if(right > left){
//            helper(result, tmp + ")", left, right - 1);
//        }
//        if(left > 0){
//            helper(result, tmp + "(", left - 1, right);
//        }
//        return result;
//    }
}
