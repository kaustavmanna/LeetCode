package mathematics;/*
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
*/

public class SquareRoot
{
    public static void main(String[] args)
    {
        int x = 9;
        System.out.println("Square root of " + x + " is: " + sqrt(x));
    }

    public static int sqrt(int x)
    {
        if(x == 0 || x == 1)
            return x;

        long start = 1;
        long end = x;
        int result = 0;

        while(start <= end)
        {
            long mid = (start + end) / 2;
            if(mid * mid == x)
                return (int) mid;
            if(mid * mid < x)
            {
                start = mid + 1;
                result = (int) mid;
            }
            else
                end = mid - 1;
        }
        return result;
    }
}
