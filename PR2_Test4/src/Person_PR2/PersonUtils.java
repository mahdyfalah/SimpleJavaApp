package Person_PR2;
import java.util.*;

public abstract class PersonUtils {
	public static Set<ForcePower> allOf(final ForcePower[] arr, final Integer th){
		
		Set<ForcePower> list = new TreeSet<ForcePower>((p1,p2)->{return p1.getForcePower() - p2.getForcePower();});
		int help = 0;
		if(th == null) help = 5;
		else {help = th;}
		
		for(ForcePower fp : arr) {
			if(fp.getForcePower() >= help) {
				list.add(fp);
			}
		}
		
		return list;
	}
}
