import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;


public class MiniGPT {
	private HashMap<String, ArrayList<Character>> hmap = new HashMap<>(); // hashmap
	private ArrayList<String> keys = new ArrayList<String>(); // key array for selecting start of book
	private int chainOdor; // chain order

	public MiniGPT(String fileName, int chainOrder) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			int charAsInt;
			ArrayList<Character> stringChain = new ArrayList<Character>();
			// Read until the end of the stream (-1 is returned)
			while ((charAsInt = reader.read()) != -1) {
				// Cast the integer value to a character
				char character = (char) charAsInt;
				chainOdor = chainOrder;
				if (stringChain.size() == chainOrder + 1) {
					String keyString = stringChain.toString().replaceAll(", ", "");
					String key = keyString.substring(1, chainOrder + 1);
					Character next = stringChain.get(chainOrder);
					if (hmap.containsKey(key)) {
						hmap.get(key).add(next);
					} else if (!hmap.containsKey(key)) {
						ArrayList<Character> addArray = new ArrayList<>();
						addArray.add(next);
						hmap.put(key, addArray);
						keys.add(key);
					}
					stringChain.remove(0);
					stringChain.add(character);
				} else {
					stringChain.add(character);
				}
			}
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
	}

	public void generateText(String outputFileName, int numChars) {
		StringBuilder output = new StringBuilder();
		String start = (String) keys.get((int) Math.floor(Math.random() * keys.size())); // random string from key array
		output.append(start);
		for (int i = output.length(); i < numChars; i++) {
			String currentKey = output.substring(i - chainOdor, i);
			int random = (int) Math.floor(Math.random() * hmap.get(currentKey).size());
			output.append(hmap.get(currentKey).get(random));
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			writer.write(output.toString());
			writer.close();
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}

	}
}