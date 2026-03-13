public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT gatsby = new MiniGPT("thegreatgatsby.txt", 9);
        gatsby.generateText("GATSBY_2.txt", 100000);

        MiniGPT asilay = new MiniGPT("thegreatgatsby.txt", 9);
        asilay.generateText("AS_I_LAY_DYING_2.txt", 100000);
    }
}
