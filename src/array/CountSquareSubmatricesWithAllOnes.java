/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:
Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.

Constraints:
1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/

package array;

public class CountSquareSubmatricesWithAllOnes
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        CountSquareSubmatricesWithAllOnes sqmatrix = new CountSquareSubmatricesWithAllOnes();
        System.out.println(sqmatrix.countSquares(matrix));
    }

    public int countSquares(int[][] matrix)
    {
        int count = 0;
        int[][] sqmatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if((i == 0 || j == 0) && matrix[i][j] == 1)
                {
                    sqmatrix[i][j] = 1;
                    count += 1;
                }
                else if(i == 0 || j == 0 && matrix[i][j] == 0)
                    sqmatrix[i][j] = 0;
                else if(matrix[i][j] == 1)
                {
                    int min = Math.min(Math.min(sqmatrix[i][j-1],sqmatrix[i-1][j]), sqmatrix[i-1][j-1]);
                    sqmatrix[i][j] = min + 1;
                    count += min + 1;
                }
                else
                    sqmatrix[i][j] = 0;
            }
        }
        return count;
    }
}
