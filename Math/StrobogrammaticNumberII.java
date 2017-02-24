import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {
	
	public List<String> findStrobogrammatic(int n) {
		List<String> r = (n % 2 == 1) ? Arrays.asList("0", "1", "8") : Arrays.asList("");
		for (int i = (n % 2) + 2; i <= n; i+= 2) {
			List<String> list = new ArrayList<>();
			for (String s : r) {
				if (i != n) list.add('0' + s + '0');
				list.add('1' + s + '1');
				list.add('8' + s + '8');
				list.add('6' + s + '9');
				list.add('9' + s + '6');
			}
			r = list;
		}
		return r;
	}

	public static void main(String[] args) {
		StrobogrammaticNumberII sn = new StrobogrammaticNumberII();
		for (String num : sn.findStrobogrammatic(3)) {
			System.out.println(num);
		}
	}

}
