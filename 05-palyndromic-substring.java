/*
5. Longest Palindromic Substring

Given a string s, return the longest
palindromic
substring
in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.
*/

class Solution {

  public String longestPalindrome(String s) {
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); ++i) {
      int len1 = findPalindrome(s, i, i);
      int len2 = findPalindrome(s, i, i + 1);
      int longest = Math.max(len1, len2);

      if (longest > end - start) {
        start = i - (longest - 1) / 2;
        end = i + longest / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int findPalindrome(String s, int left, int right) {
    while (
      left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
    ) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  public static void main(String[] args) {
    System.out.println((new Solution()).longestPalindrome("cbbd"));
  }
}