package Person_PR2;

public enum Skill {
	MATH(30){
		@Override
		public int getBonus(int level) {
			return  getBase() + level * 100;
		}
	}
	, GEOGRAPHY(10), HISTORY, ENGLISH, FRENCH, LITERATURE,
	SPORTS(10), PROGRAMMING(40), JAPANESE(40);
	
	 private final int base;
	 
	 public int getBase() {return base;}

	 private Skill(int base) {
		 this.base = base;
	 }
	 private Skill() {
		 this.base = 20;
	 }
	 
	 public int getBonus(int level) {
		 return level * getBase();
	 }
}