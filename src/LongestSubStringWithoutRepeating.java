import java.util.*;
public class LongestSubStringWithoutRepeating {
    public static void main(String[] agrs){
        int a = lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);
    }
    public int lengthOfLongestSubstring1(String s) {
        char[] Arrays = s.toCharArray();
        int max = 0;
        LinkedList<Character> longest = new LinkedList<Character>();
        for (Character i : Arrays) {
            if (!longest.contains(i)) {
                longest.add(i);
                max = Math.max(max, longest.size());
            }else {
                int index_pre_i=longest.indexOf(i);

                while(longest.getFirst()!=i) {
                    longest.removeFirst();
                }
                longest.removeFirst();
                longest.add(i);

            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String longest = new String();

        for (int i = 0; i <s.length(); i++) {
            CharSequence x= s.substring(i,i+1);
            if(!longest.contains(x)){
                longest=longest+x;
                max = Math.max(max, longest.length());
            }else {
                int index_pre_x=longest.indexOf(s.charAt(i));
                longest=longest.substring(index_pre_x+1);
                longest=longest+x;
            }

        }

        return max;
    }
}
