import java.util.Arrays;
import java.util.List;

public class ValidWordSquare {
	
	public boolean validWordSquare(List<String> words) {
		if (words == null || words.size() == 0) return true;
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= words.size() || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidWordSquare vws = new ValidWordSquare();
		List<String> words = Arrays.asList("abc", "b");
//		List<String> words = Arrays.asList("ball", "asee", "let", "lep");
//		List<String> words = Arrays.asList("ball", "asee", "lett", "le");
//		List<String> words = Arrays.asList("ball", "area", "read", "lady");
//		List<String> words = Arrays.asList("abcd", "bnrt", "crm", "dt");
//		List<String> words = Arrays.asList("abcd", "bnrt", "crmy", "dtye");
		System.out.println(vws.validWordSquare(words));
	}

}
