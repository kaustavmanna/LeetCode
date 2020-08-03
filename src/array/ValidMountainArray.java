/*
Given an array A of integers, return true if and only if it is a valid mountain array.
Recall that A is a mountain array if and only if:
A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]

Example 1:
Input: [2,1]
Output: false

Example 2:
Input: [3,5,5]
Output: false

Example 3:
Input: [0,3,2,1]
Output: true

Note:
0 <= A.length <= 10000
0 <= A[i] <= 10000
*/

package array;

public class ValidMountainArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {1,2,3,4,3,2,1};
        System.out.println(new ValidMountainArray().validMountainArray(arr));
    }

    public boolean validMountainArray(int[] A)
    {
        if(A.length < 3)
            return false;

        boolean check_increase = false;
        boolean check_decrease = false;

        for(int i = 0; i < A.length - 1; i++)
        {
            if(A[i+1] == A[i])
                return false;
            else if(A[i+1] > A[i])
            {
                if(!check_decrease)
                    check_increase = true;
                else
                    return false;
            }
            else if(A[i+1] < A[i])
            {
                if(check_increase)
                    check_decrease = true;
                else
                    return false;
            }
        }
        return (check_increase && check_decrease);
    }
}
