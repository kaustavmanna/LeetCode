/*
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Example 1:
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:
Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

Constraints:
0 <= low <= high <= 10^9
*/

package mathematics;

public class CountOddNumbersInAnIntervalRange
{
    public static void main(String[] args)
    {
        System.out.println(countOdds(3,7));
    }

    public static int countOdds(int low, int high)
    {
        int res = (high - low) / 2;
        if(low % 2 != 0 || high % 2 != 0)
            res++;
        return res;
    }
}
