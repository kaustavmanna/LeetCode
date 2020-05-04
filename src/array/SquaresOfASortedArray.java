/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

package array;

import java.util.Arrays;

public class SquaresOfASortedArray
{
    public static void main(String[] args)
    {
        int[] arr = {-4, 0, 1, 3};
        int[] sorted_arr = sortedSquares(arr);

        for(int i:sorted_arr)
            System.out.print(i + " ");
    }

    public static int[] sortedSquares(int[] arr)
    {
        int[] sortedarr = new int[arr.length];
        for(int i = 0; i < sortedarr.length; i++)
            sortedarr[i] = arr[i] * arr[i];
        Arrays.sort(sortedarr);
        return sortedarr;
    }
}
