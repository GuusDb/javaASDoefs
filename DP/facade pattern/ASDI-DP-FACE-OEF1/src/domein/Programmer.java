package domein;

public class Programmer {
	CompilerFacade comp;
	
	public Programmer(String code) {
		comp = new CompilerFacade(code);
	}
	
	public void compile() {
		comp.Compile();
	}

}
