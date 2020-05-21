/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input: s: "cbaebabacd" p: "abc"
Output: [0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

package string;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString
{
    public static void main(String[] args)
    {
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        for(Integer i:list)
            System.out.print(i + " ");
    }

    public static List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        int len = p.length();

        if (s == null || s.length() == 0 || s.length() < p.length())
            return list;

        int[] charmap_p = new int[26];
        int[] charmap_s = new int[26];

        for(int i = 0; i < p.length(); i++)
            charmap_p[p.charAt(i) - 'a']++;

        for (int i = 0; i < p.length(); i++)
            charmap_s[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length() - p.length(); i++)
        {
            if (isMatching(charmap_p, charmap_s))
                list.add(i);
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new window
            charmap_s[s.charAt(i+p.length()) - 'a']++;
            charmap_s[s.charAt(i) - 'a']--;
        }

        if (isMatching(charmap_p, charmap_s))
            list.add(s.length() - p.length());

        return list;
    }

    private static boolean isMatching(int[] a, int[] b)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
