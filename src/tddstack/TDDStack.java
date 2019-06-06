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

	public int getSize() {
		return size;
	}

	public void clear() {
		for (int i = 0; i < MAX_CAPACITY; i++) {
			contents[i] = 0;
		}
		size = 0;
	}

	public int[] getContents() {
		return contents;
	}
	
	public void fillFullContents() {
		for(int i = 0; i < MAX_CAPACITY; i++) {
			contents[i] = i + 10;
		}
	}

}
