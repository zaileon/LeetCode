public class HitCounter {

	int[] times, hits;
	
	public HitCounter() {
		times = new int[300];
		hits = new int[300];
	}
	
	public void hit(int timestamp) {
		int index = timestamp % 300;
		if (times[index] != timestamp) {
			times[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}
	
	public int getHits(int timestamp) {
		int total = 0;
		for (int i = 0; i < 300; i++) {
			if (times[i] > timestamp - 300) total += hits[i];
		}
		return total;
	}
	
	public static void main(String[] args) {
		HitCounter hc = new HitCounter();
		hc.hit(1);
		hc.hit(2);
		hc.hit(3);
		System.out.println(hc.getHits(4)); // 3
		hc.hit(300); // 
		System.out.println(hc.getHits(300)); // 4
		System.out.println(hc.getHits(301)); // 3
	}
}
