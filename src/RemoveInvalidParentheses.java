import java.util.LinkedList;
import java.util.*;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        // removeInvalidParentheses("(()())()");
        System.out.println(removeInvalidParentheses("(((k()((").toString());

    }


    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<String>();
        res = remove_extra_right(s, res);
        LinkedList<String> new_res = new LinkedList<String>();
        for(String str: res){
            if(!new_res.contains(str))
                new_res.add(str);
        }



        return new_res;
    }

    public static List<String> remove_extra_right(String s, List<String> res) {
        int pair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pair++;
            } else if (s.charAt(i) == ')') {
                pair--;
            }

            if (pair < 0) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(j) == ')' && (j == 0 || s.charAt(j - 1) != ')')) {
                       // System.out.println(j + "xxxxxx" + (s.substring(0, j) + s.substring(j + 1)));
                        remove_extra_right(s.substring(0, j) + s.substring(j + 1), res);
                    }
                }
                break;


            }

        }

        if (pair >= 0) {
            List<String> s_list = new LinkedList<String>();
            s_list = remove_extra_left(s, s_list);
            for (String s1 : s_list) {
                res.add(s1);

            }
        }

        return res;
    }


    public static List<String> remove_extra_left(String s, List<String> res) {
        int pair = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                pair++;
            } else if (s.charAt(i) == '(') {
                pair--;
            }

            if (pair < 0) {
                for (int j = s.length() - 1; j >= i; j--) {
                    if (s.charAt(j) == '(' && (j == s.length()-1 || s.charAt(j + 1) != '(')) {
                        System.out.println(j + "xxxxxx" + (s.substring(0, j) + s.substring(j + 1)));
                        remove_extra_right(s.substring(0, j) + s.substring(j + 1), res);
                    }
                }
                break;


            }

        }
        if (pair >= 0) {
            res.add(s);
        }
        return res;
    }


}
