import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
	
	// The first element can not be bigger than n-k+1
//	public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> result = new ArrayList<>();
//        combineUtil(1, n - k + 1, k, result, new ArrayList<Integer>());
//	    return result;
//    }
//    
//    private void combineUtil(int from, int to, int kLeft, List<List<Integer>> result, List<Integer> list) {
//        if (kLeft == 0) {
//            result.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for (int i = from; i <= to; i++) {
//            list.add(i);
//            // after we select i, the next element should be within [i + 1, to + 1] 
//            combineUtil(i + 1, to + 1, kLeft - 1, result, list);
//            list.remove(list.size() - 1);
//        }
//    }
    
    // Another solution based on C(n, k) = C(n-1, k-1) + C(n-1, k) // first: n is selected, second: n is not selected
    public List<List<Integer>> combine(int n, int k) {
        if (k > n || k == 0) return new ArrayList<>();
        List<List<Integer>> result = combine(n - 1, k - 1);
        if (result.size() == 0) 
        	result.add(new ArrayList<>(Arrays.asList(n)));
        else 
        	result.forEach(list -> list.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }
    
    public static void main(String[] args) {
		Combinations c = new Combinations();
		int n = 4, k = 4;
		for (List<Integer> list : c.combine(n, k)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
