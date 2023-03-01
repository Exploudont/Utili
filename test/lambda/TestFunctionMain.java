import java.util.function.Function;

/*
https://www.tutorialspoint.com/how-to-implement-function-t-r-interface-with-lambda-expression-in-java

https://www.javabrahman.com/java-8/java-8-java-util-function-function-tutorial-with-examples/
*/
public class TestFunctionMain {
	
	public static void main(String[] args) {
		
		// anonymous class
		Function<Integer, Integer> f1 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
		};
		System.out.println(f3.apply(10));
		
		// lambda expression
		Function<Integer, Integer> f2 = i -> i*4;
		System.out.println(f1.apply(10));
		
		// scope resolution
		Function<Integer, Integer> f3 = TestFunctionMain::square;
		System.out.println(f2.apply(10));
	}
	
	public static Integer square(Integer a) {
		return a*a;
	}
}