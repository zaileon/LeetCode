
public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] segs = path.split("/");
		int len = 1;
		for (int i = 1; i < segs.length; i++) {
			if (segs[i].length() == 0 || ".".equals(segs[i])) continue;
			if ("..".equals(segs[i])) {
				if (len > 1) len--;
			} else { 
				segs[len++] = segs[i];
			}
		}
		StringBuilder sb = new StringBuilder("/");
		for (int i = 1; i < len; i++) {
			sb.append(segs[i]);
			if (i < len - 1) sb.append("/");
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));  // /e/f/g
		System.out.println(sp.simplifyPath("/home/"));  // /home
		System.out.println(sp.simplifyPath("/a/./b/../../c/")); // /c
		System.out.println(sp.simplifyPath("/../")); // /
		System.out.println(sp.simplifyPath("/home//foo/")); // /home/foo
	}

}
