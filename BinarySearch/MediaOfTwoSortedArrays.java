
public class MediaOfTwoSortedArrays {
	
	// assume i, j is the cutting points of A, B respectively, i + j === (m - i) + (n - j)
	// we have j = (m + n) / 2 - i (when m + n is even),       or j = (m + n + 1) / 2 - i (when m + n is odd, e.g. m = 5, n = 8)
	// The median is (max(A[i-1],B[j-1]) + min(A[i],B[j]) / 2, or   max(A[i-1],B[j-1])
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1); // ensure m <= n so that j is always valid
		int m = nums1.length, n = nums2.length;
		int imin = 0, imax = m, half = (m + n + 1) / 2, i = 0, j = 0, max_left, min_right;
		while (imin <= imax) {
			i = (imin + imax) / 2;
			j = half - i;
			// i too small, B[j-1] > A[i], increase i
			if (i < m && nums2[j - 1] > nums1[i]) imin = i + 1; // i < m => j > 0 as j = (m+n+1)/2-i>(m+n+1)/2-m>=(n-m+1)/2>=0
			// i too large, B[j] < A[i-1], decrease i
			else if (i > 0 && nums1[i - 1] > nums2[j]) imax = i - 1; // similar as above, i > 0 => j < n
			// i is perfect so that A[i-1] < B[j] AND B[j-1] < A[i]
			else break;
		}
		if (i == 0) max_left = nums2[j - 1];
		else if (j == 0) max_left = nums1[i - 1];
		else max_left = Math.max(nums1[i - 1], nums2[j - 1]);
		// if m + n  is odd, we only need to return max(A[i-1],B[j-1]) as there is one extra element on the left
		if (((m + n) & 1) == 1) return max_left;
		// otherwise, we need to get min(A[i],B[j]) and return the average
		if (i == m) min_right = nums2[j];
		else if (j == n) min_right = nums1[i];
		else min_right = Math.min(nums1[i], nums2[j]);
		
		return (max_left + min_right) / 2.0;
	}
	
	public static void main(String[] args) {
		MediaOfTwoSortedArrays mtsa = new MediaOfTwoSortedArrays();
		int[] nums1 = {1,3}, nums2 = {2};
//		int[] nums1 = {10,12,30,32,66}, nums2 = {12,12,25,36,40,49,50,91};
		System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
	}
}
