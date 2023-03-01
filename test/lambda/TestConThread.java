public class TestConThread {
	
	public static void main(String[] args) {
		new Thread(Test::fun).start();
	}
	
	public static void fun() {
		while(true)
			System.out.println("Hello");
	}
}