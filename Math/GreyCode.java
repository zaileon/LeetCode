import java.util.ArrayList;
import java.util.List;

public class GreyCode {

	public List<Integer> greyCode(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		GreyCode gc = new GreyCode();
		for (int i : gc.greyCode(2)) {
			System.out.println(i);
		}
	}
}
