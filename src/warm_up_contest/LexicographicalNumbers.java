/*
Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/

package warm_up_contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNumbers
{
    public static void main(String[] args)
    {
        int n = 13;
        List<Integer> nums = lexicalOrder(n);
        for(Integer i:nums)
            System.out.print(i + " ");
    }

    public static List<Integer> lexicalOrder(int n)
    {
        String[] nums = new String[n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++)
            nums[i] = Integer.toString(i+1);

        Arrays.sort(nums);

        for(String s:nums)
            result.add(Integer.parseInt(s));

        return result;
    }
}
