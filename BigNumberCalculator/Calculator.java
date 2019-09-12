//	Nathan Azoulay
//	Assignment 1
//	Feb 28 2019
//	cssc0204  RED ID: 821871239

package big_numbers;

// This is where you will write the calculator functions
//
// This class only has one public method:


public class Calculator {

	public String calculate(String number1, String operation, String number2) {
		BigNumber obj1 = new BigNumber(); 
		BigNumber obj2 = new BigNumber();
		BigNumber ans = new BigNumber();
		obj1.stringToBigNumber(number1);
		obj2.stringToBigNumber(number2);

		if(operation.equals("+")) {
			if(obj1.getNegative() && !obj2.getNegative()) {
				ans = subtract(obj2,obj1);
			} // if obj1 is negative only
			else if(!obj1.getNegative() && obj2.getNegative()) {
				ans = subtract(obj1,obj2);
			} // if obj2 is negative only
			else if(obj1.getNegative() && obj2.getNegative()) {
				ans = addition(obj1,obj2);
				ans.setNegative(true);
			} // if both negative
			else
				ans = addition(obj1,obj2); // if both positive
		} // end if addition

		if(operation.equals("-")) {

			if(obj1.getNegative() && !obj2.getNegative()) {
				ans = addition(obj2,obj1);
				ans.setNegative(true);
			} // if obj1 is negative only
			else if(!obj1.getNegative() && obj2.getNegative()) {
				ans = addition(obj1,obj2);
			} // if obj2 is negative only
			else if(obj1.getNegative() && obj2.getNegative()) {
				ans = subtract(obj2,obj1);
			} //if both objects are negative
			else
				ans = subtract(obj1,obj2); // if both positive
		} // end if subtraction


		if(operation.equals("*")) {
			boolean isNegative = false;
			BigNumber one = new BigNumber();
			one.stringToBigNumber("1");
			ans.stringToBigNumber("0");
			if(obj1.getNegative() ^ obj2.getNegative()) {
				isNegative = true;
			}

			do{	
				obj2 = subtract(obj2, one);		// using addition to multiply objects, updating obj2 every loop
				ans = addition(ans,obj1);
			}
			while(!checkZero(obj2)); 

			ans.setNegative(isNegative); // sets answer to negative if true

		} // end if multiplication

		if(operation.equals("/")) {
			boolean isNegative = false;
			ans.stringToBigNumber("0");
			BigNumber one = new BigNumber();
			one.stringToBigNumber("1");
			if(obj1.getNegative() ^ obj2.getNegative()) {
				isNegative = true;
			}
			do {
				ans = addition(ans,one);
				obj1 = subtract(obj1,obj2);			// uses subtraction to divide, ans is a counter
			}while(!obj1.getNegative());

			ans = subtract(ans,one);
			ans.setNegative(isNegative); // sets answer to negative if true

		} // end if division
		return ans.toString();
	} // end calculate method

	private boolean checkZero(BigNumber obj) {
		boolean isZero = false;
		if(obj.length() == 1 && obj.getFirstDigit() == 0) {		// checks if obj is 0, return T or F
			isZero = true;
		}
		return isZero;
	} // end method checkZero

	private BigNumber addition(BigNumber obj1, BigNumber obj2) {
		BigNumber tmp1 = new BigNumber();
		BigNumber tmp2 = new BigNumber();
		tmp1.stringToBigNumber(obj1.toString());
		tmp2.stringToBigNumber(obj2.toString());
		BigNumber ans = new BigNumber();
		int carry = 0;
		Integer last1 = obj1.getLastDigit();
		Integer last2 = obj2.getLastDigit();

		while(last1 != null || last2 != null) {

			if(last1 == null)
				last1 = 0;
			if(last2 == null)
				last2 = 0;
			int result = last1 + last2 + carry;
			ans.addFirstDigit(result%10);
			carry = result/10;

			obj1.removeLastDigit();
			obj2.removeLastDigit();

			last1 = obj1.getLastDigit();
			last2 = obj2.getLastDigit();
		} // end while
		if(carry != 0) {
			ans.addFirstDigit(carry);
		}
		obj1.stringToBigNumber(tmp1.toString());
		obj2.stringToBigNumber(tmp2.toString());
		return ans;
	} // end addition method
	
	private BigNumber subtract(BigNumber obj1, BigNumber obj2) {
		BigNumber tmp1 = new BigNumber();
		BigNumber tmp2 = new BigNumber();
		tmp1.stringToBigNumber(obj1.toString());
		tmp2.stringToBigNumber(obj2.toString());
		boolean leftBigger = true;
		boolean isDone = false;
		if(obj1.length() > obj2.length()) {
			leftBigger = true;
			isDone = true;
		} // end if
		if(obj2.length() > obj1.length()) {
			leftBigger = false;
			isDone = true;
		} // end if
		obj1.resetIterator();
		obj2.resetIterator();
		while(isDone == false) {


			Integer digit1 = obj1.nextDigit(); // compares digits 1 by 1 to see which number is bigger
			Integer digit2 = obj2.nextDigit();

			if(digit1 < digit2) {
				isDone = true;
				leftBigger = false;
			}
			if(digit1 > digit2) {
				isDone = true;
				leftBigger = true;
			}
			if(obj1.hasNextDigit() == false || obj2.hasNextDigit() == false) {
				isDone = true;
			} // end while
		}
		BigNumber ans = new BigNumber();
		if(leftBigger == false) { 
			BigNumber tmp = obj1;		// switch order if obj2 is bigger
			obj1 = obj2;
			obj2 = tmp;
			ans.setNegative(true);
		} // end if

		int carry = 0;
		Integer last1 = obj1.getLastDigit();
		Integer last2 = obj2.getLastDigit();
		while(last1 != null || last2 != null) {
			if(last1 == null)
				last1 = 0;
			if(last2 == null)
				last2 = 0;
			int result = last1 - carry - last2;
			if(result < 0) {
				carry = 1;
				result = 10 + result;
			} // end if
			else
				carry = 0;
			ans.addFirstDigit(result);
			obj1.removeLastDigit();
			obj2.removeLastDigit();
			last1 = obj1.getLastDigit();
			last2 = obj2.getLastDigit();
		} // end while
		Integer frontDigit;
		do {
			frontDigit = ans.getFirstDigit();
			if(frontDigit == 0 && ans.length() > 1)
				ans.removeFirstDigit();
		}while(frontDigit == 0 && ans.length() != 1);
		obj1.stringToBigNumber(tmp1.toString());
		obj2.stringToBigNumber(tmp2.toString());
		return ans;
	} // end subtract method

} // end class Calculator
