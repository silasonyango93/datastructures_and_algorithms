package leetcode;

public class NoOfIslands {

    /*
    *
    * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
    * */

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
