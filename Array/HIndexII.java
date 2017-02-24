
public class HIndexII {

	// Binary search
	// if (citations[mid] >= len -mid), it means there are at least len-mid papers that have citations[mid], 
	// we should continue searching on the left half, otherwise search the right half.
	public int hIndex(int[] citations) {
		int len = citations.length;
		int l = 0, r = len;
		while (l < r) { // search in [l,r), stop when l==r
			int mid = l + (r - l) / 2;
			if (citations[mid] > len - mid) r = mid; // mid qualify, but there may be smaller one, start search from mid to left
			else if (citations[mid] < len - mid) l = mid + 1; // mid violate, start from mid+1 to right
			else return len - mid;
		}
		return len - l;
	}
	
	public static void main(String[] args) {
		HIndexII hi = new HIndexII();
		System.out.println(hi.hIndex(new int[] {}));
		System.out.println(hi.hIndex(new int[] {0}));
		System.out.println(hi.hIndex(new int[] {1}));
		System.out.println(hi.hIndex(new int[] {0,1,3,5,6}));
		System.out.println(hi.hIndex(new int[] {5,5,5,5,5}));
		System.out.println(hi.hIndex(new int[] {1,1,1,1,1}));
		System.out.println(hi.hIndex(new int[] {10,10,10,10,10}));
		System.out.println(hi.hIndex(new int[] {4,4,4,4,4}));
	}
}
