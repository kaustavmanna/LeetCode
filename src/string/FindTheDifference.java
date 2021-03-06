/*
Given two strings s and t which consist of only lowercase letters.
String t is generated by random shuffling string s and then add one more letter at a random position.
Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/

package string;

public class FindTheDifference
{
    public static void main(String[] args)
    {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t)
    {
        int[] char_arr = new int[26];

        for(int i = 0; i < s.length(); i++)
            char_arr[s.charAt(i) - 'a']++;

        for(int i = 0; i < t.length(); i++)
        {
            if(char_arr[t.charAt(i) - 'a'] > 0)
                char_arr[t.charAt(i) - 'a']--;
            else
                return t.charAt(i);
        }
        return ' ';
    }
}
