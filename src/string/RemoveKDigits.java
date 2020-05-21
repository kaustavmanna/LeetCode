package string;/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:

    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

public class RemoveKDigits
{
    public static void main(String[] args)
    {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k)
    {
        if(num == null)
            return null;
        else if(num.length() == 0 || num.length() == k)
            return "0";

        StringBuilder stringBuilder = new StringBuilder(num);
        for(int i = 1; i <= k; i++)
        {
            boolean replaced = false;
            for(int j = 0; j < stringBuilder.length() - 1; j++)
            {
                if(stringBuilder.charAt(j) - stringBuilder.charAt(j+1) > 0)
                {
                    stringBuilder.deleteCharAt(j);
                    replaced = true;
                    break;
                }
            }
            if(!replaced)
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return String.valueOf(Integer.parseInt(stringBuilder.toString()));
    }
}
