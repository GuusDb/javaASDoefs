package domein;

public class CompilerFacade {
	private Parser parse;
	private ProgramNodeBuilder builder;
	private Scanner scanner;
	private byteCodeStream bts;
	
	public CompilerFacade(String data) {
		parse = new Parser();
		builder = new ProgramNodeBuilder(data);
		scanner = new Scanner();
		bts = new byteCodeStream();
	}

	public void Compile() {
		scanner.Scanning();
		bts.Stream();
		builder.build();
		parse.Parse();
		System.out.println("tis gedaan");
	}
	
}
