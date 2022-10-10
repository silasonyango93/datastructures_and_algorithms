package leetcode.binary_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*74. Search a 2D Matrix
*
* Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
* */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;//i will be looping through rows
        int j = matrix[0].length - 1;//Number of columns
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    @Test
    public void testSolution() {
        int[][] testArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
       assert searchMatrix(testArray, 8);
    }
}
