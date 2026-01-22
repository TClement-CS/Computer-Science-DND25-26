public class MyStackTester {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack();
        s.push("Derp");
        String str = s.peek();
        str = s.pop();
    }
}