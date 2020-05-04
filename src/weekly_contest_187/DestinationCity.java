/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Example 3:
Input: paths = [["A","Z"]]
Output: "Z"

Constraints:
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
*/

package weekly_contest_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DestinationCity
{
    public static void main(String[] args)
    {

    }

    public static String destCity(List<List<String>> paths)
    {
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> city = new ArrayList<>();
        String destination_city = "";

        for(int i = 0; i < paths.size(); i++)
        {
            List<String> edge = paths.get(i);
            String source = edge.get(0);
            String dest = edge.get(1);

            hashMap.put(source, dest);
            if(!city.contains(source))
                city.add(source);
            if(!city.contains(dest))
                city.add(dest);
        }

        for(int i =0; i < city.size(); i++)
        {
            destination_city = city.get(i);
            while(hashMap.containsKey(destination_city))
                destination_city = hashMap.get(destination_city);
        }
        return destination_city;
    }
}
