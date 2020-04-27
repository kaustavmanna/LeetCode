/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false
*/

package string;

public class ValidPalindrome
{
    public static void main(String[] args)
    {
        String s = "Madam, I'm Adam!";
        System.out.println("Is " + s + " Palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            while(i < j && !(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))))
                i++;
            while(i < j && !(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j))))
                j--;
            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
                return false;
        }
        return true;
    }
}
