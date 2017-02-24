
public class SegmentsInString {
	
	
	// elegant code! "+" is required, otherwise will match only one space
	public int countSegments(String s) {
		return ("x " + s).split(" +").length - 1;
	}
	
//	public int countSegments(String s) {
//		int count = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
//				count++;
//			}
//		}
//		return count;
//	}
	
//	public int countSegments(String s) {
//		int count = 0;
//		int i = 0, j = -1;
//		for (; i < s.length(); i++) {
//			if (s.charAt(i) == ' ') {
//				if (i > j + 1) count++;
//				j = i;
//			}
//		}
//		if (i > j + 1) count++;
//		return count;
//	}
	
	public static void main(String[] args) {
		SegmentsInString sis = new SegmentsInString();
		System.out.println(sis.countSegments(", , , ,        a, eaefa")); // 6
		System.out.println(sis.countSegments("")); // 0
		System.out.println(sis.countSegments("Hello, my name is John")); // 5
	}
}
