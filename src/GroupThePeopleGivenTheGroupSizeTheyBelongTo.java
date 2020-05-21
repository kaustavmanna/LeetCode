/*
There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.
You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution.

Example 1:
Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].

Example 2:
Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]

Constraints:
groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo
{
    public static void main(String[] args)
    {
        int[] groupSizes = new int[] {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> list = groupThePeople(groupSizes);

        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes)
    {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++)
        {
            if(hashMap.containsKey(groupSizes[i]))
            {
                if(hashMap.get(groupSizes[i]).size() + 1 == groupSizes[i])
                {
                    List<Integer> index = hashMap.get(groupSizes[i]);
                    index.add(i);
                    list.add(index);
                    hashMap.remove(groupSizes[i]);
                }
                else
                {
                    List<Integer> index = hashMap.get(groupSizes[i]);
                    index.add(i);
                    hashMap.put(groupSizes[i], index);
                }
            }
            else if(groupSizes[i] == 1)
            {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                list.add(index);
            }
            else
            {
                List<Integer> count = new ArrayList<>();
                count.add(i);
                hashMap.put(groupSizes[i], count);
            }
        }
        return list;
    }
}
