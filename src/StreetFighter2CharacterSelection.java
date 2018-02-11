import java.util.Arrays;

public class StreetFighter2CharacterSelection {
    public static void main(String[] args) {
        String[][] fighters ={{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},{"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}};
        int[] initial_position = {0,0};
        String[] moves ={"up", "left", "down", "right", "up", "left", "down", "right"};
        System.out.println(Arrays.toString(streetFighterSelection(fighters,initial_position,moves)));

    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        String[] fighter_selection = new String[moves.length];

        for (int i = 0; i < moves.length; i++) {
            position = position_mover(position, moves[i], fighters[0].length);

            fighter_selection[i]=fighters[position[0]][position[1]];
        }

        return fighter_selection;
//        String[] res = new String[moves.length];
//        for (int i = 0; i < moves.length; i++) {
//            if (moves[i] == "up") {
//                if (position[0] != 0) {
//                    position[0] -= 1;
//                }
//            } else if (moves[i] == "down") {
//                if (position[0] != fighters.length - 1) {
//                    position[0] += 1;
//                }
//            } else if (moves[i] == "left") {
//                if (position[1] == 0) {
//                    position[1] = fighters[0].length - 1;
//                } else {
//                    position[1] -= 1;
//                }
//            } else if (moves[i] == "right") {
//                if (position[1] == fighters[0].length - 1) {
//                    position[1] = 0;
//                } else {
//                    position[1] += 1;
//                }
//            }
//            res[i] = fighters[position[0]][position[1]];
//        }
//        // System.out.println(Arrays.toString(res));
//        return res;
    }

    public static int[] position_mover(int[] position, String movement, int length_of_row){
        if(movement.equals("up")){
            if(position[0]==1) position[0]=0;
            //if(position[0] != 0) position[0] -= 1;
        }
        if(movement.equals("down")){
            if(position[0]==0) position[0]=1;
            //if(position[0] != fighters[0].length - 1) position[1] -= 1;

        }
        if(movement.equals("left")){
            position[1]=position[1]-1;
            if (position[1]==-1){
                position[1]=length_of_row-1;
            }
        }
        if(movement.equals("right")){
            position[1]=position[1]+1;
            if (position[1]==length_of_row){
                position[1]=0;
            }
        }
        return position;
    }
}
