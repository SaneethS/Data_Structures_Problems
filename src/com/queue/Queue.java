package com.queue;

public class Queue<T> {
	
	int queue[]= new int[100];
	int front;
	int rear;
	int size;
	
	public void enqueue(T data){
		queue[rear]=(int) data;
		rear++;
		size++;
	}
	
	public int dequeue(){
		int a = queue[front];
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

}
