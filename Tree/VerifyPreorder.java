public class VerifyPreorder {

	public boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE, i = -1;
		for (int p : preorder) {
			if (p < low) return false;
			while (i >= 0 && p > preorder[i]) low = preorder[i--];
			preorder[++i] = p;
		}
		return true;
	}
	
	public static void main(String[] args) {
		VerifyPreorder vp = new VerifyPreorder();
//		int[] preorder = {2,3,1};
		int[] preorder = {4,2,1,3,6,5,7};
		System.out.println(vp.verifyPreorder(preorder));
	}
}
