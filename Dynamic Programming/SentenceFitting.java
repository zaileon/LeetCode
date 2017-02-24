
public class SentenceFitting {
	
	// every row starts with one of n possible words
	// for each word, find out how many repetitions a row starting with that word has of the sentence,
	// and the index of word in the next row
	// then do a sum of rows, based on which word the row starts with
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int n = sentence.length;
		int start, index, time;
		int[] nextIndex = new int[n], times = new int[n];
		for (int i = 0; i < n; i++) {
			start = 0; index = i; time = 0;
			while (start + sentence[index].length() <= cols) {
				start += sentence[index++].length() + 1;
				if (index == n) {
					index = 0;
					time++;
				}
			}
			nextIndex[i] = index; // the index of word in the next row if the row starts with words[i]
			times[i] = time; // the number of repetitions of the sentence if starting with words[i]
		}
		int total = 0;
		index = 0;
		for (int i = 0; i < rows; i++) {
			total += times[index];
			index = nextIndex[index];
		}
		return total;
    }
	
	public static void main(String[] args) {
		SentenceFitting sf = new SentenceFitting();
//		String[] sentence = {"I", "had", "apple", "pie"}; int rows = 4, cols = 5;
//		String[] sentence = {"a", "bcd", "e"}; int rows = 3, cols = 6;
		String[] sentence = {"a", "b", "e"}; int rows = 20000, cols = 20000;
//		String[] sentence = {"hello", "world"}; int rows = 2, cols = 8;
		System.out.println(sf.wordsTyping(sentence, rows, cols));
	}
}
