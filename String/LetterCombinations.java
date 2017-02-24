import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

//	private Map<Character, List<Character>> phone;
//	
//	{
//		phone = new HashMap<Character, List<Character>>();
//		phone.put('2', Arrays.asList('a', 'b', 'c'));
//		phone.put('3', Arrays.asList('d', 'e', 'f'));
//		phone.put('4', Arrays.asList('g', 'h', 'i'));
//		phone.put('5', Arrays.asList('j', 'k', 'l'));
//		phone.put('6', Arrays.asList('m', 'n', 'o'));
//		phone.put('7', Arrays.asList('p', 'q', 'r', 'r'));
//		phone.put('8', Arrays.asList('t', 'u', 'v'));
//		phone.put('9', Arrays.asList('w', 'x', 'y', 'z'));
//	}
//	
//	public List<String> letterCombinations(String digits) {
//		List<String> result = new ArrayList<String>();
//		if (digits.length() > 0) {
//			backtrack(digits, 0, new StringBuffer(), result);
//		}
//		return result;
//	}
//	
//	private void backtrack(String digits, int start, StringBuffer sb, List<String> result) {
//		if (start == digits.length()) {
//			result.add(sb.toString());
//			return;
//		}
//		for (char c : phone.get(digits.charAt(start))) {
//			sb.append(c);
//			backtrack(digits, start + 1, sb, result);
//			sb.setLength(sb.length() - 1);
//		}
//	}
	
	// BFS solution, faster
	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<String>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char c : mapping[x].toCharArray()) {
					result.add(t + c);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
//		String digits = "";
		String digits = "23";
		for (String comb : lc.letterCombinations(digits)) {
			System.out.println(comb);
		}
	}

}
