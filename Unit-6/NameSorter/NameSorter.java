import java.util.ArrayList;

public class NameSorter {

    private ArrayList<String>[] buckets;

    public NameSorter() {
        buckets = new ArrayList[500];
        for (int i = 0; i < 500; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public int getNameValue(String thisName) {
        int charValues = 0;
        for (int i = 0; i < thisName.length(); i++) {
            charValues += thisName.charAt(i);
        }
        return charValues % 500;
    }

    public ArrayList<String>[] sortArray(String[] ogArray) {
        for (String name : ogArray) {
            int index = getNameValue(name);
            buckets[index].add(name);
        }
        return buckets;
    }
}