import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
	Integer val = null;
	List<NestedInteger> list = new ArrayList<>();
	public NestedInteger() {};
	public NestedInteger(int val) { this.val = val; }
	public boolean isInteger() {
		return this.val != null;
	}
	public Integer getInteger() {
		return val;
	}
	public void setInteger(int value) { this.val = value; }
	public void add(NestedInteger ni) {
		this.list.add(ni);
	}
	public List<NestedInteger> getList() { 
		return list; 
	}
}
