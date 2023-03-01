// serve per indicare che l'interfaccia ha
// un solo metodo
// un interfaccia con un solo metodo e' una functional interface.
@FunctionalInterface
public interface ExampleInterface {
	public String test(String prefix, String suffix);
}