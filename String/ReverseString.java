
public class ReverseString {
	public String reverseString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char t = c[j];
            c[j] = c[i];
            c[i] = t;
        }
        return new String(c);
    }
}
