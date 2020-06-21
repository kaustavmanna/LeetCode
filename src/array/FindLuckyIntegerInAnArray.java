/*
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

Example 1:
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Example 4:
Input: arr = [5]
Output: -1

Example 5:
Input: arr = [7,7,7,7,7,7,7]
Output: 7

Constraints:
1 <= arr.length <= 500
1 <= arr[i] <= 500
*/

package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindLuckyIntegerInAnArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {2, 2, 3, 4};
        FindLuckyIntegerInAnArray findLuckyIntegerInAnArray = new FindLuckyIntegerInAnArray();
        System.out.println(findLuckyIntegerInAnArray.findLucky(arr));
    }

    public int findLucky(int[] arr)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr)
        {
            if (hashMap.containsKey(value))
                hashMap.put(value, hashMap.get(value) + 1);
            else
                hashMap.put(value, 1);

            hashSet.add(value);
        }

        List<Integer> alist = new ArrayList<>(hashSet);
        int max_lucky = -1;

        for(int i = 0; i < alist.size(); i++)
        {
            if(hashMap.get(alist.get(i)) == alist.get(i))
                max_lucky = Math.max(max_lucky, alist.get(i));
        }
        return max_lucky;
    }
}
