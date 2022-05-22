package leetcode;

public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int maxLandArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxLandArea = Math.max(maxLandArea,dfs(grid,i,j));
                }
            }
        }
        return maxLandArea;
    }

    public int dfs(int [][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        //Mark node as visited
        grid[i][j] = 0;
        int count = 1;

        count+= dfs(grid,i + 1, j);
        count+= dfs(grid,i - 1, j);
        count+= dfs(grid,i, j + 1);
        count+= dfs(grid,i, j - 1);
        return count;
    }
}
