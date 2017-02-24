import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCodec {

	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length()).append("/").append(str);
		}
		return sb.toString();
	}
	
	public List<String> decode(String s) {
		List<String> result = new ArrayList<>();
		for (int i = 0, n = 0; i < s.length(); i++) {
			if (s.charAt(i) == '/') {
				result.add(s.substring(i + 1, i + 1 + n));
				i += n;
				n = 0;
			} else {
				n = n * 10 + s.charAt(i) - '0';
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		StringCodec codec = new StringCodec();
		List<String> strs = Arrays.asList("V", "Grz/");
		String s = codec.encode(strs);
		System.out.println(s);
		List<String> ss = codec.decode(s);
		for (String sss : ss) {
			System.out.println(sss);
		}
	}
}
