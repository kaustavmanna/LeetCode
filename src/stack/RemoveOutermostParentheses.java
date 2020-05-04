/*
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Example 1:
Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:
Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".

Note:
S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string
*/

package stack;

import java.util.Stack;

public class RemoveOutermostParentheses
{
    public static void main(String[] args)
    {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s)
    {
        int start = 0;
        String result = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')')
                stack.pop();

            if(stack.isEmpty())
            {
                result = result + s.substring(start+1,i);
                start = i+1;
            }
        }
        return result;
    }

    public static String removeOuterParentheses_V2(String s)
    {
        String result = "";
        int start = 0;
        int open = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(open == 0)
                start = i;

            char c = s.charAt(i);
            if(c == '(')
                open++;
            else if(c == ')')
                open--;

            if(open == 0)
                result = result + s.substring(start + 1, i);
        }
        return result;
    }
}
