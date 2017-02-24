import java.util.HashMap;
import java.util.Map;

public class Logger {

	Map<String, Integer> ok = new HashMap<>();
	
	public Logger() {
	}
	
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (timestamp < ok.getOrDefault(message, 0))
			return false;
		ok.put(message, timestamp + 10);
		return true;
	}
	
	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo")); // true;
		System.out.println(logger.shouldPrintMessage(2, "bar")); // true;
		System.out.println(logger.shouldPrintMessage(3, "foo")); // false;
		System.out.println(logger.shouldPrintMessage(8, "foo")); // false;
		System.out.println(logger.shouldPrintMessage(10, "foo")); // false;
		System.out.println(logger.shouldPrintMessage(11, "foo")); // true;
	}
}
