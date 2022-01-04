package domein;

public class Held {
	private Wapen wapen;
	
	public Held(Wapen wapen) {
		setWapen(wapen);
	}
	
	public Held() {
		setWapen(new Handen());
	}
	
	public void valAan() {
		wapen.ValAan();
	}
	
	public void setWapen(Wapen wapen) {
		this.wapen = wapen;
	}
	
}
