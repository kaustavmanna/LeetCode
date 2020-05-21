/*
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
*/

package array;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueNumberOfOccurrences
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i:arr)
        {
            if(hashMap.containsKey(i))
                hashMap.put(i, hashMap.get(i) + 1);
            else
                hashMap.put(i, 1);
        }
        HashSet<Integer> hashSet = new HashSet<>(hashMap.values());
        return (hashMap.size() == hashSet.size());
    }
}
