
public class ArithmeticSlice {
	public int numberOfArithmeticSlice(int[] A) {
		if (A.length < 3) return 0;
		int sum = 0, l = 1, diff = A[1] - A[0];
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i + 1] - A[i] == diff) {
				l++;
			} else {
				sum += l * (l - 1) / 2;
				diff = A[i + 1] - A[i];
				l = 1;
			}
		}
		if (l > 1) sum += l * (l - 1) / 2;
		return sum;
	}
	
	public static void main(String[] args) {
		ArithmeticSlice as = new ArithmeticSlice();
		int[] A = {1,2,3};
//		int[] A = {1,2,3,5,7};
//		int[] A = {1,2,3,4};
		System.out.println(as.numberOfArithmeticSlice(A));
	}
}
