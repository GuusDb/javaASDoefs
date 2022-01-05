package domein;

public class CompilerFacade {
	private Parser parse;
	private ProgramNodeBuilder builder;
	private Scanner scanner;
	private byteCodeStream bts;
	
	//dit is fout de compiler moet al deze objecten meegeven aan de facade kijk naar herhalingsoef 2 van dp
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
