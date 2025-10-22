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
        Recursion.printListInReverse(a);

        String[][] grid = {{"vaccinated", "safe",             "safe","safe"}, 
                           {"safe", "safe", "safe",  "safe"},
                           {"safe", "safe",       "safe",      "safe"}};
        Recursion.infect(grid, 1, 3);
    }
}
