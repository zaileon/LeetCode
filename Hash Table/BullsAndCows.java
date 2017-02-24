public class BullsAndCows {

	public String getHint(String secret, String guess) {
		int bull = 0, cow = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) bull++;
			else {
				if (numbers[secret.charAt(i)-'0']++ < 0) cow++; // < 0 means we requested one i in previous guess, and now secret provide one 
				if (numbers[guess.charAt(i)-'0']-- > 0) cow++; // >0 means we have seen one i in previous secret, now we consume it in guess
			}
		}
		return bull + "A" + cow + "B";
	}
	
	public static void main(String[] args) {
		BullsAndCows bc = new BullsAndCows();
		System.out.println(bc.getHint("011", "110")); // "1A2B"
		System.out.println(bc.getHint("1121", "0111")); // "2A1B"
		System.out.println(bc.getHint("1807", "7810")); // "1A3B"
		System.out.println(bc.getHint("1123", "0111")); // "1A1B"
	}
}
