/*
Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that the denominator is less-than-or-equal-to n. The fractions can be in any order.

Example 1:
Input: n = 2
Output: ["1/2"]
Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.

Example 2:
Input: n = 3
Output: ["1/2","1/3","2/3"]

Example 3:
Input: n = 4
Output: ["1/2","1/3","1/4","2/3","3/4"]
Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".

Example 4:
Input: n = 1
Output: []

Constraints:
1 <= n <= 100
 */

package biweekly_contest_26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimplifiedFractions
{
    public static void main(String[] args)
    {
        int n = 4;
        List<String> list = simplifiedFractions(n);
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }

    public static List<String> simplifiedFractions(int n)
    {
        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            for(int j = 2; j <= n; j++)
            {
                if(i != j && i < j)
                {
                    double val = (double) i / j;
                    if(!hashSet.contains(String.valueOf(val)))
                    {
                        list.add(i + "/" + j);
                        hashSet.add(String.valueOf(val));
                    }
                }
            }
        }
        return list;
    }
}
