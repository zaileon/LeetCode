import java.util.Arrays;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) return 0;
		
		// Sort envelopes, width increasing and height decreasing
		Arrays.sort(envelopes, (e1, e2) -> {
			return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
		});
		
		// Longest Increasing Subsequence on heights
		int[] dp = new int[envelopes.length];
		int len = 0;
		for (int[] envelope : envelopes) {
			int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			if (index < 0) index = ~index;
			dp[index] = envelope[1];
			if (index == len) len++;
		}
		return len;
	}

	public static void main(String[] args) {
		RussianDollEnvelopes rde = new RussianDollEnvelopes();
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(rde.maxEnvelopes(envelopes));
	}

}
