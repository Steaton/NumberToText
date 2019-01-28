package domain;

/**
 * Represents a digit grouping as part of a larger number (normally groups are 
 * separated by a comma for every three digits e.g. 1,000,000 contains three
 * digit groups a 1 a 000 and another 000).
 * @author Stephen Eaton
 */
public interface ThreeDigitGroup {

	/**
	 * Prints out the value of the three digit group in words.
	 * @return the string representation in words
	 */
	public String printWords();
	
	/**
	 * Get the value of the group.
	 * @return the value of the group as an int
	 */
	public int getValue();
}
