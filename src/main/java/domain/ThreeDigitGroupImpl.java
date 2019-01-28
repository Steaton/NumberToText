package domain;

import constants.NumberWordConstants;

public class ThreeDigitGroupImpl implements ThreeDigitGroup {

	private int[] digits = {0, 0, 0};
	
	private int value;
	
	/**
	 * Constructor takes a string containing between one and three digits.
	 * @param threeDigitGroup string of digits
	 * @throws NumberFormatException if the string contains characters other than digits
	 */
	public ThreeDigitGroupImpl(String threeDigitGroup) {
				
		// Pre-conditions
		assert threeDigitGroup.length() <= 3;
		assert threeDigitGroup.length() >= 1;
		
		value = Integer.parseInt(threeDigitGroup);
		
		// Copy digits from string representation into an internal int array representation
		int count = 2;
		for (int x = threeDigitGroup.length() - 1; x >= 0; x--) {
			
			String digit = threeDigitGroup.substring(x, x + 1);
			digits[count] = Integer.parseInt(digit);
			count--;
		}
		
		// Post-condition
		assert Integer.parseInt(new String("" + digits[0] + digits[1] + digits[2])) == value;
	}

	/**
	 * {@inheritDoc}
	 */
	public String printWords() {
		
		String result = "";
		boolean hasRemainder = !(digits[1] == 0 && digits[2] == 0);
		
		// First deal with the hundreds
		if (digits[0] > 0) {

			result = NumberWordConstants.NUMBERS[digits[0]];
			result += " " + NumberWordConstants.ORDERS_OF_MAGNITUDE[0];
			
			// Add an 'and' if there is a remainder
			if (hasRemainder) {
				result += " " + NumberWordConstants.AND + " ";
			}
		}
		
		// Add then the remainder of the number
		if (hasRemainder) {
			
			if (digits[1] <= 1) {
				// 1 to 19
				result += NumberWordConstants.NUMBERS[(digits[1] * 10) + digits[2]];
			} else if (digits[2] == 0) {
				// Tens
				result += NumberWordConstants.TENS[digits[1] - 1];
			} else {
				// Tens with Units
				result += NumberWordConstants.TENS[digits[1] - 1] + " " 
				            + NumberWordConstants.NUMBERS[digits[2]];
			}
		}
		
		return result;
	}

	public int getValue() {
		return value;
	}
}
