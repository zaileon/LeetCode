
public class MergeTwoArrays {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		for (int k = m + n - 1; i >= 0 && j >= 0; k--) {
			if (nums1[i] > nums2[j]) nums1[k] = nums1[i--];
			else nums1[k] = nums2[j--];
		}
		while (j >= 0) {
			nums1[j] = nums2[j];
			j--;
		}
	}

	public static void main(String[] args) {
		MergeTwoArrays mta = new MergeTwoArrays();
		int[] nums1 = {1,2,6,6,7,8}, nums2 = {3,4,5};
		mta.merge(nums1, 3, nums2, 3);
		for (int i = 0; i < 6; i++) {
			System.out.println(nums1[i]);
		}
	}

}
