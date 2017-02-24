import java.util.ArrayList;
import java.util.List;

public class JustifyText {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		for (int i = 0, j = 0; j < words.length;) {
			int length = words[i].length();
			while (++j < words.length && length + words[j].length() + 1 <= maxWidth) {
				length += words[j].length() + 1;
			}
			int extraSpaces = maxWidth - length + (j - i - 1);
			int totalSpaces = 0;
			StringBuilder sb = new StringBuilder(words[i]);
			for (int k = 1; k < j - i; k++) {
				int numOfSpaces = (j == words.length) ? 1 : 
					extraSpaces / (j - i - 1) + (k <= extraSpaces % (j - i - 1) ? 1 : 0);
				int space = 0;
				while (space++ < numOfSpaces) sb.append(' ');
				totalSpaces += numOfSpaces;
				sb.append(words[i + k]);
			}
			while (totalSpaces++ < extraSpaces) sb.append(' ');
			i = j;
			result.add(sb.toString());
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		JustifyText jt = new JustifyText();
		String[] words = {"Listen","to","many,","speak","to","a","few."}; int maxWidth = 6;
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."}; int maxWidth = 16;
		for (String line : jt.fullJustify(words, maxWidth)) {
			System.out.println(line);
		}
	}
}
