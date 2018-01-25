import java.util.LinkedList;

public class JosephusSurvivor {
    public static void main(String[] args) {
      System.out.println(josephusSurvivor(14,2));
      //System.out.println(find_Index(16,18,3));
    }
    public static int josephusSurvivor(final int n, final int k) {
        LinkedList<Integer> people=new LinkedList<Integer>();
        for (int i = 0; i <n ; i++) {
            people.add(i+1);
        }

        int Index_remove = find_Index(0,people.size(),k);
        while (people.size()>1){
            people.remove(Index_remove);
            Index_remove=find_Index(Index_remove, people.size(), k);


        }
        return people.get(0);
    }

    public static int find_Index(int Index_remove, int amount_people, int k){
        if(Index_remove+k-1 < amount_people){
            return Index_remove+k-1;
        }

        if(Index_remove +1 > amount_people){
            Index_remove=0;
            return find_Index(Index_remove, amount_people, k);
        }

        if(Index_remove +k-1 >=amount_people){
            k= Index_remove+k-amount_people;
            Index_remove=0;
            return  find_Index(Index_remove, amount_people, k);
        }

        return Index_remove;
    }
}
