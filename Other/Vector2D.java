import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	
	Iterator<List<Integer>> row;
	Iterator<Integer> col;
	
	public Vector2D(List<List<Integer>> vec2d) {
		row = vec2d.iterator();
	}
	
	@Override
	public Integer next() {
		return col.next();
	}
	
	@Override
	public boolean hasNext() {
		while ((col == null || !col.hasNext()) && row.hasNext()) {
			col = row.next().iterator();
		}
		return col != null && col.hasNext();
	}
	

	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<>();
		vec2d.add(Arrays.asList());
		vec2d.add(Arrays.asList(1,2));
		vec2d.add(Arrays.asList());
		vec2d.add(Arrays.asList(3));
		vec2d.add(Arrays.asList(4,5,6));
		vec2d.add(Arrays.asList());
		Vector2D v = new Vector2D(vec2d);
		while (v.hasNext()) {
			System.out.println(v.next());
		}
	}

}
