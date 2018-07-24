package namedpackage;
import java.util.ArrayList;

public class SimileTester {
	private ArrayList<String> before;
	private ArrayList<String> after;
	
	public SimileTester (String sentence) {
		String lookTo = "like";
		if (!sentence.contains("like"))
			lookTo = "as";
		
		//System.out.println(lookTo);
		
		int lastSpace = 0;
		
		before = new ArrayList<String>();
		
		for (int b = 0; b < sentence.indexOf(lookTo); b++) {
			if (sentence.substring(b, b + 1).equals(lookTo)) {
				before.add(sentence.substring(lastSpace, b));
				lastSpace = b;
			}
		}
		after = new ArrayList<String>();
	}
	
	public void printBeforeSize () {
		System.out.println(before.size());
	}
	
	public void printBefore () {
		for (String w : before) {
			System.out.println(w);
		}
	}
	
	public static void main (String[] args) {
		SimileTester st1 = new SimileTester("You throw like a girl!");
		//st1.printBefore();
	}
}
