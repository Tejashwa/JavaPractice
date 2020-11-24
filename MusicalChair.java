import java.io.IOException;

/* Problem Name is &&& Election &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/**
 * Instructions to candidate. 1) Run this code in the REPL to observe its
 * behaviour. The execution entry point is main(). 2) Consider adding some
 * additional tests in doTestsPass(). 3) Implement whoIsElected() correctly. 4)
 * If time permits, try to improve your implementation.
 */

public class MusicalChair {

	/**
	 * A group of students are sitting in a circle. The teacher is electing a new
	 * class president. The teacher does this by singing a song while walking around
	 * the circle. After the song is finished the student at which the teacher
	 * stopped is removed from the circle.
	 * 
	 * Starting at the student next to the one that was just removed, the teacher
	 * resumes singing and walking around the circle. After the teacher is done
	 * singing, the next student is removed. The teacher repeats this until only one
	 * student is left.
	 *
	 * A song of length k will result in the teacher walking past k students on each
	 * round. The students are numbered 1 to n. The teacher starts at student 1.
	 * 
	 * For example, suppose the song length is two (k=2). And there are four
	 * students to start with (1,2,3,4). The first student to go would be `2`, after
	 * that `4`, and after that `3`. Student `1` would be the next president in this
	 * example.
	 *
	 * @param n the number of students sitting in a circle.
	 * @param k the length (in students) of each song.
	 * @return the number of the student that is elected.
	 */
	public static int whoIsElected(int n, int k) {
		// todo: implement here
		int students[] = new int[n];
		int j = 1;
		int i = 0;
		int counter = 0;
		while (counter < n - 1) {
			if (students[i] != -1 && j == k) {
				students[i] = -1;
				counter++;
				j = 1;
			} else if (students[i] != -1) {
				j++;
			}
			if (i == n - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		for (int l = 0; l <= n - 1; l++) {
			if (students[l] != -1) {
				return l + 1;
			}
		}
		return 1;
	}

	/**
	 * bool doTestsPass() Runs various tests. Returns true if tests pass. Otherwise,
	 * returns false.
	 */
	public static boolean doTestsPass() {
		// todo: implement more tests, please
		// feel free to make testing more elegant
		// test cases are structered as {n, k, expected answer}

		// 1 2 3 4 5 6
		// k = 2

		// 1 3 5
		// 1 5
		// 5

		int[][] testCases = {
				{3, 10, 2},
		        {2, 2, 1},
		        {4, 2, 1},
		        {100, 2, 73},
		        {11, 3, 7},
				{ 10, 3, 4 } };

		for (int[] testCase : testCases) {
			int answer = whoIsElected(testCase[0], testCase[1]);
			System.out.println(answer);
			if (answer != testCase[2]) {
				System.out.println("test failed!");
				System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer,
						testCase[2]);
				return false;
			}
		}
		System.out.println("All tested passed");
		return true;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String args[]) {
		doTestsPass();
	}
}