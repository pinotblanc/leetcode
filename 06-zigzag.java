/*
6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"

 

Constraints:

    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000
*/

class Solution {

  public String convert(String s, int numRows) {
    if (numRows == 1) return s;

    StringBuilder solution = new StringBuilder();

    for (int r = 1; r <= numRows; ++r) {
      int i = r - 1;
      boolean alternate = false;

      while (i < s.length()) {
        solution.append(s.charAt(i));

        if (r == 1 || r == numRows) i += 2 * (numRows - 1); // on first/last row: skip one corner
        else { // on middle row:
          if (alternate) i += 2 * (r - 1); // skip upper corner
          else i += 2 * (numRows - r); // skip lower corner
          alternate = !alternate;
        }
      }
    }
    return solution.toString();
  }

  public static void main(String[] args) {
    System.out.println((new Solution()).convert("PAYPALISHIRING", 4));
    System.out.println("PINALSIGYAHRPI");
  }
}
/*
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
*/
