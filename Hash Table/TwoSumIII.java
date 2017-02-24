import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSumIII {
	Map<Integer, Integer> count = new LinkedHashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    count.put(number, count.containsKey(number) ? count.get(number) + 1 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int key : count.keySet()) {
			int target = value - key;
			if ((target == key && count.get(key) > 1) ||
				(target != key &&count.containsKey(target)))
				return true;
		}
		return false;
	}
}
