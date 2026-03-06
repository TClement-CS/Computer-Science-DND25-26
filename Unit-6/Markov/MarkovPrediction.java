import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPrediction {
    private HashMap<String, ArrayList<String>> weather;

    // Please define your own variables and data structures
    //

    public MarkovPrediction(String filePath) {
        weather = new HashMap<>();
        readData(filePath);

    }

    public ArrayList<String[]> readData(String filePath) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                list.add(temp);
            }
            readDataHelper(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void readDataHelper(ArrayList<String[]> list) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (!weather.containsKey(list.get(i)[0])) {
                temp.add(list.get(i)[1]);
                weather.put(list.get(i)[0], temp);
            } else {
                temp = weather.get(list.get(i)[0]);
                temp.add(list.get(i)[1]);
                weather.put(list.get(i)[0], temp);
            }
            temp = new ArrayList<String>();
        }
    }

    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        ArrayList<String> temp = weather.get(currentState);
        return temp.get((int) (Math.random() * temp.size()));
    }

}