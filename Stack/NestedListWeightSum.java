import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {
	
	
	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}
	
	private int helper(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += helper(ni.getList(), depth + 1);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		NestedListWeightSum nlws = new NestedListWeightSum();
		List<NestedInteger> nestedList = new ArrayList<>();
		
		NestedInteger l = new NestedInteger();
		l.list.add(new NestedInteger(1));
		l.list.add(new NestedInteger(1));
		nestedList.add(l);
		
		nestedList.add(new NestedInteger(2));
		
		NestedInteger r = new NestedInteger();
		r.list.add(new NestedInteger(1));
		r.list.add(new NestedInteger(1));
		nestedList.add(r);
		
		System.out.println(nlws.depthSum(nestedList));
	}
}
