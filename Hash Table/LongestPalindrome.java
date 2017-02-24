
public class LongestPalindrome {
	
	public int longestPalindrome(String s) {
		int[] count = new int[256];
		for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
		boolean odd = false;
		int sum = 0;
		for (int i = 0; i < 256; i++) {
			if ((count[i] & 1) == 1) {
				odd = true;
				sum += count[i] & (count[i] - 1); // for odd-count letters, we can use even times of each
			} else {
				sum += count[i];
			}
		}
		return sum + (odd ? 1 : 0);
	}

	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
//		System.out.println(lp.longestPalindrome("abbbccccdd"));
		System.out.println(lp.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
