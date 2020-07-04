/*
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701
*/

package string;

public class ExcelSheetColumnNumber
{
    public static void main(String[] args)
    {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }

    public int titleToNumber(String s)
    {
        int col_num = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            col_num = col_num * 26 + (c - 'A' + 1);
        }
        return col_num;
    }
}
