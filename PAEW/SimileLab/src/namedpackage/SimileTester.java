package namedpackage;
public class SimileTester {
	private String[] var;
	
	public SimileTester (String sentence) {
		
		var = sentence.split(" ");
		for (String s : var) {
			System.out.println(s);
		}
		
	}
	
	public static void main (String[] args) {
		SimileTester st1 = new SimileTester("This is a trial sentence.");
		//st1.printBefore();
	}
}
