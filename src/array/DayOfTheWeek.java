/*
Given a date, return the corresponding day of the week for that date.
The input is given as three integers representing the day, month and year respectively.
Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

Example 1:
Input: day = 31, month = 8, year = 2019
Output: "Saturday"

Example 2:
Input: day = 18, month = 7, year = 1999
Output: "Sunday"

Example 3:
Input: day = 15, month = 8, year = 1993
Output: "Sunday"

Constraints:
The given dates are valid dates between the years 1971 and 2100.
*/

package array;

import java.time.LocalDate;

public class DayOfTheWeek
{
    public static void main(String[] args)
    {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }

    public static String dayOfTheWeek(int day, int month, int year)
    {
        LocalDate localDate = LocalDate.of(year, month, day);
        String s =  String.valueOf(localDate.getDayOfWeek()).toLowerCase();
        String sub = s.substring(0,1).toUpperCase();
        return (sub + s.substring(1));
    }
}
