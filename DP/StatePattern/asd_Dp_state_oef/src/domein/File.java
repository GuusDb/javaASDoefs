package domein;

public class File {

	private FileState currentState;
	
	public File() {
		toState(new Clean(this));
	}
	
	public void toState(FileState filestate) {
		currentState = filestate;
	}
	
	public String save() {
		String res = currentState.opslagen();
		toState(new Clean(this));
		return res;
	}
	
	public String aanpassen() {
		String res = currentState.aanpassen();
		toState(new Dirty(this));
		return res;
	}
	public String toString() {
		return currentState.toString();
	}
	
}
