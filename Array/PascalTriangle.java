import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows <= 0) return result;
		List<Integer> row = Arrays.asList(1);
		result.add(row);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> r = new ArrayList<>();
			r.add(1);
			for (int j = 0; j < row.size() - 1; j++) {
				r.add(row.get(j) + row.get(j + 1)); 
			}
			r.add(1);
			result.add(r);
			row = r;
		}
		return result;
	}
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		for (List<Integer> row : pt.generate(2)) {
			for (int i : row) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
