import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)  return "";
        
		StringBuilder sb = new StringBuilder();
    	Arrays.sort(strs);
    	
    	char[] first = strs[0].toCharArray();
    	char[] last  = strs[strs.length - 1].toCharArray();
    	for (int i = 0; i < first.length; i++) {
    		if (first[i] == last[i]) sb.append(first[i]);
    		else return sb.toString();
    	}
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = {"abc", "abcd"};
		System.out.println(lcp.longestCommonPrefix(strs));
	}
}
