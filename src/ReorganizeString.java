import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReorganizeString {
    public static void main(String[] args) {
        //System.out.println(reorganizeString("baba"));

        String a = "kkkkzrkatkwpkkkktrq";
        a = reorganizeString(a);
        System.out.println(a);



    }

    public static String reorganizeString(String S) {
        LinkedList<Character> S_list = string_to_list(S);
        for (int current_index = 1; current_index < S_list.size() - 1; current_index++) {
            if (S_list.get(current_index).equals(S_list.get(current_index + 1)) || S_list.get(current_index).equals(S_list.get(current_index - 1))) {

                int insert_Index = find_insert_Index(S_list, current_index);
                if (insert_Index == current_index) {
                    System.out.println(S_list.toString());
                    S_list.clear();

                    break;
                } else {
                    S_list = insert_a_character(S_list, current_index, insert_Index);
                    current_index--;
                }
            }
        }
        String newString = "";

        for (int i = 0; i < S_list.size(); i++) {
            newString += S_list.get(i);
        }


        return newString;
    }


    public static int find_insert_Index(LinkedList<Character> S_list, int CurrentIndex) {

        for (int i = 0; i < S_list.size() - 1; i++) {
            if (S_list.get(CurrentIndex) != S_list.get(i) && S_list.get(CurrentIndex) != S_list.get(i + 1)) {

                return i;
            }
        }
        if (!S_list.get(0).equals(S_list.get(CurrentIndex))) {

            return -1;
        }

        if (!S_list.getLast().equals(S_list.get(CurrentIndex))) {
            return -2;
        }


        return CurrentIndex;
    }

    //insert to right, Success
    public static LinkedList<Character> insert_a_character(LinkedList<Character> S_list, int current_index, int insert_index) {
        if (insert_index == -1) {
            S_list.addFirst(S_list.get(current_index));
            S_list.remove(current_index + 1);
            return S_list;
        }
        if (insert_index == -2) {
            S_list.add(S_list.get(current_index));
            S_list.remove(current_index);
            return S_list;
        }


        Character temp = S_list.get(current_index);
        S_list.add(insert_index + 1, temp);
        if (insert_index < current_index) {
            S_list.remove(current_index + 1);
        }else {
            S_list.remove(current_index);
        }

        return S_list;
    }

    //Success
    public static LinkedList<Character> string_to_list(String S) {
        LinkedList<Character> S_list = new LinkedList<Character>();
        for (int i = 0; i < S.length(); i++) {
            S_list.add(S.charAt(i));
        }
        return S_list;
    }

//    public static String reorganizeString(String S) {
//        // 建表记录每个char出现的次数
//        int[] arr = new int[26];
//        for (int i = 0; i < S.length(); i++) {
//            arr[S.charAt(i) - 'a']++;
//        }
//
//        // 优先队列 max heap
 //   comparator
  //  [1, 11] [3, 5]
//        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
//        for (int i = 0; i < 26; i++) {
//            if (arr[i] != 0) {
//                // 次数,char
//                q.offer(new int[] { arr[i], i });
//            }
//        }
//
//        // 次数, char
//        int[] prev = new int[] { 0, -1 };
//        StringBuilder res = new StringBuilder();
//        while (!q.isEmpty()) {
//            // curr是q取出来的对应的char和次数
//            int[] curr = q.poll();
//
//            // poll了之后,如果prev有剩余,先加上pq
//            if (prev[0] > 0) {
//                q.offer(prev);
//            }
//
//            // build the answer
//            res.append((char) (curr[1] + 'a'));
//
//            // 将次数减一
//            curr[0]--;
//
//            // 记录前一个
//            prev = curr;
//
//            // 如果q里面没东西了,但是prev里面依然还剩char,证明剩下一项一定是重复的
//            if (q.isEmpty() && prev[0] > 0)
//                return "";
//        }
//        return res.toString();
//    }

//    public static String reorganizeString(String S) {
//        int l = S.length(), max = 0, cha = -1;
//        int[] arr = new int[26];
//
//        if (l < 2) {
//            return "";
//        }
//        if (l == 2) {
//            return S.charAt(0) == S.charAt(1) ? "" : S;
//        }
//
//        for (int i = 0; i < S.length(); i++) {
//            arr[S.charAt(i) - 'a']++;
//        }
//
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < l; i++) {
//            max = 0;
//            cha = -1;
//            for (int j = 0; j < 26; j++) {
//                // 如果对应的char出现不止一次
//                // 以及当前的char和上一个char不一样
//                // i == 0 为了照顾初始检查res.charAt(-1)
//                if (arr[j] > max && (i == 0 || j != res.charAt(res.length() - 1) - 'a')) {
//                    // 循环中,找到剩余中最多的cha
//                    // 并赋值到cha
//                    max = arr[j];
//                    cha = j;
//                    System.out.println("i is " + i + "; max is " + max + "; cha is " + cha + "; arr[j] is " + arr[j]);
//                }
//            }
//            if (max == 0)
//                return "";
//            res.append((char) (cha + 'a'));
//            arr[cha]--;
//        }
//        return res.toString();
//    }

}




