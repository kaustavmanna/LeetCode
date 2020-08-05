/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?
*/

package mathematics;

public class PowerOfFour
{
    public static void main(String[] args)
    {
        int num = 1;
        System.out.println(isPowerOfFour(num));
    }

    public static boolean isPowerOfFour(int num)
    {
        if(num == 1)
            return true;
        else if(num % 4 != 0)
            return false;

        String binary = Integer.toBinaryString(num);

        if(binary.length() % 2 == 0)
            return false;

        if(binary.charAt(0) != '1')
            return false;

        for(int i = 1; i < binary.length(); i++)
        {
            if(binary.charAt(i) != '0')
                return false;
        }

        return true;
    }
}
