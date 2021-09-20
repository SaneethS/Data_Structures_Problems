package com.datastructures;

import java.util.Scanner;

import com.deque.Deque;

public class PalindromeChecker {
	public static void palindromeChecker() {
		Deque<Character> deque = new Deque<>(20);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String");
		String string = scanner.nextLine();
		String front = "";
		String rear = "";

		
		for (int i = 0; i < string.length(); i++) {
			deque.insertRear(string.charAt(i));
		}
		for (int i = 0; i < string.length(); i++) {
			rear += deque.getRear();
			deque.deleteRear();
		}
		for (int i = 0; i < string.length(); i++) {
			deque.insertRear(string.charAt(i));
		}
		for (int i = 0; i < string.length(); i++) {
			front += deque.getFront();
			deque.deleteFront();
		}
		
		if (rear.equals(front)) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("String is not palindrome");
		}
		scanner.close();
	}
}
