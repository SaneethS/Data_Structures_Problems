package com.deque;

public class Deque<T> {
	Object[] deque;
	int front;
	int rear;
	int size;

	public Deque(int size) {
		deque = new Object[size];
		front = -1;
		rear = 0;
		this.size = size;
	}

	public void insertFront(T data) {

		if (isFull()) {
			System.out.println("is full");
			return;
		} else {
			if (front == -1) {
				front = 0;
				rear = 0;
			} else if (front == 0)
				front = size - 1;
			else
				front = front - 1;

			deque[front] = data;
			size++;
		}

	}

	public void insertRear(T data) {
		if (isFull()) {
			System.out.println(" is full ");
			return;
		} else {
			if (front == -1) {
				front = 0;
				rear = 0;
			} else if (rear == size - 1)
				rear = 0;
			else
				rear = rear + 1;
			deque[rear] = data;
			size++;
		}
	}

	public void deleteFront() {

		if (isEmpty()) {
			System.out.println("is empty\n");
			return;
		} else {
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				if (front == size - 1)
					front = 0;
				else
					front = front + 1;
			}
		}
		size--;

	}

	public void deleteRear() {
		if (isEmpty()) {
			System.out.println(" is empty");
			return;
		} else {
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (rear == 0)
				rear = size - 1;
			else
				rear = rear - 1;
		}
		size--;
	}

	@SuppressWarnings("unchecked")
	public T getFront() {

		if (isEmpty()) {
			System.out.println(" is empty");

		}
		return (T) deque[front];
	}

	@SuppressWarnings("unchecked")
	public T getRear() {
		if (isEmpty() || rear < 0) {
			System.out.println(" is Empty");
		}
		return (T) deque[rear];
	}

	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	public boolean isEmpty() {
		if (rear == 0)
			return true;
		else if (front == -1)
			return true;
		return false;
	}
}
