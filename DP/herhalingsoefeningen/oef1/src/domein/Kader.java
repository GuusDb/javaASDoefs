package domein;

public class Kader extends ViewDecorator{

	public Kader(TextView tv) {
		super(tv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return getTextview().getView() + "schuifbalk";
	}
	
}
