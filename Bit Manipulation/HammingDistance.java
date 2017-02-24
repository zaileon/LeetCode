
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int z = x ^ y;
		int dist = 0;
		while (z > 0) {
			z -= z & (-z);
			dist++;
		}
		return dist;
	}
	
	public static void main(String[] args) {
		HammingDistance hd  = new HammingDistance();
		System.out.println(hd.hammingDistance(1, 4));
		System.out.println(hd.hammingDistance(1, 4));
	}
}
