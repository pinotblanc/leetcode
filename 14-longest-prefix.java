/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.

*/

class Solution {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) return strs[0];

    StringBuilder out = new StringBuilder();

    boolean finished = false;

    for (
      int i = 0;
      i < strs[0].length();
      ++i
    ) { // iterate chars
      for (
        int word = 1;
        word < strs.length;
        ++word
      ) { // iterate words
        if (
          strs[word].length() <= i || strs[word].charAt(i) != strs[0].charAt(i)
        ) {
          finished = true;
          break;
        }
        if (word == strs.length - 1) out.append(strs[0].charAt(i));
      }
      if (finished) break;
    }
    return out.toString();
  }
}
