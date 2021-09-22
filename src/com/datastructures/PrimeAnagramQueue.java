package com.datastructures;

import java.util.Arrays;

import com.queue.Queue;

public class PrimeAnagramQueue {
	public static void primeAnagramQueue() {
		PrimeAnagramQueue primeAnagramQueue = new PrimeAnagramQueue();
		primeAnagramQueue.queuePrimeAnagram();
	}
	
	/**
	 * method used to create a queue for prime anagram
	 */
	public void queuePrimeAnagram() {
		Queue<String> queue = new Queue<String>();
		String[] primeNo = prime(1000);
		
		for(int i = 0 ; i < primeNo.length ; i++ ) {
			for(int j = i+1 ; j < primeNo.length ; j++ ) {
				if(anagram(primeNo[i], primeNo[j])) {
					queue.enqueue(primeNo[i]);
					queue.enqueue(primeNo[j]);
				}
			}
		}
		queue.print();
	}

	/**
	 * method to find the anagram of numbers
	 * @param string1
	 * @param string2
	 * @return
	 */
	private boolean anagram(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * method to find the prime number
	 * @param n
	 * @return
	 */
	private String[] prime(int n) {
		int pos = 0;
		String[] array = new String[1000];
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if ((i % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				array[pos] = String.valueOf(i);
				pos++;

			}
		}
		String[] returnArray = new String[pos];
		for (int k = 0; k < pos ; k++) {
			returnArray[k] = array[k];
		}
		return returnArray;
	}
}
