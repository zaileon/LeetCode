import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	public List<String> restoreIPAddresses(String s) {
		List<String> ips = new ArrayList<>();
		StringBuffer sb = new StringBuffer(s.length());
		backtrack(s, 0, 0, sb, ips);
		return ips;
	}

	private void backtrack(String s, int start, int count, StringBuffer sb, List<String> ips) {
		if (count == 4) {
			if (start == s.length()) ips.add(sb.toString());
			return;
		}
		for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
			if (s.charAt(start) != '0' || i == start + 1) {
				int seg = Integer.parseInt(s.substring(start, i));
				if (seg >= 0 && seg <= 255) {
					sb.append(s.substring(start, i));
					if (count < 3) sb.append('.');
					backtrack(s, i, count + 1, sb, ips);
					sb.setLength(start + count);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddress ripa = new RestoreIPAddress();
		String s = "010010";
//		String s = "25525511135";
		for (String ip : ripa.restoreIPAddresses(s)) {
			System.out.println(ip);
		}
	}

}
