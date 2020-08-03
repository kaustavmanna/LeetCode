/*


You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its concatenation is equal to s and the number of distinct letters in p and q are the same.

Return the number of good splits you can make in s.



Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.

Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").

Example 3:

Input: s = "aaaaa"
Output: 4
Explanation: All possible splits are good.

Example 4:

Input: s = "acbadbaada"
Output: 2



Constraints:

    s contains only lowercase English letters.
    1 <= s.length <= 10^5


 */

package string;

import java.util.HashMap;

public class NumberOfGoodWaysToSplitAString
{
    public int numSplits(String s)
    {
        int count = 0;
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        hashMap1.put(s.charAt(0), 1);

        for(int i = 1; i < s.length(); i++)
        {
            if(hashMap2.containsKey(s.charAt(i)))
                hashMap2.put(s.charAt(i), hashMap2.get(s.charAt(i))+1);
            else
                hashMap2.put(s.charAt(i), 1);
        }

        if(hashMap1.keySet().size() == hashMap2.keySet().size())
            count++;

        for(int i = 1; i < s.length(); i++)
        {
            if(hashMap1.containsKey(s.charAt(i)))
                hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i))+1);
            else
                hashMap1.put(s.charAt(i), 1);

            if(hashMap2.containsKey(s.charAt(i)))
            {
                if(hashMap2.get(s.charAt(i)) == 1)
                    hashMap2.remove(s.charAt(i));
                else
                    hashMap2.put(s.charAt(i), hashMap2.get(s.charAt(i)) - 1);
            }

            if(hashMap1.keySet().size() == hashMap2.keySet().size())
                count++;
        }
        return count;
    }
}
