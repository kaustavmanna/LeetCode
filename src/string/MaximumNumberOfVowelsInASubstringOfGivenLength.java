/*
Given a string s and an integer k.
Return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are (a, e, i, o, u).

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

Example 4:
Input: s = "rhythms", k = 4
Output: 0
Explanation: We can see that s doesn't have any vowel letters.

Example 5:
Input: s = "tryhard", k = 4
Output: 1

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
1 <= k <= s.length
*/

package string;

import java.util.HashSet;

public class MaximumNumberOfVowelsInASubstringOfGivenLength
{
    public static void main(String[] args)
    {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k)
    {
        int max = 0;
        int curr_count = 0;

        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');

        if(s.length() < k)
            return max;

        for(int i = 0; i < k; i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                curr_count++;
        }
        max = curr_count;

        for(int i = 1; i <= s.length() - k; i++)
        {
            if(hashSet.contains(s.charAt(i - 1)))
                curr_count--;
            if(hashSet.contains(s.charAt(i + k - 1)))
                curr_count++;
            max = Math.max(max, curr_count);
        }
        return max;
    }
}
