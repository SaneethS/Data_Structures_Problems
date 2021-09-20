package com.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedList {
	Node head;
	static Scanner scanner = new Scanner(System.in);
	
	public static void orderedList() {
		OrderedList orderedList = new OrderedList(); 
		
		try {
			Scanner file = new Scanner(new File("data/orderedList.txt"));
			String str = "";
			while (file.hasNextLine()) {
				str = str + file.nextLine();;
			}
			file.close();
			String[] arr = str.split(" ");// to split the string array
			Integer[] array = new Integer[arr.length];
			for (int i = 0; i < arr.length; i++) {
				array[i] = Integer.parseInt(arr[i]);
			}
			System.out.println(array.getClass());
			orderedList.bubbleSort(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the element");
		Integer user=scanner.nextInt();
		boolean b = orderedList.search(user);
		if(b) {
			orderedList.add(user);
		}
		

		orderedList.write();
		orderedList.print();
	}
	
	private class Node<T extends Comparable<T>> {
		T data;
		Node next;

		Node(T data){
			this.data = data;
			next = null;
		}
	}
	
	public <T extends Comparable<T>>int getSize() {
		int count = 0;
		if(head == null) {
			return 0;
		}
		else {

			Node<T> temp = head;
			while(temp != null) {
				count++;
				temp = temp.next;

			}
		}
		return count;
	}
	
	private <T extends Comparable<T>> void addNormal(T input) {
		Node newNode = new Node(input);

		if(head == null)
			head = newNode;
		else {
			Node temp;
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	public <T extends Comparable<T>>void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(head == null || head.data.compareTo(data)>0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			Node<T> temp = head;
			while(temp.next != null && temp.next.data.compareTo(data)<0) {
				temp = temp.next;

			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
	
	public <T extends Comparable<T>>void pop(T input) {


		if(input.equals(head.data)) { 
			head=head.next;
			return;
		}
		Node temp = head.next;
		Node q = head;
		while(temp != null) {


			if(temp.data.equals(input)) {
				if(temp.next == null) {
					temp = temp.next;
					q.next = null;
				}
				else {
					q.next = temp.next;

					temp = temp.next;
				}
			}
			else {
				q = temp;
				temp = temp.next;
			}
		}

	}
	
	public <T extends Comparable<T>>boolean search(T input) {
		boolean flag=true;
		Node temp;
		temp = head;
		while(temp != null) {
			if(temp.data.equals(input)) {

				flag = false;
				pop(input);

				break;
			}
			else {
				temp = temp.next;
			}
		}
		return flag;
	}
	
	public <T extends Comparable<T>>void print() {
		Node temp = head;
		while(temp.next != null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	
	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {

		int len=a.length;
		T temp;

		for(int i = 0;i < len-1;i++) {
			for(int j = 0;j < len-1-i;j++) {
				if(a[j].compareTo(a[j+1])>0) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (T t : a) {
			addNormal(t);
		}

		System.out.println("Sorted array");
		printArray(a);
		return a;
	}
	
	public static <T extends Comparable<T>> void printArray(T[] a) {
		for (T t : a) {
			System.out.print(t+" ");
		}
		System.out.println();
	}
	
	public static <T extends Comparable<T>> T userInput() {

		T key = (T)scanner.next();
		return key;
	}
	
	public void write() {
		try {
			FileWriter writer = new FileWriter("data/orderedListResult.txt");
			String text = "";

			Node temp;
			temp = head;
			while(temp.next!=null) {
				text = text+temp.data+" ";
				temp = temp.next;
			}
			text = text + temp.data;
			writer.write(text);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
