/*
Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).
Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.

Example 1:
Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4]
Explanation:
Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0.
Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"].
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].

Example 2:
Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
Output: [0,1]
Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the answer is [0,1].

Example 3:
Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
Output: [0,1,2,3]

Constraints:
1 <= favoriteCompanies.length <= 100
1 <= favoriteCompanies[i].length <= 500
1 <= favoriteCompanies[i][j].length <= 20
All strings in favoriteCompanies[i] are distinct.
All lists of favorite companies are distinct, that is, If we sort alphabetically each list then favoriteCompanies[i] != favoriteCompanies[j].
All strings consist of lowercase English letters only.
 */

package weekly_contest_189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList
{
    public static void main(String[] args)
    {
        List<List<String>> list = new ArrayList<>();
    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies)
    {
        List<Integer> index = new ArrayList<>();

        for(int i = 0; i < favoriteCompanies.size()-1; i++)
        {
            List<String> list1 = favoriteCompanies.get(i);
            boolean unique = true;
            for(int j = i + 1; j < favoriteCompanies.size(); j++)
            {
                List<String> list2 = favoriteCompanies.get(j);
                if(!compareList(list1, list2))
                    unique = false;
            }
            if(unique)
                index.add(i);
        }
        return index;
    }

    private static boolean compareList(List<String> list1, List<String> list2)
    {
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < list1.size(); i++)
            hashSet.add(list1.get(i));
        for(int i = 0; i < list2.size(); i++)
        {
            if(!hashSet.contains(list2.get(i)))
                return true;
        }
        return false;
    }
}
