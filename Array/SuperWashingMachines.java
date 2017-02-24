
public class SuperWashingMachines {

	// say f(i) is the number of moves for machine i to achieve the goal
	// minimum steps are Max(f(i)) (proof?)
	// for each machine, calculate (desired dresses - actual dresses) for left side and right side
	// if both L and R is > 0 (L<-i R, or L i->R, but not simultaneously), the moves is L+R
	// otherwise, it's either L->i<-R, or L->i->R, or L<-i<-R, the moves is max(L, R) 
	public int findMinMoves(int[] machines) {
		int n = machines.length;
		int[] sums = new int[n + 1];
		for (int i = 0; i < n; i++) 
			sums[i + 1] = sums[i] + machines[i];
		
		if (sums[n] % n != 0) return -1;
		int avg = sums[n] / n;
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
																//  			1	|	0	|	5
			int l = i * avg - sums[i];							// desired:   0   4	| 2	  2	| 4   0		
			int r = (n - 1 - i) * avg - (sums[n] - sums[i + 1]);// actual:    0   5 | 1	  5	| 1   0
			if (l > 0 && r > 0) max = Math.max(max, l + r);		//      L:    0     | 1     | 3
																//      R:       -1 |    -3 |     0
			else max = Math.max(max, Math.max(Math.abs(l), Math.abs(r)));
		}
		return max;
	}
	
	public static void main(String[] args) {
		SuperWashingMachines swm = new SuperWashingMachines();
		System.out.println(swm.findMinMoves(new int[] {1,0,5}));
	}
}
