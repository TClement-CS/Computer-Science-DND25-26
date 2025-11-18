import java.util.ArrayList;

public class PugSaverTester {
    public static void main(String[] args) {
        Dog A = new Dog("German Shepard");
        Dog B = new Dog("Golden Retriever");
        Dog C = new Dog("Corgi");
        Dog D = new Dog("Border Collie");
        Dog E = new Dog("Golden Doodle");
        MyArrayList<Dog> list1 = new MyArrayList<>();
        list1.add(A);
        list1.add(B);
        list1.add(C);
        list1.add(D);
        list1.add(E);
        list1.remove(B);
    }
}
