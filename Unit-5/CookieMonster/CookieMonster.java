import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues

public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	// You may find it VERY helpful to write this helper method. Or not!
	private boolean validPoint(int row, int col) {
		// Write this if you want
		if (row < numRows && col < numCols && cookieGrid[row][col] != -1) {
			return true;
		}
		return false;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies.
	 * Returns the maximum number of cookies attainable.
	 */
	public int recursiveCookies() {
		return recursiveCookies(0, 0);
	}

	// Returns the maximum number of cookies edible starting from (and including)
	// cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {
		if (!validPoint(row, col)) {
			return 0;
		}
		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}

		int down = recursiveCookies(row, col + 1);
		int right = recursiveCookies(row + 1, col);
		int maximum = Math.max(down, right);
		if (maximum == -1) {
			return 0;
		}
		return cookieGrid[row][col] + maximum;
	}

	/*
	 * Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int queueCookies() {
		ArrayDeque<OrphanScout> orphans = new ArrayDeque<>();
		int max = 0;
		orphans.add(new OrphanScout(0, 0, cookieGrid[0][0]));
		while (!orphans.isEmpty()) {
			OrphanScout expendable = orphans.remove();
			max = Math.max(max, expendable.getCookiesDiscovered());
			if (validPoint(expendable.getEndingRow(), expendable.getEndingCol() + 1)) {
				orphans.add(new OrphanScout(expendable.getEndingRow(), expendable.getEndingCol() + 1,
						cookieGrid[expendable.getEndingRow()][expendable.getEndingCol() + 1]
								+ expendable.getCookiesDiscovered()));
			}
			if (validPoint(expendable.getEndingRow() + 1, expendable.getEndingCol())) {
				orphans.add(new OrphanScout(expendable.getEndingRow() + 1,
						expendable.getEndingCol(),
						cookieGrid[expendable.getEndingRow() + 1][expendable.getEndingCol()]
								+ expendable.getCookiesDiscovered()));
			}
		}
		return max;
	}

	/*
	 * Calculate which route grants the most cookies using a stack.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int stackCookies() {
		Stack<OrphanScout> orphans = new Stack<>();
		int max = 0;
		orphans.add(new OrphanScout(0, 0, cookieGrid[0][0]));
		while (!orphans.isEmpty()) {
			OrphanScout expendable = orphans.pop();
			max = Math.max(max, expendable.getCookiesDiscovered());
			if (validPoint(expendable.getEndingRow(), expendable.getEndingCol() + 1)) {
				orphans.push(new OrphanScout(expendable.getEndingRow(), expendable.getEndingCol() + 1,
						cookieGrid[expendable.getEndingRow()][expendable.getEndingCol() + 1]
								+ expendable.getCookiesDiscovered()));
			}
			if (validPoint(expendable.getEndingRow() + 1, expendable.getEndingCol())) {
				orphans.push(new OrphanScout(expendable.getEndingRow() + 1,
						expendable.getEndingCol(),
						cookieGrid[expendable.getEndingRow() + 1][expendable.getEndingCol()]
								+ expendable.getCookiesDiscovered()));
			}
		}
		return max;
	}

}
