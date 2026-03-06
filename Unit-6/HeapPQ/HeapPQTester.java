public class HeapPQTester {
    public static void main(String[] args) {
        HeapPQ<Integer> pq = new HeapPQ<>();
        pq.add(10);
        pq.add(4);
        pq.add(15);
        pq.add(20);
        pq.add(1);
        pq.add(7);
        System.out.println(pq);
        System.out.println("Size: " + pq.size());
        System.out.println("Peek: " + pq.peek());
        System.out.println(pq.removeMin());
        System.out.println(pq.removeMin());
        System.out.println(pq.removeMin());
        System.out.println(pq);
        System.out.println("Empty: " + pq.isEmpty());
        pq.add(3);
        pq.add(8);
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.removeMin());
        }
        System.out.println("Size: " + pq.size());
        System.out.println("Empty: " + pq.isEmpty());
    }
}
