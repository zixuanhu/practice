import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> answer = partitionLabels(s);
        System.out.println(answer.toString());
        //s.indexOf('a') -> 0
        //s.indexOf('a', 9) -> -1

    }

    public static List<Integer> partitionLabels(String S) {
        LinkedList<Integer> part = new LinkedList<Integer>();


        //store the end index of each char
        int[] end = new int[26];


        //store the begin index of each char
        for (int i = S.length() - 1; i >= 0; i--) {
            System.out.println(S.charAt(i));
            end[(int) S.charAt(i) - 97] = Math.max(end[(int) S.charAt(i) - 97], i);

        }


        for (int i = 0, startindex = 0, endIndex = end[(int) S.charAt(0) - 97]; i < S.length(); i++) {
            if (i == endIndex) {
                part.add(endIndex - startindex + 1);
                startindex = i + 1;
                if (startindex <= S.length()-1) {
                    endIndex = end[(int) S.charAt(startindex) - 97];
                }
            }
            endIndex = Math.max(end[(int) S.charAt(i) - 97], endIndex);


        }

        return part;

    }
}
