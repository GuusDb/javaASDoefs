package domein;

public class ProgramNodeBuilder {
	
	private ProgramNode node;
	
	public ProgramNodeBuilder(String data) {
		this.node = new ProgramNode(data);
	}
	
	public void build() {
		System.out.printf("building %s%n",node.getData());
	}
}
