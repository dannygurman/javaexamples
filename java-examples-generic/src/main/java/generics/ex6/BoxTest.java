package generics.ex6;

/* Generics, Inheritance, and Subtypes */

public class BoxTest {

	public static void main(String[] args) {
		Object someObject = new Object();
		Integer someInteger = new Integer(10);
		someObject = someInteger;   // OK
		
		BoxTest boxTest =new BoxTest();
		boxTest.someMethod(new Integer(10));
		boxTest.someMethod(new Double(1.2));
		
		Box<Number> numberBox =new Box<Number>();
		boxTest.boxTest(numberBox);
		
		Box<Integer> integerBox =new Box<Integer>();
		// boxTest.boxTest(integerBox); COMPILATION ERROR! :
		//Box<Integer> and Box<Double> are not subtypes of Box<Number>.
	}
	
	
	public void someMethod(Number n) {		/* ... */ }

	public void boxTest(Box<Number> n) { /* ... */ }
	
}
