import java.util.HashMap;

public class MarkovPredictionTester {
    public static void main(String[] args) {
        MarkovPrediction temp = new MarkovPrediction("weather.csv");
        // temp.readData(weather.csv);
        System.out.println(temp.predictNextState("Foggy"));
        // System.out.println(temp.predictNextState("Cloudy"));
        // System.out.println(temp.predictNextState("Rainy"));

    }
}
