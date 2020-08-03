/*
A boomerang is a set of 3 points that are all distinct and not in a straight line.
Given a list of three points in the plane, return whether these points are a boomerang.

Example 1:
Input: [[1,1],[2,3],[3,2]]
Output: true

Example 2:
Input: [[1,1],[2,2],[3,3]]
Output: false

Note:
points.length == 3
points[i].length == 2
0 <= points[i][j] <= 100
*/

package mathematics;

public class ValidBoomerang
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][] {{1,1}, {2,2}, {3,3}};
        System.out.println(isBoomerang(arr));
    }

    public static boolean isBoomerang(int[][] points)
    {
        int Ax = points[0][0];
        int Ay = points[0][1];
        int Bx = points[1][0];
        int By = points[1][1];
        int Cx = points[2][0];
        int Cy = points[2][1];
        double areaOfTriangle = (double)(Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / 2.0d;
        return (areaOfTriangle != 0.0d);
    }
}
