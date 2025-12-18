public class SortedArrayListTest {

    public static void main(String[] args) {
        SortedArrayList<Integer> sortedList = new SortedArrayList<>();

        sortedList.add(10);
        sortedList.add(5);
        sortedList.add(15);
        sortedList.add(7);
        sortedList.add(1);

        System.out.println("Test Add - Sorted Order:");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.print(sortedList.get(i) + " ");
        }
        System.out.println();

        System.out.println("Test Contains:");
        System.out.println(sortedList.contains(10)); 
        System.out.println(sortedList.contains(20));

        System.out.println("Test Remove:");
        sortedList.remove(10);
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.print(sortedList.get(i) + " ");
        }
        System.out.println();

        System.out.println("Test Min:");
        System.out.println(sortedList.min());

        System.out.println("Test Max:");
        System.out.println(sortedList.max());

        System.out.println("Test Binary Search:");
        System.out.println(sortedList.binarySearch(sortedList.internalArray, 7));  
        System.out.println(sortedList.binarySearch(sortedList.internalArray, 10));
        System.out.println(sortedList.binarySearch(sortedList.internalArray, 1));  
    }
}
