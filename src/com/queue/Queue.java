package com.queue;

public class Queue<T> {
	
	String queue[]= new String[2000];
	int front;
	int rear;
	int size;
	T data;
	
	public void enqueue(T data){
		queue[rear]= (String) data;
		rear++;
		size++;
	}
	
	public String dequeue(){
		String a = queue[front];
		front++;
		size--;

		return a;

	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull(){
		return size == 100;
	}
	
	public void print() {
		if(front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		
		for(int i = front ; i < rear ; i++) {
			System.out.print(queue[i]+" ");
		}
	}

}
