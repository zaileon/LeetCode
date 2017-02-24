
public class ReconstructDigits {
	
	public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
        	count[c - 'a']++;
        }
        int[] m = new int[10];
        m[0] = count['z' - 'a'];
        m[2] = count['w' - 'a'];
        m[4] = count['u' - 'a'];
        m[6] = count['x' - 'a'];
        m[8] = count['g' - 'a'];
        m[1] = count['o' - 'a'] - m[0] - m[2] - m[4];
        m[3] = count['r' - 'a'] - m[0] - m[4];
        m[5] = count['f' - 'a'] - m[4];
        m[7] = count['s' - 'a'] - m[6];
        m[9] = count['i' - 'a'] - m[5] - m[6] - m[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
        	while (m[i] > 0) {
        		sb.append((char)('0' + i));
        		m[i]--;
        	}
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		ReconstructDigits rd = new ReconstructDigits();
//		System.out.println(rd.originalDigits("owoztneoer")); //012
		System.out.println(rd.originalDigits("fviefuro")); //45
	}
}
