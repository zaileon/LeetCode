
public class GuessGame {
	public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            int res = guess(mid);
            if (res < 0) high = mid;
            else if (res > 0) low = mid + 1;
            else return mid;
        }
        return 0;
    }
	
	int target = 6;
	
	public int guess(int num) {
		if (target < num) return -1;
		if (target > num) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		GuessGame gg = new GuessGame();
		System.out.println(gg.guessNumber(10));
	}
}
