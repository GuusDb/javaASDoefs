package domein;

public class Zipped extends FileDecorator{
	
	public Zipped(FileReader fr) {
		super(fr);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return getFile().getDescription() + " zipped";
	}
	
}
