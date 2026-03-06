import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MarkovPrediction {

    // Please define your own variables and data structures
    // 
    public ArrayList<String[]> readData(String filePath) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {


    }

}