package Person_PR2;
import java.util.*;

public class Expert extends Person {
	
	private Set<Skill> specialisedSkills;

	public Expert(String firstname, String lastname, int ageYears, int heightCm, double weightKg,
			EnumSet<Skill> skills, EnumSet<Skill> specialisedSkills,  ForceAlignment FA) {
		super(firstname, lastname, ageYears, heightCm, weightKg, skills, FA);
		if(specialisedSkills.equals(null) || specialisedSkills.size() > 3) throw new IllegalArgumentException("spSkill!");
		this.specialisedSkills = specialisedSkills;
	}

	public Expert(String firstname, String lastname, EnumSet<Skill> skills, Set<Skill> specialisedSkills,  ForceAlignment FA) {
		super(firstname, lastname, skills, FA);
		if(specialisedSkills.equals(null) || specialisedSkills.size() > 3) throw new IllegalArgumentException("spSkill!");
		this.specialisedSkills = specialisedSkills;
	}
	
	@Override
	public boolean practise(Skill skill) {
		if(specialisedSkills.contains(skill)) {
			return this.practiseExpert(skill);
		}
		return super.practise(skill);
	}
	
	@Override
	public String toString() {
		return super.toString() + specialisedSkills;
	}
	
	//Aufgabe2
	@Override
	public int getForcePower() {
		int help = specialisedSkills.size();
		int help2 = 2;
		if(help == 1) help2 = 2;
		if(help == 2) help2 = 4;
		if(help == 3) help2 = 8;
		return super.getForcePower() * help2;
	}
}