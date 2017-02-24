
public class RectangleArea {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int Area1 = (C - A) * (D - B), Area2 = (G - E) * (H - F);
        int x1 = Math.max(A, E), x2 = Math.min(C, G);
        int y1 = Math.max(B, F), y2 = Math.min(D, H);
        if (x1 >= x2 || y1 >= y2) return Area1 + Area2;
        return Area1 + Area2 - (x2 - x1) * (y2 - y1);
    }

	public static void main(String[] args) {
		RectangleArea ra = new RectangleArea();
		System.out.println(ra.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}

}
