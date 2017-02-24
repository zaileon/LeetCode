public class LongestAbsoluteFilePath {

	public int lengthLongestPath(String input) {
		String[] segs = input.split("\n");
		int max = 0;
		int[] stack = new int[segs.length + 1];
		for (String seg : segs) {
			int level = seg.lastIndexOf('\t') + 1;
			int len = stack[level] + seg.length() - level + 1;
			stack[level + 1] = len;
			if (seg.indexOf('.') >= 0) max = Math.max(max, len - 1); 
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestAbsoluteFilePath lafp = new LongestAbsoluteFilePath();
//		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"; // 32
		String input = "dir\n    file.txt"; // 12, the whole "    file.txt" replaces "dir/"
		System.out.println(lafp.lengthLongestPath(input));
	}

}
