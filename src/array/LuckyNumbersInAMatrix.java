/*
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]

Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
*/

package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1,10,4,2}, {9,3,8,7}, {15,16,17,12}};

        List<Integer> luckynumbers = luckyNumbers(matrix);

        for(int i:luckynumbers)
            System.out.print(i + " ");
    }

    public static List<Integer> luckyNumbers(int[][] matrix)
    {
        List<Integer> luckynumbers = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
        {
            int minrow = findminrowindex(matrix, i);
            int maxcol = findmaxcolindex(matrix, minrow);

            if(i == maxcol)
                luckynumbers.add(matrix[i][minrow]);
        }
        return luckynumbers;
    }

    private static int findminrowindex(int[][] matrix, int index)
    {
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for(int i = 0; i < matrix[index].length; i++)
        {
            if(matrix[index][i] < min)
            {
                min = matrix[index][i];
                min_index = i;
            }
        }
        return min_index;
    }

    private static int findmaxcolindex(int[][] matrix, int index)
    {
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][index] > max)
            {
                max = matrix[i][index];
                max_index = i;
            }
        }
        return max_index;
    }
}
