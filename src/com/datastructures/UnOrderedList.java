package com.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author saneeths
 *class where the unordered list is created where the input is taken from
 *text file
 */
public class UnOrderedList {
	Node head;
	
	public static void unOrderedList() {
		UnOrderedList unOrderedList = new UnOrderedList();
		
		unOrderedList.read();
		unOrderedList.getInput();
		unOrderedList.print();
		unOrderedList.write();
	}
	
	private class Node<T>{
		T data;
		Node next;

		Node(T data){
			this.data=data;
			next=null;
		}
	}
	
	/**
	 * method which is used to read the file
	 * @param <T>
	 */
	public <T> void read() {
		try {
			Scanner file = new Scanner(new File("data/list.txt"));
			String str = "";
			
			while(file.hasNext()) {
				str = str + file.next() + " ";
			}
			T[] array =(T[]) str.split(" ");
			
			for(T t: array) {
				add(t);
			}
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method used to add the element to the node
	 * @param <T>
	 * @param data
	 */
	public <T> void add(T data) {

		Node newNode = new Node(data);

		if(head==null)
			head=newNode;
		else {
			Node temp;
			temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}
	
	
	/**
	 * method used to display the contents of list
	 * @param <T>
	 */
	public <T> void print() {
		Node temp= head;
		while(temp.next!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	
	/**
	 * method used to get the user input
	 * @param <T>
	 */
	public  <T> void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter word to search:");
		T input=(T) scanner.next();
		search(input);

	}
	
	/**
	 * method used to search and remove given input
	 * @param <T>
	 * @param input
	 */
	private <T> void search(T input) {
		Node temp;
		temp=head;
		while(temp!=null) {
			if(temp.data.equals(input)) {
				remove(input);
				break;
			}
			else {
				temp=temp.next;
			}
		}
		if(temp==null) {
			add(input);
		}
	}
	
	/**
	 *method which is used in search method to remove node
	 * @param <T>
	 * @param input
	 */
	private <T> void remove(T input) {
		if(input.equals(head.data)) { //Removing the first element
			head=head.next;
			return;
		}
		Node temp=head.next;
		Node prev=head;
		while(temp!=null) {
			if(temp.data.equals(input)) {
				if(temp.next==null) {
					temp=temp.next;
					prev.next=null;
				}
				else {
					prev.next=temp.next;

					temp=temp.next;
				}
			}
			else {
				prev=temp;
				temp=temp.next;
			}
		}
	}
	
	/**
	 * method used to write result to output file
	 */
	public void write() {
		try {
			Writer writer = new FileWriter("data/listResult.txt");
			Node temp;
			temp=head;
			while(temp.next!=null) {
				writer.write(temp.data+" ");
				temp=temp.next;
			}
			writer.write(temp.data+" ");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
