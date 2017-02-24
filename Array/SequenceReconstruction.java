import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceReconstruction {
	
	// 1. any seq/subsequence in seqs should be a subsequence in org, i.e. the length of it can be the same as or shorter than in org
	// 2. for any two consecutive x and y in org, they should either appear consecutively in some seq or not appear at all.
	//    First if they appear in seq together, based on observation 1, their distance can be only 1
	//    Second if only one appear in one of seqs, we can switch x and y and get a different sequence.({1,2,3} and {{1,2},{1,3}}, another seq is {1,3,2})
	// Use idx to record the indices of org, for every element in seq, check the two criteria
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		int n = org.length;
		int[] idx = new int[n + 1];
		boolean[] visited = new boolean[n + 1]; // purely to handle the case of {1},{{},{}}. Should have some better ways
		boolean[] pair = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			idx[org[i]] = i;
		}
		for (List<Integer> seq : seqs) {
			for (int i = 0; i < seq.size(); i++) {
				if (seq.get(i) > n || seq.get(i) < 0) return false;
				visited[seq.get(i)] = true;
				if (i > 0) {
					int p0 = idx[seq.get(i - 1)];
					int p1 = idx[seq.get(i)];
					if (p0 >= p1) return false; // if the element immediately before it appears later in org, return false
					if (p0 + 1 == p1) pair[p1] = true; // if the pair(prev, curr) also appear in org, label curr's idx to true
				}
			}
		}
		for (int i = 1; i <= n; i++)
			if (!visited[i] || (i < n && !pair[i])) return false;
		return true;
	}

	public static void main(String[] args) {
		SequenceReconstruction sr = new SequenceReconstruction();
		List<List<Integer>> seqs = new ArrayList<>();
//		seqs.add(Arrays.asList(1,3)); 
//		seqs.add(Arrays.asList(1,2)); 
//		seqs.add(Arrays.asList(2,3)); 
		seqs.add(Arrays.asList()); //seqs.add(Arrays.asList()); 
		int[] org = {1};
		System.out.println(sr.sequenceReconstruction(org, seqs));
	}

}
