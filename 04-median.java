/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
*/

class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i1 = 0, i2 = 0;
    int[] merged = new int[nums1.length + nums2.length];

    for (
      int i = 0;
      i < merged.length;
      ++i
    ) { // merge nums1 and nums2 in merged
      if (i1 >= nums1.length) {
        merged[i] = nums2[i2];
        ++i2;
      } else if (i2 >= nums2.length) {
        merged[i] = nums1[i1];
        ++i1;
      } else if (nums1[i1] < nums2[i2]) {
        merged[i] = nums1[i1];
        ++i1;
      } else {
        merged[i] = nums2[i2];
        ++i2;
      }
    }

    if (merged.length % 2 != 0) return merged[merged.length / 2]; else return (
      (double) (merged[(merged.length / 2) - 1] + merged[merged.length / 2]) / 2
    );
  }
}