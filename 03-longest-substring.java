/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring
without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/

import java.util.HashMap;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    int start = 0, longest = 0;
    HashMap<Character, Integer> charIndexMap = new HashMap<>();

    for (int end = 0; end < s.length(); ++end) {
      if (
        charIndexMap.containsKey(s.charAt(end))
      ) { // get result w/o char and remove front end
        int doubleCharIndex = charIndexMap.get(s.charAt(end));
        longest = Math.max(longest, end - start);
        for (int i = start; i < doubleCharIndex; ++i) charIndexMap.remove(
          s.charAt(i)
        );
        start = doubleCharIndex + 1;
      }
      charIndexMap.put(s.charAt(end), end);
    }
    longest = Math.max(longest, s.length() - start);
    return longest;
  }
}