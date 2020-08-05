/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int value : nums1)
        {
            if (hashMap.containsKey(value))
                hashMap.put(value, hashMap.get(value) + 1);
            else
                hashMap.put(value, 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int value : nums2)
        {
            if (hashMap.containsKey(value))
            {
                list.add(value);
                if (hashMap.get(value) == 1)
                    hashMap.remove(value);
                else
                    hashMap.put(value, hashMap.get(value) - 1);
            }
        }

        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
        return arr;
    }
}
