
public class KthSmallestInLexicoOrder {

	public int findKthNumber(int n, int k) {
		int curr = 1;
		k--;
		while (k > 0) {
			// search the numbers that has curr as prefix, i.e. [curr,curr+1), [curr*10,(curr+1)*10),...
			int gap = 0;
			for (long first = curr, last = curr + 1; first <= n; first *= 10, last *= 10) {
				gap += Math.min(n + 1, last) - first; // valid interval = [n1,n2) intersect [n1,n]
			}
			// if k is greater than the gap, skip curr, go to numbers that have curr+1 as prefix 
			if (gap <= k) {
				curr += 1;
				k -= gap;
			} else {
				// else go in more detail, by appending the next digit, always start with curr*10
				curr *= 10;
				k -= 1;
			}
		}
		return curr;
	}
	
	public static void main(String[] args) {
		KthSmallestInLexicoOrder ks = new KthSmallestInLexicoOrder();
		System.out.println(ks.findKthNumber(13, 8));
	}
}
