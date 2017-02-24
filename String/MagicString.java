
public class MagicString {

	public int magicalString(int n) {
		if (n <= 1) return n;
		int[] nums = new int[n + 1];
		nums[0] = 1; nums[1] = 2;
		int readIdx = 1, writeIdx = 1;
		int count = 1, num = 2;
		
		while (writeIdx < n) {
			if (nums[readIdx] == 1) {
				nums[writeIdx++] = num;
				if (num == 1) { num = 2; count++; }
				else num = 1;
			} else {
				nums[writeIdx++] = nums[writeIdx++] = num;
				if (num == 1) { num = 2; count += 2; } 
				else num = 1;
			}
			readIdx++;
		}
		if (nums[n] == 1) count--;
		return count;
	}
	
	public static void main(String[] args) {
		MagicString ms = new MagicString();
		System.out.println(ms.magicalString(1)); // 1
		System.out.println(ms.magicalString(2)); // 1
		System.out.println(ms.magicalString(3)); // 1
		System.out.println(ms.magicalString(4)); // 2
		System.out.println(ms.magicalString(5)); // 3
		System.out.println(ms.magicalString(6)); // 3
	}
}
