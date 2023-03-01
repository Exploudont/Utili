public class Test2 {
	public static void main(String[] args) {
		Thread t;
		
		
		Runnable print = () -> System.out.println("runnable Object");
		new Thread(print).start();
		
		// usando una lambda passo come parametro la funzione
		// l'implmentazione di void run()
		t = new Thread(() -> System.out.println("runnable da lambda"));
		t.start();
		
		
		ExampleInterface ex;
		
		ex = (prefix, suffix) -> { return prefix + "test" + suffix; };
		System.out.println(ex.test("prefix of ", "; and the suffix"));
		
		ex = (prefix, suffix) -> prefix + "test" + suffix;
		System.out.println(ex.test("prefix of ", "; and the suffix"));
		
		
	}
}