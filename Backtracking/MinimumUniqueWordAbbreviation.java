import java.util.ArrayList;
import java.util.List;

public class MinimumUniqueWordAbbreviation {
	
	int n, bn, cand, minab, minlen;
	List<Integer> dict;
	
//	private int abbrLen(int mask) {
//		int count = 0;
//		for (int b = 1; b < bn;) {
//			if ((mask & b) == 0)
//				for (; b < bn && (mask & b) == 0; b <<= 1);
//			else b <<= 1;
//			count++;
//		}
//		return count;
//	}
	
	private int abbrLen(int mask) {
		int count = n;
		for (int b = 3; b < bn; b <<= 1) {
			if ((mask & b) == 0) count--;
		}
		return count;
	}
	
	private void dfs(int bit, int mask, int len) {
		if (len >= minlen) return;
		boolean match = true;
		for (int w : dict) {
			if ((mask & w) == 0) {
				match = false;
				break;
			}
		}
		if (match) {
			minlen = len;
			minab = mask;
		} else {
			for (int b = bit; b < bn; b <<= 1) {
				if ((cand & b) != 0) {
					// current mask 000011(len=3)
					// next mask will be: 000111(len=4), 001011(len=5), 010011(len=5), 100011(len=4)
					// first and last has len+1, and everything in between has len+2
					if (b == bit || (b << 1) == bn) 
						dfs(b << 1, mask + b, len + 1);
					else 
						dfs(b << 1, mask + b, len + 2);
				}
			}
		}
	}
	
	public String minAbbreviation(String target, String[] dictionary) {
		dict = new ArrayList<>();
		n = target.length();
		bn = 1 << n;
		cand = 0;
		minlen = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();
		// for each word in dict, get a bit sequence that has 1 on the positions that are different
		// so for target: "abcde", ["abxdx","xbcdx"]=>["00101, 10001], the solution is converted to find the bit mask
		// that has shortest abbreviation, so that for all bit sequences in dict, mask & bit_sequence > 0
		// an optimization here: check only the set bits in any bit sequences (cand)
		for (String w : dictionary) {
			int word = 0;
			if (w.length() != n) continue;
			for (int i = n - 1, bit = 1; i >= 0; i--, bit <<= 1) {
				if (target.charAt(i) != w.charAt(i)) word += bit;
			}
			dict.add(word);
			cand |= word;
		}
		dfs(1, 0, 1);
		
		for(int i = 0; i < n;){
            if((minab & (1 << (n - i))) != 0){
                sb.append(target.charAt(i++));
            }else{
                int j = i;
                while(i < n && (minab & (1 << i)) == 0)i++;
                sb.append(i - j);
            }
        }
		return sb.toString();
	}

	public static void main(String[] args) {
		MinimumUniqueWordAbbreviation muwa = new MinimumUniqueWordAbbreviation();
		String target = "apple";
		String[] dictionary = new String[] {"blade"}; // "a4"
//		String[] dictionary = new String[] { "plain", "amber", "blade"}; // "1p3", "ap3", "a3e", "2p2", "3le", "3l1"
		System.out.println(muwa.minAbbreviation(target, dictionary));
	}

}
