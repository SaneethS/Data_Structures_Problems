package com.stack;

public class Stack {
	char data[];
	int top = 0;

	public Stack(){
		data =  new char[100];
	}

	public void push(char a) {
		data[top] = a;
		top++;
	}

	public char pop() {
		top--;
		char b = data[top];
		return b;
	}

	public char peek() {
		char c = data[top-1];
		return c;

	}

	public boolean isEmpty(){
		if(top == 0)
			return true;
		return false;
	}

	public int size() {
		return top;
	}
}

