import java.util.Stack;
import java.util.*;
public class DecodeString {
    public static void main(String[] agrs){
        System.out.print(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            // 数字
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                // 直到数完数
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                // 添加到num_stack
                num_stack.push(count);
            }
            // [
            else if (s.charAt(i) == '[') {
                // 将前面的res enstack
                // System.out.println("enstack: " + res);
                str_stack.push(res);
                res = "";
                i++;
            }
            // ]
            else if (s.charAt(i) == ']') {
                // 将前面的那一段拿出来再加上当前的重复
                int n = num_stack.pop();
                res = str_stack.pop() + String.join("", Collections.nCopies(n, res));
                // System.out.println("res: " + res + "; remain: " + str_stack.size());
                i++;
            }
            // char
            else {
                res += s.charAt(i++);
            }
        }
        return res;
    }

//    public static String decodeString(String s) {
//        String temp ="";
//        String number = "";
//        Stack<Integer> parentheses_index= new Stack<Integer>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if(s.charAt(i)=='[') {
//                parentheses_index.add(i);
//
//            }else if(s.charAt(i)==']'){
//                int change_index = parentheses_index.pop();
//                temp=s.substring(change_index+1,i);
//                //find index of numbers
//                int number_start_index=0;
//
//                for(int j =change_index-1; j>=0; j--){
//                    if(Character.isDigit(s.charAt(j))){
//                        number = s.charAt(j) + number;
////                        System.out.println("number="+number);
//                        number_start_index=j;
//                    }else{
//                        break;
//                    }
//                }
//                int number_int = String_to_int(number);
//                number="";
////                System.out.println(number_start_index+"xxxxx");
////                System.out.println(i+"xxxxx");
////                System.out.println(temp+"xx");
////                System.out.println(number+"xx");
//
//                s = add_string(s,number_start_index,i,temp,number_int);
//
//                i=number_start_index;
//            }
//
//        }
//
//
//        return s;
//
//    }
//
//    public static String add_string(String original, int start_index, int end_index, String add, int multiple){
//        String temp = add;
//        for (int i = 0; i < multiple-1; i++) {
//            add += temp;
//        }
//        return original.substring(0,start_index)+add+original.substring(end_index+1);
//    }
//
//
//
//    //valid
//    public static int String_to_int(String number_string){
//        int i=1;
//        int number =0;
//        for (int j = number_string.length()-1; j >=0 ; j--) {
//            number += i*(number_string.charAt(j)-'0');
//            i = i*10;
//        }
//        return number;
//    }



}
