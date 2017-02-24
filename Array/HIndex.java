
public class HIndex {
	
	// one observation is h can not be greater than N, so we count every paper that has more than N citation into the category that has exactly N citations
	public int hIndex(int[] citations) {
		int N = citations.length;
		int[] c = new int[N + 1];
		for (int citation : citations) {
			if (citation > N) c[N]++;
			else c[citation]++;
		}
		int sum = 0;
		for (int h = N; h >= 0; h--) {
			sum += c[h];
			if (sum >= h) return h;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		HIndex hi = new HIndex();
		int[] citations = {3,0,6,1,5};
		System.out.println(hi.hIndex(citations));
	}
}
