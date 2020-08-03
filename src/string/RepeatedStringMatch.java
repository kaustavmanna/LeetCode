/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
For example, with A = "abcd" and B = "cdabcdab".
Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

package string;

import java.util.HashMap;
import java.util.HashSet;

public class RepeatedStringMatch
{
    public static void main(String[] args)
    {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }

    public static int repeatedStringMatch(String A, String B)
    {
        int[] char_arr = new int[26];
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < B.length(); i++)
        {
            char c = B.charAt(i);
            char_arr[c - 'a'] = 1;
            if(!hashMap.containsKey(c))
                hashMap.put(c, 1);
            else
                hashMap.put(c, hashMap.get(c) + 1);
        }

        for(int i = 0; i < A.length(); i++)
        {
            char c = A.charAt(i);
            if(char_arr[c - 'a'] == 1)
                char_arr[c - 'a'] = 0;
        }

        for (int value : char_arr)
        {
            if (value != 0)
                return -1;
        }

        int count = 0;
        while(hashMap.size() != 0)
        {
            count++;
            for(int i = 0; i < A.length(); i++)
            {
                char c = A.charAt(i);
                if(hashMap.containsKey(c))
                {
                    if(hashMap.get(c) == 1)
                        hashMap.remove(c);
                    else
                        hashMap.put(c, hashMap.get(c) - 1);
                }
                if(hashMap.size() == 0 && i != A.length() - 1)
                    return count;
            }
        }
        return (count + 1);
    }
}
