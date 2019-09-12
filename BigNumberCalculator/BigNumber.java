//	Nathan Azoulay
//	Assignment 1
//	Feb 28 2019
//	cssc0204  RED ID: 821871239


package big_numbers;

import data_structures.LinkedList;

// This is where you will write your code for manipulating the big number
// as described in the assignment. 
//
// This class will include the getFirstDigit(), getLastDigit(), addFirstDigit(), addLastDigit()
// methods, as well as the setNegative(), getNegative(), length() methods.
//
// You will also need to write stringToBigNumber() and toString() methods.


public class BigNumber extends LinkedList<Integer> {

	boolean negative = false;
	
	public Integer nextDigit() {
		return getNext(); 		// gets next digit
	} // end nextDigit method
	
	public void resetIterator() {
		 resetIter();		// resets iterator
	} // end resetIterator method
	
	public boolean hasNextDigit() {
		return hasNext();		// returns T or F whether obj has a nextDigit
	} // end hasNextDigit method
	
	
	public BigNumber() {
		super();
	} // end BigNumber constructor
	
	public void removeLastDigit() {

		removeLast();		// removes the last digit of object
	} // end removeLast Digit method
	
	public void removeFirstDigit() {
		removeFirst();		// removes the first digit of object
	} // end removeFirstDigit method
	
	public Integer getFirstDigit() {
		return peekFirst();	// returns first digit of object
	} // end getFirstDigit method
	
	public Integer getLastDigit() {
		return peekLast();	// returns last digit of object
	} // end getLastDigit method
	
	public void addFirstDigit(int a) {
		addFirst(a);		// adds an int to front of object
	} // end addFirstDigit method
	
	public void addLastDigit(int a) {
		addLast(a);			// adds an int to end of object
	} // end addLastDigit method
	
	public void setNegative(boolean b) {
		negative = b;		// sets boolean value negative to T or F
	} // end setNegative method
	
	public boolean getNegative() {
		return negative; 	// returns T or F whether object is negative
	} // end getNegative method
	
	public int length() {
		return size();		// returns length of object
	} // end length method
	
	public void stringToBigNumber(String s) {
		makeEmpty();
		int i = 0;
		if(s.charAt(0) == '-') {	// turns a string into a BigNumber object
			negative = true;
			i = 1;
		}
			
		
		for(; i < s.length(); i++) {
			int b = Character.getNumericValue(s.charAt(i));
			addLast(b);
		}
				
	} // end stringToBigNumber method
	
	public String toString() {
		String s = "";
		resetIter();
		if(negative == true)
			s+= "-";
		while(hasNext()) {		// prints answer as a string
			int a = getNext();
			s+= Integer.toString(a);
		}
			return s;
	} // end toString method
	} // end BigNumber class



