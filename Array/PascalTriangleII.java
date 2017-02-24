import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<>(rowIndex + 1);
		if (rowIndex < 0) return row;
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				row.set(j, row.get(j) + row.get(j - 1));
			}
			row.add(1);
		}
		return row;
	}
	
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		for (int i : pt.getRow(3)) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
