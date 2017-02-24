import java.util.HashMap;
import java.util.Map;

public class CanIWin {

	// state can also be represented by a boolean[maxChoosableInteger], with state[i]=true means the number has been used
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int totalSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (totalSum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        Map<Integer, Boolean> map = new HashMap<>();
        return helper(0, maxChoosableInteger, map, desiredTotal);
    }
	
	// cache the subproblem. top-down DP solution
	private boolean helper(int state, int maxChoosableInteger, Map<Integer, Boolean> map, int desiredTotal) {
		if (desiredTotal <= 0) return false; // the current player is dealt with a negative, means the opponent has already won the game
		if (map.containsKey(state)) return map.get(state);
		for (int i = maxChoosableInteger; i >= 1; i--) {
			// find any unset bit, flip it, and see if it leads a win
			// if yes, cache the state/result and return; if not, continue with next number
			if (((state >> i) & 1) == 0) {
				state |= 1 << i;
				// pick number i. if the opponent can not win with desiredTotal - i, the current player wins
				if (!helper(state, maxChoosableInteger, map, desiredTotal - i)) {
					state &= ~(1 << i); // need to restore the state first
					map.put(state, true);
					return true;
				}
				state &= ~(1 << i);
			}
		}
		map.put(state, false);
		return false;
	}
	
	public static void main(String[] args) {
		CanIWin ciw = new CanIWin();
		int maxChoosableInteger = 10, desiredTotal = 11;
		System.out.println(ciw.canIWin(maxChoosableInteger, desiredTotal));
	}
}
