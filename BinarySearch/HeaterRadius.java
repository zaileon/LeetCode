import java.util.Arrays;

public class HeaterRadius {
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int radius = 0, len = heaters.length;
		for (int house : houses) {
			int idx = Arrays.binarySearch(heaters, house);
			if (idx < 0) {
				idx = ~idx;
				if (idx == 0) radius = Math.max(radius, heaters[0] - house);
				else if (idx == len) radius = Math.max(radius, house - heaters[len - 1]);
				else radius = Math.max(radius, Math.min(house - heaters[idx - 1], heaters[idx] - house));
			}
		}
		return radius;
	}
	
	public static void main(String[] args) {
		HeaterRadius hr = new HeaterRadius();
		int[] houses = {6,1,2,3,4}, heaters = {1,4};
		System.out.println(hr.findRadius(houses, heaters));
	}
}
