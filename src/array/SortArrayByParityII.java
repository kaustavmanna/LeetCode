/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
You may return any answer array that satisfies this condition.

Example 1:
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Note:
2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
*/

package array;

public class SortArrayByParityII
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {4,2,5,7};
        SortArrayByParityII sortArrayByParity = new SortArrayByParityII();
        int[] sorted_arr = sortArrayByParity.sortArrayByParityII(arr);

        for(int i:sorted_arr)
            System.out.print(i + " ");
    }

    public int[] sortArrayByParityII(int[] A)
    {
        int even_index = 0;
        int odd_index = 1;

        while(even_index < A.length && odd_index < A.length)
        {
            while(even_index < A.length && A[even_index] % 2 == 0)
                even_index += 2;
            while(odd_index < A.length && A[odd_index] % 2 != 0)
                odd_index += 2;
            if(even_index < A.length && odd_index < A.length)
            {
                int temp = A[even_index];
                A[even_index] = A[odd_index];
                A[odd_index] = temp;
            }
        }
        return A;
    }
}
