package com.datastructures;

public class Prime2DArray {
	public static void prime2DArray() {
		 Prime2DArray prime2dArray = new Prime2DArray();
		 prime2dArray.prime();
	}
	
	/**
	 * this is the method used to create the array for the prime number
	 */
	public void prime() {
		int array[][] = new int[10][100];
		int prime[][] = new int[10][100];
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
		System.out.println("Prime numbers from 1 to 1000");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					System.out.print(prime[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}

	/**
	 * this method is used to check if the number in the array is prime number
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
}
