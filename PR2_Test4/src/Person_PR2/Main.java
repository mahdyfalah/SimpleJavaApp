package Person_PR2;
import java.util.*;

public class Main {
	public static void main(String[] args) {
	//Aufgabe1
		//Luke
		EnumSet<Skill> lukeSkills = EnumSet.of(Skill.MATH, Skill.ENGLISH, Skill.JAPANESE);
		Person luke = new Person("Luke", "Starkiller", 21, 178, 74, lukeSkills, ForceAlignment.NEUTRAL);
		
		//Leia
		EnumSet<Skill> leiaSkills = EnumSet.of(Skill.JAPANESE, Skill.ENGLISH);
		Person leia = new Person("Leia", "Organa", 22, 165, 75, leiaSkills, ForceAlignment.LIGHT);
		
		//Sheev
		EnumSet<Skill> sheevSkills = EnumSet.of(Skill.ENGLISH, Skill.FRENCH);
		EnumSet<Skill> sheevSpecial = EnumSet.of(Skill.MATH);
		Expert sheev = new Expert("Sheev", "Palpatine", 45, 187, 72, sheevSkills, sheevSpecial, ForceAlignment.DARK);
	
		System.out.println(luke.practise(Skill.MATH));
		System.out.println(leia.practise(Skill.FRENCH));
		System.out.println(leia.learn(luke, Skill.MATH));
		System.out.println(leia.practise(Skill.MATH));
		System.out.println(sheev.practise(Skill.MATH));
		System.out.println(sheev.learn(leia, Skill.JAPANESE));
		System.out.println(luke.learn(sheev, Skill.JAPANESE));
		System.out.println(sheev.learn(luke, Skill.MATH));
		System.out.println(sheev.practise(Skill.MATH));
		System.out.println(luke.practise(Skill.ENGLISH));
		System.out.println(leia.practise(Skill.JAPANESE));
		
		TreeSet<Person> list = new TreeSet<Person>((p1, p2)->{return p1.getTotalBonus() + p2.getTotalBonus();});
		list.add(luke);
		list.add(leia);
		list.add(sheev);
		
		//Ausgabe
		for(Person person : list) {
			System.out.println(person);
		}
		
	//Aufgabe3
		 ForcePower[] arr = {luke, leia, sheev};
		 int th = -100;
		 Set<ForcePower> list3 = PersonUtils.allOf(arr, th);
		 System.out.println(luke.getForcePower());
		 System.out.println(leia.getForcePower());
		 System.out.println(sheev.getForcePower());
		 for(ForcePower fp : list3) {
			 System.out.println(fp);
		 }
	}
}
