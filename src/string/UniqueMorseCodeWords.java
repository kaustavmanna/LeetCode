/*
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations, "--...-." and "--...--.".

Note:
The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.
 */

package string;

import java.util.HashSet;

public class UniqueMorseCodeWords
{
    public static void main(String[] args)
    {
        UniqueMorseCodeWords uniqueMorse = new UniqueMorseCodeWords();
        System.out.println(uniqueMorse.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }

    public int uniqueMorseRepresentations(String[] words)
    {
        String[] morsecodes = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hashSet = new HashSet<>();
        for (String word : words)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < word.length(); j++)
                stringBuilder.append(morsecodes[word.charAt(j) - 'a']);
            hashSet.add(stringBuilder.toString());
        }
        return hashSet.size();
    }
}