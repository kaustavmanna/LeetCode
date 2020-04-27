/*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:
Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:
Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:
Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.

Example 4:
Input: s = "covid2019"
Output: "c2o0v1i9d"

Example 5:
Input: s = "ab123"
Output: "1a2b3"

Constraints:
1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/

package string;

public class ReformatTheString
{
    public static void main(String[] args)
    {
        String s = "Covid2019";
        System.out.println(reformat(s));
    }

    public static String reformat(String s)
    {
        String digit = "";
        String characters = "";
        String result = "";
        boolean digit_considered = false;

        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLetter(s.charAt(i)))
                characters = characters + s.charAt(i);
            else
                digit = digit + s.charAt(i);
        }

        int i = digit.length() - 1;
        int j = characters.length() - 1;

        if(Math.abs(i-j) > 1)
            return "";

        if(i > j)
        {
            while(i >= 0 && j >= 0)
            {
                result = result + digit.charAt(i--);
                result = result + characters.charAt(j--);
            }
            result = result + digit.charAt(i);
        }

        else if(j > i)
        {
            while(i >= 0 && j >= 0)
            {
                result = result + characters.charAt(j--);
                result = result + digit.charAt(i--);
            }
            result = result + characters.charAt(j);
        }

        else
        {
            while(i >= 0 && j >= 0)
            {
                result = result + characters.charAt(j--);
                result = result + digit.charAt(i--);
            }
        }

        return result;
    }
}
