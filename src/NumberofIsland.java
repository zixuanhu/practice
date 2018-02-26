import java.util.Arrays;

public class NumberofIsland {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        printgrid(grid);
        int num = 0;
        boolean[][] checked= new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1'&&checked[row][col]==false) {
                    helper(grid, row, col, checked);
                    printgrid(grid);
                    num++;
                }
            }
        }
        return num;

    }



    public static void helper(char[][] grid, int row, int col, boolean[][] checked) {
        checked[row][col]=true;
        //down
        if (row + 1 < grid.length && grid[row + 1][col] == '1'&&checked[row+1][col]==false) {
            helper(grid, row + 1, col,checked);
        }
        //up
        if (row - 1 >= 0 && grid[row - 1][col] == '1'&&checked[row-1][col]==false) {
            helper(grid, row - 1, col,checked);
        }
        //left
        if (col - 1 >= 0 && grid[row][col - 1] == '1'&&checked[row][col-1]==false) {
            helper(grid, row, col - 1,checked);
        }
        //right
        if (col + 1 < grid[0].length && grid[row][col + 1] == '1'&&checked[row][col+1]==false) {
            helper(grid, row, col + 1,checked);
        }
        return;

    }


    public static void printgrid(char[][] grid) {

        for (int row = 0; row < grid.length; row++) {
            System.out.println(Arrays.toString(grid[row]));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


    }
}
