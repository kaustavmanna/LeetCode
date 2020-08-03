/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Constraints:
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
*/

package array;

public class ReplaceElementsWithGreatestElementOnRightSide
{
    public int[] replaceElements(int[] arr)
    {
        int temp = 0;
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(i == arr.length - 1)
            {
                temp = arr[i];
                arr[i] = -1;
            }
            else
            {
                if(arr[i] > temp)
                {
                    int temp2 = arr[i];
                    arr[i] = temp;
                    temp = temp2;
                }
                else
                    arr[i] = temp;
            }
        }
        return arr;
    }
}
