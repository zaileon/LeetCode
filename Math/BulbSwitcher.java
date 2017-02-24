
public class BulbSwitcher {
	public int bulbSwitch(int n) {
//        return (int)Math.pow(n, 0.5);
		return (int)Math.sqrt(n);
    }
	
	public static void main(String[] args) {
		BulbSwitcher bs = new BulbSwitcher();
		System.out.println(bs.bulbSwitch(3));
	}
}
