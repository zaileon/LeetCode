
public class SuperPow {

	// Fermat's Little Theorem
	// 1337 has two factors: 7 and 191, phi(7)=6, phi(191)=190, thus, phi(1337)=phi(7)*phi(191)=1140
	/*
	 * to calc a^b%n
			if b <= φ(n), use quick power
			if b > φ(n), a^b ≡ a^b % φ(n) + φ(n) %n
		for any a, if a % 1337 != 0, a^φ(1337) % 1337 = 1, if a % 1337 == 0, a^φ(1337) % 1337 = 0.
	 */
	public int superPow(int a, int[] b) {
		if (a % 1337 == 0) return 0;
		int p = 0;
		for (int i : b) p = (p * 10 + i) % 1140;
		if (p == 0) p += 1140;
		return power(a, p, 1337);
	}
	
	private int power(int a, int n, int mod) {
		a %= mod;
		int ret = 1;
		while (n != 0) {
			if ((n & 1) != 0) ret = ret * a % mod;
			a = a * a % mod;
			n >>= 1;
		}
		return ret;
	}
}
