
public class IntegerReplacement {

	// unsigned shift. it's necessary as we want to move the sign right to the right
	// In the case of Integer.MAX_VALUE, it becomes Integer.MIN_VALUE after the first loop
	// We want to move the 1 at 31bit to make n positive again
	public int integerReplacement(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1; 
			} else if (n == 3 || ((n >> 1) & 1) == 0) {
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		IntegerReplacement ir = new IntegerReplacement();
		System.out.println(ir.integerReplacement(Integer.MAX_VALUE));
		System.out.println(ir.integerReplacement(8));
		System.out.println(ir.integerReplacement(7));
	}
}
