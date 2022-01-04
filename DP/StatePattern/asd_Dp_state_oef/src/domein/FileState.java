package domein;

public abstract class FileState {
	private final File file;
	
	public FileState(File file) {
		this.file = file;
	}
	
	public String aanpassen() {
		return "het is al dirty";
	}
	
	public String opslagen() {
		return "het is dus al opgeslagen";
	}
	
	
}
