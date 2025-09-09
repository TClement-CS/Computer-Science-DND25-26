import java.util.ArrayList;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().substring(0, 5).equals("golden")) {
				for (int j = list.size(); j > 0; j++) {
					if (list.get(i).getName().substring(0, 5).equals("golden") == false) {
						
						list.set(j, list.set(i, list.get(j)));
					}
				}
			}
		}
	}
}
