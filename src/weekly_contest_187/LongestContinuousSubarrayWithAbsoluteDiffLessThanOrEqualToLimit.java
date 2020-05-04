/*
Given an array of integers nums and an integer limit, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to limit.
In case there is no subarray satisfying the given condition return 0.

Example 1:
Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.

Example 2:
Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

Example 3:
Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9
*/

package weekly_contest_187;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {10,1,2,4,7,2};
        System.out.println(longestSubarray(nums, 5));
    }

    public static int longestSubarray(int[] nums, int limit)
    {
        for(int i = nums.length-1; i >= 0; i--)
        {
            int j = 0;
            while(i + j < nums.length)
            {
                int start = j;
                int end = i+j;
                j++;

                int[] maxmin = findmaxmin(nums, start, end);
                int maxdiff = Math.abs(nums[maxmin[0]] - nums[maxmin[1]]);
                if(maxdiff <= limit)
                    return Math.abs(start - end) + 1;
            }
        }
        return 0;
    }

    private static int[] findmaxmin(int[] nums, int start, int end)
    {
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for(int i = start; i <= end; i++)
        {
            if(max <= nums[i])
            {
                max = nums[i];
                max_index = i;
            }

            if(min >= nums[i])
            {
                min = nums[i];
                min_index = i;
            }
        }
        return new int[] {max_index, min_index};
    }
}
