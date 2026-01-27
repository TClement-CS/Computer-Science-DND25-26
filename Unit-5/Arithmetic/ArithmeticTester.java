public class ArithmeticTester {
    public static void main(String[] args) {
        System.out.println("Convert Classic to Stout. Expected: '3 4 +' ");
        System.out.println(Arithmetic.convertClassicToStout("(3+4)"));
        System.out.println(Arithmetic.convertClassicToStout("12 + 34"));
    }
}
