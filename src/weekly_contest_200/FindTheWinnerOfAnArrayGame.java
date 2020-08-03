/*
Given an integer array arr of distinct integers and an integer k.
A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0 and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.
Return the integer which will win the game.
It is guaranteed that there will be a winner of the game.

Example 1:
Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.

Example 2:
Input: arr = [3,2,1], k = 10
Output: 3
Explanation: 3 will win the first 10 rounds consecutively.

Example 3:
Input: arr = [1,9,8,2,3,7,6,4,5], k = 7
Output: 9

Example 4:
Input: arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
Output: 99

Constraints:
2 <= arr.length <= 10^5
1 <= arr[i] <= 10^6
arr contains distinct integers.
1 <= k <= 10^9
*/

package weekly_contest_200;

import java.util.LinkedList;
import java.util.List;

public class FindTheWinnerOfAnArrayGame
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {1,11,22,33,44,55,66,77,88,99};
        int k = 1000000000;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k)
    {
        if(k >= arr.length)
        {
            int max = Integer.MIN_VALUE;
            for(int i:arr)
                max = Math.max(i, max);
            return max;
        }
        else
        {
            LinkedList<Integer> list = new LinkedList<>();
            for(int i:arr)
                list.add(i);
            int count = 0;
            while(count != k)
            {
                if(list.get(0) > list.get(1))
                {
                    Integer integer = list.remove(1);
                    list.addLast(integer);
                    count++;
                }
                else
                {
                    Integer integer = list.remove(0);
                    list.addLast(integer);
                    count = 1;
                }
            }
            return list.get(0);
        }
    }
}
