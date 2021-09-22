package com.queue;

public class Queue<T> {
	
	Node<T> front;
	Node<T> rear;
	int count = 0;

	@SuppressWarnings("hiding")
	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	
	public Queue() {
		this.front = null;
		this.rear = null;
	}

	
	public void enqueue(T item) {
		Node<T> temp = new Node<T>(item);
		if (rear == null) {
			front = temp;
			rear = temp;
			count++;
			return;
		}
		rear.next = temp;
		rear = temp;
		count++;
	}
	
	public void dequeue() {
		if(front == null)
			return;
		
		Node<T> temp = front;
		front = front.next;
		
		if(front == null) {
			rear = null;
		}
		
		
	}

	
	public void print() {
		Node<T> node = this.front;
		while (node.next != null) {
			System.out.println("Data :" + node.data);
			node = node.next;
		}
		System.out.print("Data :" + node.data);
	}
}
