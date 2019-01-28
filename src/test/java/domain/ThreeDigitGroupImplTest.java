package domain;

import junit.framework.TestCase;

import org.junit.Test;

public class ThreeDigitGroupImplTest extends TestCase {

	@Test
	public void testZero() {
		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("0");
		String result = group.printWords();
		assertTrue(result.equals(""));
	}

	@Test
	public void testMax() {
		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("999");
		String result = group.printWords();
		assertTrue(result.equals("nine hundred and ninety nine"));		
	}

	@Test
	public void testOneHundred() {
		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("100");
		String result = group.printWords();
		assertTrue(result.equals("one hundred"));		
	}

	@Test
	public void testOneHundredAndOne() {
		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("101");
		String result = group.printWords();
		assertTrue(result.equals("one hundred and one"));		
	}	

	@Test
	public void testNonNumeric() {
    	boolean exceptionThrown = false;
    	
    	try {
    		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("10F");
        } catch (NumberFormatException e) {
        	exceptionThrown = true;
        }
        
        assertTrue(exceptionThrown);
	}

	@Test
	public void testNegative() {
    	boolean exceptionThrown = false;
    	
    	try {
    		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("-10");
        } catch (NumberFormatException e) {
        	exceptionThrown = true;
        }
        
        assertTrue(exceptionThrown);	
	}	

	@Test
	public void testLeadingZeroes() {
		ThreeDigitGroupImpl group = new ThreeDigitGroupImpl("010");
		String result = group.printWords();
		assertTrue(result.equals("ten"));		
	}
}
