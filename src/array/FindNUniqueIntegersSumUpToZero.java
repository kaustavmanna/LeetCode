/*
Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:
Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:
Input: n = 3
Output: [-1,0,1]

Example 3:
Input: n = 1
Output: [0]

Constraints:
1 <= n <= 1000
*/

package array;

public class FindNUniqueIntegersSumUpToZero
{
    public static void main(String[] args)
    {
        int n = 6;
        int[] arr = sumZero(n);
        for(int i:arr)
            System.out.print(i + " ");
    }

    public static int[] sumZero(int n)
    {
        if(n == 1)
            return new int[] {0};

        int[] arr = new int[n];
        int mid = n / 2;
        int index = 0;

        for(int i = -mid; i <= mid; i++)
        {
            if(i == 0 && n % 2 == 0)
                continue;
            arr[index++] = i;
        }
        return arr;
    }
}
