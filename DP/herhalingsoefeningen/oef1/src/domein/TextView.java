package domein;

public abstract class TextView {
	public String view = "geen view";
	
	public void setView(String view) {
		this.view = view;
	}
	
	public String getView() {
		return view;
	}
}
