public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT ants_test = new MiniGPT("test.txt", 10);
        ants_test.generateText("grokoutput.txt", 100000);

        // MiniGPT asilay = new MiniGPT("thegreatgatsby.txt", 9);
        // asilay.generateText("AS_I_LAY_DYING_2.txt", 100000);
    }
}
