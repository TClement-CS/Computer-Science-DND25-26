import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		ArrayList<Dog> newArrayList = new ArrayList<>();
		int n = 0;
		for (int i = 0; i < newArrayList.size() - n; i++) {
			if (newArrayList.get(i).getName().substring(0, 5) == "golden") {
				newArrayList.remove(i);
				newArrayList.add(newArrayList.get(i));
				n++;
			}
		}
	}
}
