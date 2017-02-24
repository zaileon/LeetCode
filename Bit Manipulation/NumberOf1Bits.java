
public class NumberOf1Bits {
	
	// Integer.bitCount method, popcount
	// more explanaton: http://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
	public int hammingWeight(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0F0F0F0F;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3F;
    }

	public static void main(String[] args) {
		NumberOf1Bits n1b = new NumberOf1Bits();
		int i = 256;
		System.out.println(n1b.hammingWeight(i));
	}

}
