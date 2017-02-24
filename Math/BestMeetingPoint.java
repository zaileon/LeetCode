public class BestMeetingPoint {

	public int minTotalDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int[] X = new int[m], Y = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			++X[i];
                	++Y[j];
        		}
        	}
        }
        return getMin(X) + getMin(Y);
    }
	
	// This is a brilliant solution!!!
	private int getMin(int[] coord) {
		int total = 0;
		int i = 0, j = coord.length - 1;
		while (i < j) {
			int k = Math.min(coord[i], coord[j]);
			total += k * (j - i);
			if ((coord[i] -= k) == 0) ++i;
			if ((coord[j] -= k) == 0) --j;
		}
		return total;
	}
	
	public static void main(String[] args) {
		BestMeetingPoint bmp = new BestMeetingPoint();
		int[][] grid = {
				{1,0,0,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		System.out.println(bmp.minTotalDistance(grid));
	}
}
