import java.util.*;

public class SkyLineProblem {
    public class Building implements Comparable<Building> {
        int left;
        int right;
        int height;

        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
        public String toString(){
            return "["+left+" "+right+" "+height+"]";
        }

        @Override
        public int compareTo(Building o) {

            if (this.height != o.height) {
                return Integer.compare(this.height, o.height);
            }
            if (this.left != o.left) {
                return Integer.compare(this.left, o.left);
            }
            if (this.right != o.right) {
                return Integer.compare(this.right, o.right);
            } return 0;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> result= new LinkedList<>();
        if(buildings.length==0){
            return result;
        }
        //build building array
        Building[] building_arr = new Building[buildings.length];

        for (int i = 0; i < buildings.length; i++) {
            building_arr[i] = new Building(buildings[i][0], buildings[i][1], buildings[i][2]);
        }
        Building[] right = building_arr.clone();
        Building[] left = building_arr.clone();

        //sort building based on right
        Arrays.sort(right, (a, b) -> {
            if (a.right != b.right) {
                return Integer.compare(a.right, b.right);
            }
            if (a.height != b.height) {
                return Integer.compare(a.height, b.height);
            }
            if (a.left != b.left) {
                return -Integer.compare(a.left, b.left);
            }
            return 0;
        });

        //sort building based on left
        Arrays.sort(left, (a, b) -> {
            if (a.left != b.left) {
                return Integer.compare(a.left, b.left);
            }
            if (a.height != b.height) {
                return Integer.compare(a.height, b.height);
            }
            if (a.right != b.right) {
                return Integer.compare(a.right, b.right);
            }
            return 0;
        });

        int index_left = 1;
        int index_right = 0;
        TreeSet<Building> set = new TreeSet<>();
        set.add(left[0]);
        int height = left[0].height;
        result.add(new int[]{ left[0].left , height });
        while (index_right < right.length) {
            int index;
            if (index_left<right.length&&left[index_left].left < right[index_right].right) {
                set.add(left[index_left]);
                System.out.println("add "+left[index_left].toString());
                index=left[index_left].left;
                index_left++;
            } else {
                set.remove(right[index_right]);
                System.out.println("remove "+right[index_right].toString());
                index=right[index_right].right;
                index_right++;
            }

            int top=0;
            if (!set.isEmpty()) {
                top = set.last().height;
            }
            if(height!=top){
                result.add(new int[]{ index , top });
                height=top;
            }

        }
        return result;


    }
}
