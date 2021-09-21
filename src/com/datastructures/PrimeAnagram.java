package com.datastructures;

import java.util.Arrays;

public class PrimeAnagram {
	private int array[][] = new int[10][100];
	private int prime[][] = new int[10][100];
	private int anagrams[][] = new int[10][100];
	private int nonAnagrams[][] = new int[10][100];
	
	public static void primeAnagram() {
		PrimeAnagram primeAnagram = new PrimeAnagram();
		primeAnagram.prime();
		primeAnagram.isAnagram();
		primeAnagram.print();
	}
	
	/**
	 * this method is to get the array of prime numbers
	 */
	public void prime() {
	
		int temp = 1;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = temp;
				temp++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (checkPrimeNo(array[i][j])) {
					prime[i][j] = array[i][j];
				} else {
					prime[i][j] = 0;
				}
			}
		}
		
	}
	
	/**
	 * this method is used to check for the prime numbers in array
	 * @param n
	 * @return
	 */
	private boolean checkPrimeNo(int n) {
		boolean flag = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * this method is used to get the anagrams
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean anagram(String string1, String string2) {
		if(string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);

		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * this method is used to check wheter its anagram or not
	 */
	public void isAnagram() {
		for(int i = 0 ; i<10 ; i++) {
			for(int j = 0 ; j<100;j++) {
				if(prime[i][j]!=0) {
					for(int k = j+1 ; k <100;k++ ) {
						if(prime[i][k]!=0&& anagram(String.valueOf(prime[i][j]),String.valueOf(prime[i][k]))) {
							anagrams[i][j]=prime[i][j];
							anagrams[i][k]=prime[i][k];
						}
					}
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if(prime[i][j]!=anagrams[i][j]) {
					nonAnagrams[i][j]=prime[i][j];
				}
			}
		}
	}
	
	/**
	 * this method is used to display the anagram prime numbers
	 */
	public void print() {
		System.out.println("Prime Number Anangrams are:");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (anagrams[i][j] != 0) {
					System.out.print(anagrams[i][j] + " ");
				}
			}
			System.out.println();
		}

	}
	
}
