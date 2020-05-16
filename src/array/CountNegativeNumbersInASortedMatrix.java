/*
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
Return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Example 3:
Input: grid = [[1,-1],[-1,-1]]
Output: 3

Example 4:
Input: grid = [[-1]]
Output: 1

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
*/

package array;

public class CountNegativeNumbersInASortedMatrix
{
    public static void main(String[] args)
    {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid)
    {
        int c_length = grid[0].length;
        int count = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < c_length; j++)
            {
                if(grid[i][j] < 0)
                {
                    count += (grid.length - i) * (c_length - j);
                    c_length = j;
                }
            }
        }
        return count;
    }
}
