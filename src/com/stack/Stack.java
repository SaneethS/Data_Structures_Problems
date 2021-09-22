package com.stack;


public class Stack<T> {
	Node<T> head;
	int count = 0;

	@SuppressWarnings("hiding")
	class Node<T> {
		public T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	public Stack() {
		this.head = null;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.next = head;
		head = node;
		count++;
	}

	public void pop() {
		if (head == null) {
			System.out.println("Stack UnderFlow");
			return;
		}
		Node<T> temp = head;
		head = temp.next;
		temp = null;
		count--;
	}

	public T peek() {
		if (head == null) {
			System.out.println("no data present");
		}
		T temp = head.data;
		return temp;
	}

	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	public int size() {
		return count;
	}

	public void print() {
		Node<T> temp = head;
		
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}