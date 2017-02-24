import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>(k);
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return result;
		int len1 = nums1.length, len2 = nums2.length;
		k = Math.min(len1 * len2, k);
		PriorityQueue<Tuple> pq = new PriorityQueue<>(k);
		
		for (int i = 0; i < Math.min(len1, k); i++) pq.offer(new Tuple(i, 0, nums1[i] + nums2[0]));
		while (k-- > 0) {
			Tuple t = pq.poll();
			result.add(new int[] { nums1[t.x], nums2[t.y] });
			if (t.y + 1 < len2) 
				pq.offer(new Tuple(t.x, t.y + 1, nums1[t.x] + nums2[t.y + 1]));
		}
		
		return result;
	}
	
	class Tuple implements Comparable<Tuple> {
		int x, y, val;
		public Tuple(int i, int j, int v) { this.x = i; this.y = j; this.val = v; }
		
		@Override
		public int compareTo(Tuple t) {
			return this.val - t.val;
		}
	}
	
	public static void main(String[] args) {
		KPairsSmallestSums kpss = new KPairsSmallestSums();
		int[] nums1 = new int[] {1,7,11}, nums2 = new int[] {2,4,6}; int k = 10;
		for (int[] comb : kpss.kSmallestPairs(nums1, nums2, k)) {
			System.out.println(comb[0] + "-->" + comb[1]);
		}
	}
}

