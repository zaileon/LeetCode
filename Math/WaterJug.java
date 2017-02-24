
public class WaterJug {
	
	// Bézout's identity
	// if z is a multiple of gcd of x, y, then there exist integers a, b s.t. ax+by=z
	public boolean canMeasureWater(int x, int y, int z) {
		if (z > x + y) return false;
		if (z == x || z == y || z == x + y) return true;
		return z % gcd(x, y) == 0;
	}
	
	private int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	public static void main(String[] args) {
		WaterJug wj = new WaterJug();
		System.out.println(wj.canMeasureWater(3, 5, 4));
		System.out.println(wj.canMeasureWater(2, 6, 5));
	}

}
