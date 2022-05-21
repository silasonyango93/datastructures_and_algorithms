package leetcode;

public class NoOfIslands {

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return noOfIslands;
    }

    public void dfs(char [][] grid, int i, int j) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        if (i < 0 || j < 0 || i >= rowLength || j >= columnLength || grid[i][j] == '0') {
            return;
        }

        //Mark the node as visited
        grid[i][j] = '0';

        dfs(grid,i - 1, j);
        dfs(grid,i + 1, j);
        dfs(grid,i, j - 1);
        dfs(grid,i, j + 1);
    }
}
