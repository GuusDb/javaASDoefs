package domein;

public abstract class ViewDecorator extends TextView{

	private TextView textview;
	
	public ViewDecorator(TextView textview) {
		this.textview = textview;
	}
	
	protected TextView getTextview() {
		return this.textview;
	}
	
	@Override
	public abstract String getView();
	
}
