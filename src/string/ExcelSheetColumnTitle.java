/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
...

Example 1:
Input: 1
Output: "A"

Example 2:
Input: 28
Output: "AB"

Example 3:
Input: 701
Output: "ZY"
*/

package string;

public class ExcelSheetColumnTitle
{
    public static void main(String[] args)
    {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(701));
    }

    public String convertToTitle(int n)
    {
        StringBuilder stringBuilder = new StringBuilder();
        while(n > 0)
        {
            int remainder = (n - 1) % 26;
            stringBuilder.append((char)('A' + remainder));
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }
}
