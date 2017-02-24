
public class IsPalindrome {
	
	public boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		IsPalindrome ip = new IsPalindrome();
		System.out.println(ip.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(ip.isPalindrome("race a car"));
		System.out.println(ip.isPalindrome("0P"));
	}

}
