import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	
	Iterator<NestedInteger> iter;
	Stack<Iterator<NestedInteger>> stack;
	Integer cache = null;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		iter = nestedList.iterator();
		stack = new Stack<>();
	}

	@Override
	public boolean hasNext() {
		if (cache == null) {
			if (iter.hasNext()) {
				NestedInteger ni = iter.next();
				if (ni.isInteger()) { cache = ni.getInteger(); return true; }
				stack.push(iter);
				iter = ni.getList().iterator();
				return hasNext();
			} else if (!stack.isEmpty()) {
				iter = stack.pop();
				return hasNext();
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		Integer result = cache;
		cache = null;
		return result;
	}

	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<>();
//		nestedList.add(new NestedInteger());
//		nestedList.get(0).add(new NestedInteger(1));
//		nestedList.get(0).add(new NestedInteger(1));
//		nestedList.add(new NestedInteger(2));
//		nestedList.add(new NestedInteger());
//		nestedList.get(2).add(new NestedInteger(1));
//		nestedList.get(2).add(new NestedInteger(1));
		
		nestedList.add(new NestedInteger(1));
		NestedInteger n = new NestedInteger();
		n.getList().add(new NestedInteger(4));
		NestedInteger nn = new NestedInteger();
		nn.getList().add(new NestedInteger(6));
		n.getList().add(nn);
		nestedList.add(n);
		
		NestedIterator ni = new NestedIterator(nestedList);
		while (ni.hasNext()) {
			System.out.println(ni.next());
		}
	}
}
