import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map<Object, Integer> index = new HashMap<>();
	    for (Integer i=0; i<words.length; ++i) 
	    	// use int return false when putting d=129 and t=129, both return Integer of 128, but not the same one (exceed Java Integer constant pool)
	    	// Integer i1 = 127, i2 = 127; i1==i2;//true, call Integer.valueOf(127)
	    	// Integer i1 = 128, i2 = 128; i1==i2;//false
	    	// Integer i1 = new Integer(127), i2 = new Integer(127); i1==i2; //false
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
		System.out.println(wp.wordPattern("ab", "dog dog"));
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
		System.out.println(wp.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
	}

}
