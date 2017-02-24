
public class SelfCrossing {
	
	/*           i-2
    case 1 : i-1┌─┐
                └─┼─>i     current line cross the line 3 steps ahead
                 i-3
                 
                    i-2
    case 2 : i-1 ┌────┐    current line overlap with the line 4 steps ahead
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

	 */	
	public boolean isSelfCrossing(int[] x) {
		for (int i = 3; i < x.length; i++) {
			if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) return true;
			if (i >= 4 && x[i - 1] == x[i - 3] && x[i] >= x[i - 2] - x[i - 4]) return true;
			if (i >= 5 && x[i - 1] <= x[i - 3] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4]) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SelfCrossing sc = new SelfCrossing();
		System.out.println(sc.isSelfCrossing(new int[] {3,3,3,2,1,1})); // false
		System.out.println(sc.isSelfCrossing(new int[] {1,1,2,2,1,1})); // true
		System.out.println(sc.isSelfCrossing(new int[] {3,3,4,2,2})); // false
		System.out.println(sc.isSelfCrossing(new int[] {1,1,2,1,1})); // true
		System.out.println(sc.isSelfCrossing(new int[] {1,2,3,4})); // false
		System.out.println(sc.isSelfCrossing(new int[] {2,1,1,2})); // true
		System.out.println(sc.isSelfCrossing(new int[] {1,1,1,1})); // true
	}
}
