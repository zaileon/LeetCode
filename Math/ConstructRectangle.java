
public class ConstructRectangle {

	public int[] constructRectangle(int area) {
		int W = (int)Math.sqrt(area);
		while (area % W != 0) W--;
		return new int[] {area / W, W};
	}
	
	public static void main(String[] args) {
		ConstructRectangle cr = new ConstructRectangle();
		int area = 3;
		for (int i : cr.constructRectangle(area)) {
			System.out.println(i);
		}
	}
}
