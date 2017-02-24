import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OptimalAccountBalancing {
	
	public int minTransfers(int[][] transactions) {
		Map<Integer, Map<Integer, Integer>> balances = new HashMap<>();
		for (int[] tx : transactions) {
			balances.putIfAbsent(tx[0], new HashMap<Integer, Integer>());
			balances.get(tx[0]).putIfAbsent(tx[1], 0);
			int b = balances.get(tx[0]).get(tx[1]) + tx[2];
			balances.get(tx[0]).put(tx[1], b);
		}
		for (int p : balances.keySet()) {
			optimize(balances, p);
		}
		int count = 0;
		for (Map<Integer, Integer> balance : balances.values()) {
			count += balance.size();
		}
		return count;
	}
	
	private void optimize(Map<Integer, Map<Integer, Integer>> balances, int p) {
		Iterator<Entry<Integer, Integer>> iterator = balances.get(p).entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> b = iterator.next();
			int out = b.getValue(), in = balances.get(b.getKey()).get(p);
			if (out > in) {
				b.setValue(out - in);
				balances.get(b.getKey()).remove(p);
			} else if (out < in) {
				balances.get(b.getKey()).put(p, in - out);
				balances.remove(b);
			} else {
				balances.get(b.getKey()).remove(p);
				balances.get(p).remove(b.getKey());
			}
		}
	}

	public static void main(String[] args) {
		OptimalAccountBalancing oab = new OptimalAccountBalancing();
		int[][] transactions = {{0,1,10},{1,0,1},{1,2,5},{2,0,5}};
		System.out.println(oab.minTransfers(transactions));
	}

}
