
public class KeyboardRow {

	public String[] findWords(String[] words) {
		String[] rows = {"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};
		int[] rowLabel = new int[256];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < rows[i].length(); j++) rowLabel[rows[i].charAt(j)] = i + 1;
		}
		String[] result = new String[words.length];
		int k = 0;
		for (String word : words) {
			int row = rowLabel[word.charAt(0)];
			int j = 0;
			for (; j < word.length(); j++) {
				if (rowLabel[word.charAt(j)] != row) break;
			}
			if (j == word.length()) result[k++] = word;
		}
		String[] res = new String[k];
		System.arraycopy(result, 0, res, 0, k);
		return res;
	}
	
	public static void main(String[] args) {
		KeyboardRow kr = new KeyboardRow();
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res = kr.findWords(words);
		System.out.println(res.length);
		for (String w : res) System.out.println(w);
	}
}
