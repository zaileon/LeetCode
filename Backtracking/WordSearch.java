
public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (search(board, i, j, 0, word)) return true;
			}
		}
		return false;
	}
	
	private boolean search(char[][] board, int i, int j, int start, String word) {
		if (start == word.length()) return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
		if (board[i][j] != word.charAt(start)) return false;
		board[i][j] = '*';
		boolean valid = search(board, i - 1, j, start + 1, word) || search(board, i + 1, j, start + 1, word) 
			         || search(board, i, j - 1, start + 1, word) || search(board, i, j + 1, start + 1, word);
		board[i][j] = word.charAt(start);
		return valid;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCCED")); // true
		System.out.println(ws.exist(board, "SEE")); // true
		System.out.println(ws.exist(board, "ABCB")); // false
		System.out.println(ws.exist(new char[][]{{'a'}}, "a"));
		System.out.println(ws.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
	}

}
