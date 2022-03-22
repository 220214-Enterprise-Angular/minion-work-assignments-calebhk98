package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		// Apparently with large enough arrays, it stops printing to the console.
		int arraySize = 1000000;
		int[] test = new int[arraySize];
		Random rn = new Random();

		for (int i = 0; i < arraySize; i++) {
			test[i] = rn.nextInt(20);
		}
		System.out.println("Starting");
		int n = arraySize / 20;
		System.out.println(Arrays.toString(test));// Wh

		int[] result = solution(test, n);
		System.out.println("Done");
		System.out.println("Test size: " + result.length);
		System.out.println(" With a value of " + Arrays.toString(result));

	}

	/**
	 * Implement the method below, then right click on
	 * SolutionTests.java within src/test/java/ -> com.revature to test your code
	 * before committing and pushing to your repository.
	 */

	public static int[] solution(int[] data, int n) {

		HashMap<Integer, Integer> sums = new HashMap<>();
		List<Integer> answer = new ArrayList<>();
		for (int i : data) {
			sums.put(i, sums.getOrDefault(i, 0) + 1);
		}
		for (int i : data) {
			if (sums.get(i) <= n) {
				answer.add(i);
			}
		}
		return answer.stream().mapToInt(i -> i).toArray();

		// This works if the maximum is known. It is possibly faster than a HashMap
		/*
		 * int[] sums = new int[101];// If we have a maximum, this way is fast
		 * List<Integer> answer=new ArrayList<>(); for (int i : data) { sums[i] += 1; }
		 * for (int i : data) { if (sums[i] <= n) { answer.add(i); } } return
		 * answer.stream().mapToInt(i -> i).toArray();
		 */
	}

}
