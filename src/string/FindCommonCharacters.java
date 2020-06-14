/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]

Note:
1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
*/

package string;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters
{
    public static void main(String[] args)
    {
        String[] strings = new String[] {"bella","label","roller"};
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        List<String> list = findCommonCharacters.commonChars(strings);
        for(String s:list)
            System.out.print(s + " ");
    }

    public List<String> commonChars(String[] A)
    {
        int[] arr = new int[26];
        for(int i = 0; i < A[0].length(); i++)
            arr[A[0].charAt(i) - 'a']++;

        for(int i = 1; i < A.length; i++)
        {
            int[] temp_arr = new int[26];

            for(int j = 0; j < A[i].length(); j++)
                temp_arr[A[i].charAt(j) - 'a']++;

            findcommonchar(arr, temp_arr);
        }

        List<String> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
        {
            while(arr[i] != 0)
            {
                list.add(Character.toString((char) i + 'a'));
                arr[i]--;
            }
        }
        return list;
    }

    private void findcommonchar(int[] arr, int[] arr2)
    {
        for(int i = 0; i < arr.length; i++)
            arr[i] = Math.min(arr[i], arr2[i]);
    }
}
