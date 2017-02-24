
public class ValidIPAddress {

	public String validIPAddress(String IP) {
		if (IP == null || IP.length() < 7) return "Neither";
		if (IP.indexOf(".") > 0) {
			if (IP.length() > 15 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return "Neither";
			String[] segs = IP.split("\\.");
			if (segs.length != 4) return "Neither";
			for (String seg : segs) {
				if (seg.length() == 0 || (seg.length() > 1 && seg.charAt(0) == '0')) return "Neither";
				int n = 0;
				for (int j = 0; j < seg.length(); j++) {
					char c = seg.charAt(j);
					if (c < '0' || c > '9') return "Neither";
					n = n * 10 + c - '0';
				}
				if (n > 255) return "Neither";
			}
			return "IPv4";
		} else if (IP.indexOf(":") > 0) {
			if (IP.length() > 135 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return "Neither";
			String[] segs = IP.split(":");
			if (segs.length != 8) return "Neither";
			for (String seg : segs) {
				if (seg.length() > 4 || seg.length() == 0) return "Neither";
				int n = 0;
				for (int j = 0; j < seg.length(); j++) {
					char c = seg.charAt(j);
					if (c >= '0' && c <= '9') {
						n = n * 16 + c - '0';
					} else if (c >= 'A' && c <= 'F') {
						n = n * 16 + 10 + c - 'A';
					} else if (c >= 'a' && c <= 'f') {
						n = n * 16 + 10 + c - 'a';
					} else return "Neither";
				}
			}
			return "IPv6";
		}
		return "Neither";
	}
	
	public static void main(String[] args) {
		ValidIPAddress vipa = new ValidIPAddress();
		System.out.println(vipa.validIPAddress("172.16.254.1")); // IPv4
		System.out.println(vipa.validIPAddress("172.16.254.01")); // Neither
		System.out.println(vipa.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
		System.out.println(vipa.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334")); // Neither
		System.out.println(vipa.validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334")); // Neither
		System.out.println(vipa.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334")); // IPv6
		System.out.println(vipa.validIPAddress("2001:0db8:85a3::8A2E:0370:7334")); // Neither
		System.out.println(vipa.validIPAddress("256.256.256.256")); // Neither
		System.out.println(vipa.validIPAddress("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")); // Neither
	}

}