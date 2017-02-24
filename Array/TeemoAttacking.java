
public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0 || duration == 0) return 0;
		int reach = timeSeries[0] + duration, total = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			total += timeSeries[i] < reach ? timeSeries[i] - timeSeries[i - 1] : duration;
			reach = timeSeries[i] + duration;
		}
		return total + duration;
	}
	
	public static void main(String[] args) {
		TeemoAttacking ta = new TeemoAttacking();
		int[] timeSeries = {1,2}; int duration = 2; // 3
//		int[] timeSeries = {1,4}; int duration = 2;  // 4
		System.out.println(ta.findPoisonedDuration(timeSeries, duration));
	}
}
