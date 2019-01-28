package domain;

import java.util.ArrayList;
import java.util.List;

import constants.NumberWordConstants;

/**
 * Implementation of WordedNumber.
 * @author Stephen Eaton
 */
public class WordedNumberImpl implements WordedNumber {

	/** The representation of the number, a stack of 'three digit groups'. */
	private List<ThreeDigitGroup> numberGroups = new ArrayList<ThreeDigitGroup>();
	
	/** Simpler representation of the number */
	private int number;
	
	/**
	 * Constructor that takes the number to set as a string.
	 * @param numberString the number to be represented as words
	 */
	public WordedNumberImpl(String numberString) {
		
        // Initialisation
		number = Integer.parseInt(numberString);
		int length = numberString.length();
		
		// Pre-Conditions		
		assert number >= 0;
		assert length > 0;
		
		// Determine number of groups
		int numGroups = length / 3;
		if (length % 3 > 0) {
			numGroups++;
		}
		
		// Loop through groups of 3 starting at the end of the string
		for (int x = length; x > 0; x = x - 3) {
			
			int startIndex = x - 3;
			if (startIndex < 0) {
				startIndex = 0;
			}
			
			String group = numberString.substring(startIndex, x);
			
			// Add each group to the list
			numberGroups.add(new ThreeDigitGroupImpl(group));			
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String printWords() {
		
		if (number == 0) {
			return NumberWordConstants.NUMBERS[0];
		}
		
		String result = "";		
		int length = numberGroups.size();
		for (int x = length; x > 0; x--) {
			
			ThreeDigitGroup group = numberGroups.get(x - 1);
			
			// Insert an 'and' before the last group if needed
			if (x == 1 && group.getValue() < 100 && length > 1 && group.getValue() != 000) {
				result += NumberWordConstants.AND + " ";
			}

			// Insert the words for the group
			result += group.printWords();
			
			// Insert the word between groups depending on magnitude (position in list) of the group (e.g. billion)
			if (x > 1 && group.getValue() > 0) {
			  result += " " + NumberWordConstants.ORDERS_OF_MAGNITUDE[x - 1] + " ";
			}
		}
		
		return result.trim();
	}

	/**
	 * Setter used for unit testing.
	 * @param numberGroups the list of groups to set
	 */
	public void setNumberGroups(List<ThreeDigitGroup> numberGroups) {
		this.numberGroups = numberGroups;
	}
	
	/**
	 * Setter used for unit testing.
	 * @param number the number as an int
	 */
	public void setNumber(int number) {
		this.number = number;
	}	
}
