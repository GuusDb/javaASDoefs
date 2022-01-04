package domein;

public class Dirty extends FileState{
	public Dirty(File file) {
		super(file);
	}
	
	public String opslagen() {
		return "het is opgeslagen dreiri";
	}
	
	public String toString() {
		return "wachten op opslagen";
	}
}
