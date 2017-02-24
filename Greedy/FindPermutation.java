
public class FindPermutation {
	
	public int[] findPermutation(String s) {
		int n = s.length();
		int[] result = new int[n + 1];
		int i = 0, j = 0;
		while (i <= n) {
			while (j < n && s.charAt(j) == 'D') j++;
			// reverse the numbers [i,j], i.e. [i+1,j+1]
			int j1 = j + 1;
			while (i <= j) {
				result[i++] = j1--;
			}
			j++; // after while loop, i == j + 1, we need to j++ to keep up with i
		}
		return result;
	}

	public static void main(String[] args) {
		FindPermutation fp = new FindPermutation();
//		String s = "I"; // 12
//		String s = "DI"; // 213
//		String s = "ID"; // 132
		String s = "DDII"; //32145
		for (int num : fp.findPermutation(s)) {
			System.out.println(num);
		}
	}

}
