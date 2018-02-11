import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //System.out.println(reorganizeString("baba"));                                                                                                                                                                                                

        String a = "vxabb";
        System.out.println(reorganizeString(a));

    }

    public static String reorganizeString(String S) {
        List S_list = Arrays.asList(S.split(""));

        for (int i = 0; i < S_list.size() - 1; i++) {
            if (i + 1 == S_list.size() - 1) {
                if (!S_list.get(i).equals(S_list.get(i + 1))) {
                    System.out.println(S_list.get(i + 1));
                    return new String(S_list.toString());
                } else {
                    int insert_index = find_insert_Index(S_list, i);
                    if (insert_index == i) {
                        break;
                    } else {
                        Character temp = (Character) S_list.get(i);
                        S_list.add(insert_index + 1, temp);
                        S_list.remove(i + 1);
                        return new String((S_list.toString()));
                    }

                }

            }


            if (S_list.get(i) == S_list.get(i + 1)) {
                int different_char_index = find_next_different(S_list, i);
                if (different_char_index == i) {
                    int insert_index = find_insert_Index(S_list, i);
                    if (insert_index == i) {
                        break;
                    } else {
                        //insert
                        Character temp = (Character) S_list.get(i);
                        S_list.add(insert_index + 1, temp);
                        S_list.remove(i + 1);
                    }


                    break;
                }
                //exchange i and different char index
                Character temp_char = (Character) S_list.get(i);
                S_list.set(i, S_list.get(different_char_index));
                S_list.set(different_char_index, temp_char);
            }
        }


        return "";
    }

    public static int find_next_different(List S_list, int CurrentIndex) {
        for (int i = CurrentIndex; i < S_list.size(); i++) {
            if (S_list.get(CurrentIndex) != S_list.get(i)) {
                return i;
            }
        }

        return CurrentIndex;

    }

    public static int find_insert_Index(List S_list, int CurrentIndex) {
        for (int i = 0; i < S_list.size(); i++) {
            if (S_list.get(CurrentIndex) != S_list.get(i) && S_list.get(CurrentIndex) != S_list.get(i + 1)) {
                return i;
            }
        }

        return CurrentIndex;
    }

}                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                       