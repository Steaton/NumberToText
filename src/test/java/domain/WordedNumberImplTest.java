package domain;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

import domain.WordedNumberImpl;

public class WordedNumberImplTest extends TestCase {
	
	@Test
	public void testZero() {

		// Set up domain object under test
		WordedNumberImpl num = new WordedNumberImpl("0");
		List<ThreeDigitGroup> numGroups = new ArrayList<ThreeDigitGroup>();	
		
		// Use mock implementation of ThreeDigitGroup
		MockThreeDigitGroup zero = new MockThreeDigitGroup();
		zero.setWords("");
		zero.setValue(0);
		numGroups.add(zero);
		
		//Inject mock objects
		num.setNumberGroups(numGroups);
		num.setNumber(0);

		// Execute the test
		String result = num.printWords();
		
		// Validate the result
		assertTrue(result.equals("zero"));
	}
	
	@Test
	public void testMaximum() {

		// Set up domain object under test
		WordedNumberImpl num = new WordedNumberImpl("0"); // Overwrite this value
		List<ThreeDigitGroup> numGroups = new ArrayList<ThreeDigitGroup>();	
		
		// Use mock implementation of ThreeDigitGroup
		MockThreeDigitGroup max = new MockThreeDigitGroup();
		max.setWords("nine hundred and ninety nine");
		max.setValue(999);
		numGroups.add(max); 
		numGroups.add(max);
		numGroups.add(max);
		
		// Inject mock objects
		num.setNumberGroups(numGroups);
		num.setNumber(999999999);

		// Execute the test
		String result = num.printWords();
		
		// Validate the result
		assertTrue(result.equals("nine hundred and ninety nine million " +
				                 "nine hundred and ninety nine thousand " +
				                 "nine hundred and ninety nine"));		
	}
	
	@Test
	public void testOneDigit() {
		
		// Set up domain object under test
		WordedNumberImpl num = new WordedNumberImpl("8");
		List<ThreeDigitGroup> numGroups = new ArrayList<ThreeDigitGroup>();	
		
		// Use mock implementation of ThreeDigitGroup
		MockThreeDigitGroup eight = new MockThreeDigitGroup();
		eight.setWords("eight");
		eight.setValue(8);
		numGroups.add(eight);
		
		// Inject mock objects
		num.setNumberGroups(numGroups);
		num.setNumber(8);

		// Execute the test
		String result = num.printWords();
		
		// Validate the result
		assertTrue(result.equals("eight"));		
		
	}
	
	@Test
	public void testHundredMil() {
		
		// Set up domain object under test
		WordedNumberImpl num = new WordedNumberImpl("100000000");
		List<ThreeDigitGroup> numGroups = new ArrayList<ThreeDigitGroup>();	
		
		// Use mock implementation of ThreeDigitGroup
		MockThreeDigitGroup hundred = new MockThreeDigitGroup();
		hundred.setWords("one hundred");
		hundred.setValue(100);
		
		MockThreeDigitGroup threeZeros = new MockThreeDigitGroup();
		threeZeros.setWords("");
		threeZeros.setValue(0);
		
		numGroups.add(threeZeros);
		numGroups.add(threeZeros);
		numGroups.add(hundred);
		
		// Inject mock objects
		num.setNumberGroups(numGroups);
		num.setNumber(100000000);

		// Execute the test
		String result = num.printWords();
		
		// Validate the result
		assertTrue(result.equals("one hundred million"));			
	}
	
	@Test
	public void testHundredMilAndOne() {
		
		// Set up domain object under test
		WordedNumberImpl num = new WordedNumberImpl("100000001");
		List<ThreeDigitGroup> numGroups = new ArrayList<ThreeDigitGroup>();	
		
		// Use mock implementation of ThreeDigitGroup
		MockThreeDigitGroup hundred = new MockThreeDigitGroup();
		hundred.setWords("one hundred");
		hundred.setValue(100);
		
		MockThreeDigitGroup threeZeros = new MockThreeDigitGroup();
		threeZeros.setWords("");
		threeZeros.setValue(0);
		
		MockThreeDigitGroup one = new MockThreeDigitGroup();
		one.setWords("one");
		one.setValue(1);
		
		numGroups.add(one);
		numGroups.add(threeZeros);
		numGroups.add(hundred);
		
		// Inject mock objects
		num.setNumberGroups(numGroups);
		num.setNumber(100000001);

		// Execute the test
		String result = num.printWords();
		
		// Validate the result
		assertTrue(result.equals("one hundred million and one"));			
	}
	
	@Test
	public void testNonNumeric() {
		
    	boolean exceptionThrown = false;
    	
    	try {
    		WordedNumberImpl num = new WordedNumberImpl("10000000F");    	  
        } catch (NumberFormatException e) {
        	exceptionThrown = true;
        }
        
        assertTrue(exceptionThrown);
	}
}
