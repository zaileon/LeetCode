import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
	public boolean canCross(int[] stones) {
		// max reach is 0, 1, 3, 6,...
		if (stones == null || stones.length == 0 || stones[1] != 1 || 
				stones[stones.length - 1] > stones.length * (stones.length - 1) / 2) return false;
		HashMap<Integer, HashSet<Integer>> jumps = new HashMap<>();
		for (int i = 0; i < stones.length; i++) jumps.put(stones[i], new HashSet<>());
		jumps.get(0).add(1);
		for (int i = 0; i < stones.length - 1; i++) {
			for (int jump : jumps.get(stones[i])) {
				int reach = stones[i] + jump;
				if (reach == stones[stones.length - 1]) return true;
				if (jumps.containsKey(reach)) {
					jumps.get(reach).add(jump + 1);
					jumps.get(reach).add(jump);
					if (jump > 1) jumps.get(reach).add(jump - 1);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FrogJump fj = new FrogJump();
		int[] stones = {0,1,3,5,6,8,12,17};
		System.out.println(fj.canCross(stones));
	}
}
