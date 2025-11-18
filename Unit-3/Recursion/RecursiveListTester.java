public class RecursiveListTester {
    public static void main(String[] args) {
        ListNode a = new ListNode("A");
        ListNode b = new ListNode("B");
        ListNode c = new ListNode("C");
        ListNode d = new ListNode("D");
        ListNode e = new ListNode("E");
        ListNode f = new ListNode("F");
        ListNode g = new ListNode("G");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        g.setNext(null);
        // System.out.println("\n\n\n");
        // System.out.println("Print List in Reverse Test:\n Expected:
        // G,F,E,D,C,B,A\n");
        // Recursion.printListInReverse(a);
        // System.out.println("\nInfect Test: Passed\n");
        // String[][] grid = { { "vaccinated", "safe", "safe", "safe" },
        // { "safe", "safe", "safe", "safe" },
        // { "safe", "safe", "safe", "safe" } };
        // Recursion.infect(grid, 1, 3);
        // System.out.println("Count Non Consecutive Subsets Test:\nExpected: 8\n");
        // System.out.println(Recursion.countNonConsecutiveSubsets(4));
        // System.out.println("\nCount ways to jump Stairs Test:");
        // System.out.println(Recursion.countWaysToJumpUpStairs(4));

        // Recursion.solveHanoi(8);
        int[] times = { 1, 2, 3 };
        int[] points = { 10, 15, 20 };
        System.out.println(Recursion.scavHunt(times, points));
    }
}
