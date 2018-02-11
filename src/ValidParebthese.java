
import java.util.Stack;

public class ValidParebthese {
    public static void main(String[] args) {
        System.out.println(isValid("["));

    }


    public static boolean isValid(String s) {
        Stack<Character> paranthess_check = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                paranthess_check.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (paranthess_check.isEmpty()) {
                    return false;
                }
                Character x = paranthess_check.pop();
                if (!isMatch(s.charAt(i), x)) {
                    return false;
                }
            }
        }

        if(paranthess_check.isEmpty()){
            return true;
        }else {
            return false;
        }


    }


    private static boolean isMatch(Character pop, Character pop2) {
        char right = pop;
        char left = pop2;
        if ((int) right - (int) left <= 2 && (int) right - (int) left >= 1) {
            return true;
        }
        return false;
    }


}
