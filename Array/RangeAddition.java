
public class RangeAddition {
	
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] result = new int[length];
		for (int i = 0; i < updates.length; i++) {
			result[updates[i][0]] += updates[i][2];
			if (updates[i][1] < length - 1) result[updates[i][1] + 1] -= updates[i][2];
		}
		int sum = result[0];
		for (int i = 1; i < length; i++) {
			sum += result[i];
			result[i] = sum;
		}
		return result;
	}

	public static void main(String[] args) {
		RangeAddition ra = new RangeAddition();
		int length = 10; int[][] updates = {{2,4,6}, {5,6,8},{1,9,-4}};
//		int length = 5; int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
		for (int i : ra.getModifiedArray(length, updates)) {
			System.out.println(i);
		}
	}

}
