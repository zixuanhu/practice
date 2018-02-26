import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;

public class recursionTest {
    public static void main(String[] agrs){

        String[] dict= new String[]{"i", "a", "am", "zixuan","zixuan1"};
        List<String> d = Arrays.asList(dict);
        String s = "IamZixuan11";
        s=s.toLowerCase();
        System.out.println(isSentenceInDict(s, d));

    }


        public static boolean isSentenceInDict(String s, List<String> dict){
            if(s.length() == 0) return true;
            for (int i = 1 ; i < s.length() + 1; i++){
                if(dict.contains(s.substring(0, i).toLowerCase())){
                    if (isSentenceInDict(s.substring(i), dict)){
                        return true;
                    }
                }
            }
            return false;
        }


}
