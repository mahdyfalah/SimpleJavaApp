package Person_PR2;
import java.util.*;


public class Person implements Comparable<Person>, ForcePower{
	private static final int minMax [][] = {{10, 20, 100}, {100, 200, 250}};
	
	private String firstname;
	private String lastname;
	private int ageYears;
	private int heightCm;
	private double weightKg;
	private ForceAlignment FA;
	private Map<Skill, Integer> skillLevel = new LinkedHashMap<>();
	
	
	public Person(String firstname, String lastname, int ageYears, int heightCm, double weightKg, EnumSet<Skill> skills, ForceAlignment FA) {
		if(firstname.equals(null) || lastname.equals(null)) throw new IllegalArgumentException("null value!");
		if(ageYears < minMax[0][0] || ageYears > minMax[1][0]) throw new IllegalArgumentException("age!");
		if(heightCm < minMax[0][2] || heightCm > minMax[1][2]) throw new IllegalArgumentException("height!");
		if(weightKg < minMax[0][1] || weightKg > minMax[1][1]) throw new IllegalArgumentException("weight!");
		if(skills.equals(null)) throw new IllegalArgumentException("No Skills!");
		this.firstname = firstname;
		this.lastname = lastname;
		this.ageYears = ageYears;
		this.heightCm = heightCm;
		this.weightKg = weightKg;
		for(Skill skill: skills) {
			skillLevel.put(skill, 0);
		}
		this.FA = FA;
	}
	
	public Person(String firstname, String lastname, EnumSet<Skill> skills, ForceAlignment FA) {
		this(firstname, lastname, 20, 180, 70, skills, FA);
	}

	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		if(firstname.equals(null)) throw new IllegalArgumentException("null value!");
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if(lastname.equals(null)) throw new IllegalArgumentException("null value!");
		this.lastname = lastname;
	}
	public int getAgeYears() {
		return ageYears;
	}
	public void setAgeYears(int ageYears) {
		if(ageYears < minMax[0][0] || ageYears > minMax[1][0]) throw new IllegalArgumentException("age!");
		this.ageYears = ageYears;
	}
	public int getHeightCm() {
		return heightCm;
	}
	public void setHeightCm(int heightCm) {
	if(heightCm < minMax[0][2] || heightCm > minMax[1][2]) throw new IllegalArgumentException("height!");
		this.heightCm = heightCm;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		if(weightKg < minMax[0][1] || weightKg > minMax[1][1]) throw new IllegalArgumentException("weight!");
		this.weightKg = weightKg;
	}

	public boolean olderThan(Person other) {
		if(this.ageYears > other.getAgeYears()) return true;
		return false;
	}
	public boolean tallerThan(Person other) {
		if(this.heightCm > other.getHeightCm()) return true;
		return false;
	}
	public boolean heavierThan(Person other) {
		if(this.weightKg > other.getWeightKg()) return true;
		return false;
	}

	public String toString() { 
	    return this.firstname +", "+ this.lastname +"(ageYears "+ this.ageYears +
	    		", heightCm "+ this.heightCm +", weightKg "+ this.weightKg +")" +"-"+ skillLevel;     
	} 
	
	public boolean hasSkill(Skill skill) {
		if(skillLevel.containsKey(skill)) return true;
		return false;
	}
	
	public void learnHelper(Skill skill) {
		skillLevel.put(skill, 0);
	}
	
	public boolean learn(Person other, Skill newSkill) {
		if(other.hasSkill(newSkill) && !hasSkill(newSkill)) {
			for(Skill skill : skillLevel.keySet()) {
				if (!other.hasSkill(skill)) {
					other.learnHelper(skill);
					this.learnHelper(newSkill);
					return true;
				}
			}
		}		
		return false;
	}
	
	public boolean practise(Skill skill) {
		if(skillLevel.containsKey(skill)) {
			skillLevel.put(skill, skillLevel.get(skill) + 1);
			return true;
		}
		return false;
	}
	
	protected boolean practiseExpert(Skill skill) {
		if(skillLevel.containsKey(skill)) {
			skillLevel.put(skill, skillLevel.get(skill) + 3);
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Person person) {
		return this.ageYears - person.getAgeYears();
	}
	
	public static Comparator<Person> compareByWeight(){
		return Comparator.comparing(Person::getWeightKg);
	}
	
	public static Comparator<Person> compareByHeight(){
		return Comparator.comparing(Person::getHeightCm);
	}
	
	int getTotalBonus() {
		int sum = 0;
		for(Skill skill : skillLevel.keySet()) {
			sum += skill.getBonus(skillLevel.get(skill));
		}
		return sum;
	}
	
	public static Comparator<Person> compareByBonus(){
		return Comparator.comparing(Person::getTotalBonus);
	}
	
	//Aufgabe2
	public int getForcePower() {
		return FA.getKonstant() + lastname.length();
	}
}




