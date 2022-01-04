package domein;

public class Encrypted extends FileDecorator{

	public Encrypted(FileReader fr) {
		super(fr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return getFile().getDescription() + " encrypted";
	}
	

}
