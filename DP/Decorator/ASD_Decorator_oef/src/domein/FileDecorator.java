package domein;

public abstract class FileDecorator extends FileReader{
	
	FileReader file;
	
	public FileDecorator(FileReader fr) {
		this.file = fr;
	}
	


	public FileReader getFile() {
		return file;
	}

	@Override
	public abstract String getDescription();
}
