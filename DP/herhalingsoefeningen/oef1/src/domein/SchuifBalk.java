package domein;

public class SchuifBalk extends ViewDecorator{
	
	public SchuifBalk(TextView tv) {
		super(tv);
	}

	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return getTextview().getView() + " schuifbalk";
	}

}
