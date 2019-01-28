package domain;

/**
 * Simple mock object used for unit testing.
 * @author Stephen Eaton
 */
public class MockThreeDigitGroup implements ThreeDigitGroup {

	private int value;
	
	private String words;
	
	public String printWords() {
		return words;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public void setWords(String words) {
		this.words = words;
	}
}