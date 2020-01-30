package Person_PR2;

public enum ForceAlignment {
	DARK(-50),NEUTRAL,LIGHT(50);
	
	int konstant;
	
	private ForceAlignment(int konstant) {
		this.konstant = konstant;
	}
	
	private ForceAlignment() {
		this.konstant = 0;
	}
	
	public int getKonstant() {
		return konstant;
	}
}
