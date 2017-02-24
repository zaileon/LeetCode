
public class MovingAverage {
	
	int total, update;
	int[] nums;
	double sum;

	public MovingAverage(int size) {
		this.nums = new int[size];
		total = 0;
		update = 0;
		sum = 0.0;
	}
	
	public double next(int val) {
		if (total < nums.length) total++;
		sum -= nums[update];
		sum += val;
		nums[update] = val;
		update = (update + 1) % nums.length;
		return ((double) sum) / total;
	}
	
	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1)); // 1
		System.out.println(ma.next(10)); // 5.5
		System.out.println(ma.next(3)); // 4.67
		System.out.println(ma.next(5)); // 6.0
	}
}
