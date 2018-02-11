//public class NumberofIslands {
//    public static void main(String[] args) {
//
//    }
//
//    public int numIslands(char[][] grid) {
//        char amount_island = 'a';
//        for (int y = 0; y < grid.clone().length; y++) {
//            for (int x = 0; x < grid.clone().length; x++) {
//                if (grid[x][y] == '1') {
//                    if (is_new_island(grid, x, y)) {
//                        grid[x][y] = amount_island;
//                        amount_island += 1;
//                    }else {
//
//                    }
//                }
//            }
//
//        }
//
//    }
//
//
//
//    public boolean left_empty(char[][] grid, int x, int y) {
//        boolean left = false;
//        if (x == 0) {
//            left = true;
//        } else if (grid[x - 1][y] == '0') {
//            left = true;
//        }
//
//        return left;
//
//    }
//    public boolean right_empty(char[][] grid, int x, int y) {
//        boolean left = false;
//        boolean up = false;
//        if (x == 0) {
//            left = true;
//        } else if (grid[x - 1][y] == '0') {
//            left = true;
//        }
//
//
//        if (y == 0) {
//            up = true;
//        } else if (grid[x][y - 1] == '0') {
//            up = true;
//        }
//
//        return up && left;
//
//    }
//}
