package tddstack;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

public class TDDStack {
	
//	private boolean empty = true;
//	private int value;
	public static final int MAX_CAPACITY = 10;
	private int size = 0;
	private int[] contents = new int[MAX_CAPACITY];
	
	public boolean isEmpty() {
//		return empty;
		return size == 0;
	}
	
	public void push(int i) {
//		empty = false;
//		value = i;
//		size++;
		
		if(size == MAX_CAPACITY) {
			throw new BufferOverflowException();
		}
		
		contents[size++] = i;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
//		empty = true;
//		size--;
//		return value;
		return contents[--size];
	}

}
