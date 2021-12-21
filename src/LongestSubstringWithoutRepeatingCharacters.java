import java.util.HashMap;



public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("aabbcd"));
    }

    public static int lengthOfLongestSubstring(String s)
    {
        if(s == null)
        {
            return 0;
        }
        if(s.length() == 0)
        {
            return 0;
        }
        if(s.length() == 1)
        {
            return 1;
        }

        HashMap<Character,Integer> letters = new HashMap<>();
        letters.put(s.charAt(0),0);

        int start = 0;
        int end = 1;
        int longest = 1;

        while (end < s.length())
        {
            char l = s.charAt(end);
            if(letters.containsKey(l))
            {
                int newStartIndex = letters.get(l) + 1;
                for (int i = start; i < newStartIndex; i++)
                {
                    letters.remove(s.charAt(i));
                }
                start = newStartIndex;
                letters.put(l,end);
                end++;
            }
            else
            {
                letters.put(l,end);
                end++;
                longest = Math.max(end - start, longest);

            }
        }

        return longest;
    }
}
