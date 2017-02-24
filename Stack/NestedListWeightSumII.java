import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NestedListWeightSumII {
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		Deque<NestedInteger> queue = new ArrayDeque<>();
		for (NestedInteger ni : nestedList) queue.offer(ni);
		
		int prefix = 0, total = 0;
		while (!queue.isEmpty()) {
			int sz = queue.size();
			int levelSum = 0;
			for (int i = 0; i < sz; i++) {
				NestedInteger ni = queue.poll();
				if (ni.isInteger()) {
					levelSum += ni.getInteger();
				} else {
					for (NestedInteger nested : ni.getList()) {
						queue.offer(nested);
					}
				}
			}
			prefix += levelSum; // n1 is added twice
			total += prefix;
		}
		return total;
	}
	
	public static void main(String[] args) {
		NestedListWeightSumII nlws = new NestedListWeightSumII();
		
		NestedInteger n1 = new NestedInteger(1);
		NestedInteger n2 = new NestedInteger();
		n2.list.add(new NestedInteger(4));
		List<NestedInteger> nestedList = new ArrayList<>();
		nestedList.add(n1);
		nestedList.add(n2);
		
		System.out.println(nlws.depthSumInverse(nestedList));
	}
	
}
