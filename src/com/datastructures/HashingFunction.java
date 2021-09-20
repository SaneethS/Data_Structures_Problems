package com.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HashingFunction<T> {
	Node<T>[] array=new Node[20];
	Node<T> next;
	
	public static void hashingFunction() {
		HashingFunction<Integer> hashingFunction = new HashingFunction<>();
		try {
			Scanner file = new Scanner(new File("data/hashing.txt"));
			String str = "";
			while (file.hasNextLine()) {
				str = str + file.nextLine();
			}
			System.out.println(str);
			file.close();
			String[] arr = str.split(" ");// to split the string array
			int[] arr2 = new int[arr.length];

			// for converting any String type in file to integer type
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i]);
			}
			for (int i : arr2) {
				hashingFunction.add(i);
				
			}
			hashingFunction.write();
			hashingFunction.print();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	class Node<T>{
		T data;
		Node next;

		Node(T data){
			this.data=data;
			next=null;
		}
	}
	
	public void add(int data) {
		Node<T> new_Node = new Node(data);
		int index = data % 11;
		if (array[index] == null) {
			array[index] = new_Node;
		}
		else
		{
			Node<T> temp = array[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_Node;
		}
	}
	
	public void print() {
		System.out.println("Remainder " + "values:-");
		for (int i = 0; i < array.length; i++) {
			Node<T> temp = array[i];
			if (temp != null) {
				System.out.print(" [" + i + "]      ");
				while (temp != null) {
					System.out.print(temp.data + "  ");
					temp = temp.next;
				}
				System.out.println();
			}
		}
	}
	
	public void write() {
		try {
			FileWriter fWriter = new FileWriter("data/hashingResult.txt");

			String text="";
			text="Remainder " + "values:-\n";
			fWriter.write(text);

			for (int i = 0; i < array.length; i++) {
				text="";
				Node<T> temp = array[i];
				if (temp != null) {
					text=" [" + i + "] ->{";
					while (temp != null) {
						text=text+temp.data+ " ";
						temp = temp.next;
					}
					text=text+"}\n";
					fWriter.write(text);
				}
				else if(temp==null) {
					text=" [" + i + "] ->\n";
					fWriter.write(text);
				}
			}

			fWriter.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
