public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		ListNode newNode = head;
		if (newNode.getNext() == null) {
			System.out.println(newNode.getValue());
			return;
		}
		printListInReverse(head.getNext());
		System.out.println(head.getValue());

	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length) {
			return;
		}
		if (c < 0 || c >= grid[0].length) {
			return;
		}

		if (grid[r][c].equals("vaccinated") || grid[r][c].equals("infected")) {
			return;
		} else {
			grid[r][c] = "infected";
			infect(grid, r - 1, c);
			infect(grid, r + 1, c);
			infect(grid, r, c - 1);
			infect(grid, r, c + 1);
		}

	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		long count = 0;
		if (n == 2) {
			return 3;
		} else if (n == 1) {
			return 2;
		}

		count = countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);

		return count;
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n <= 2) {
			return n;
		}
		long waysToJump = countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2)
				+ countWaysToJumpUpStairs(n - 3);
		return waysToJump;
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void printSubsets(String str) {
		if (str == null) {
			throw new IllegalArgumentException();
		}
		subsetPrinter(str, 0, "");
	}

	public static void subsetPrinter(String str, int index, String current) {
		if (index == str.length()) {
			System.out.println(current);
			return;
		}

		subsetPrinter(str, index + 1, current + str.charAt(index));
		subsetPrinter(str, index + 1, current);

	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {
		if (str == null) {
			System.out.println("null");
		}
		findPermutations("", str);

	}

	public static void findPermutations(String str, String remaining) {
		if (remaining.length() == 0) {
			System.out.println(str);
			return;
		}
		for (int i = 0; i < remaining.length(); i++) {
			char c = remaining.charAt(i);
			String nextRemaining = remaining.substring(0, remaining.indexOf(c))
					+ remaining.substring(remaining.indexOf(c) + 1);
			findPermutations(str + c, nextRemaining);
		}
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merger(arr, left, mid, right);
		}
	}

	private static void merger(int[] arr, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				tmp[k] = arr[i];
				i++;
				k++;
			} else {
				tmp[k] = arr[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			tmp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= right) {
			tmp[k] = arr[j];
			j++;
			k++;
		}
		for (int a = 0; a < tmp.length; a++) {
			arr[left + a] = tmp[a];
		}
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int cutspot = cutter(arr, low, high);
			quickSort(arr, low, cutspot - 1);
			quickSort(arr, cutspot + 1, high);
		}
	}

	private static int cutter(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = t;
		return i + 1;
	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {
		int startpole = 0;
		int transferpole = 1;
		int endpole = 2;
		diskSorter(startingDisks, startpole, transferpole, endpole);
	}

	public static void diskSorter(int startingDisks, int startpole, int transferpole, int endpole) {
		if (startingDisks == 0) {
			return;
		}

		diskSorter(startingDisks - 1, startpole, endpole, transferpole);

		System.out.println(startpole + " -> " + endpole);
		diskSorter(startingDisks - 1, transferpole, startpole, endpole);

	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {
		return maxReward(times, points, 0);
	}

	public static int maxReward(int[] times, int[] points, int index) {
		System.out.println("Index: " + index);
		if (index >= times.length) {
			return 0;
		}
		int tempIndex = -1;
		int maximum = maxReward(times, points, index + 1);
		int maxpoints = 0;
		int pointsofindex = points[index];
		for (int i = index + 1; i < times.length; i++) {
			if (times[i] >= 5 + times[index]) {
				System.out.println("Considering item at index " + i + " (time: " + times[i] + ")");
				tempIndex = i;
				break;
			}
		}
		if (tempIndex != -1) {
			pointsofindex += maxReward(times, points, tempIndex);
		}
		System.out.println("Max points at index " + index + ": " + maxpoints);
		return Math.max(maximum, pointsofindex);
	}

}
