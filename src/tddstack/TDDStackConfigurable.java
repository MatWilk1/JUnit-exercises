package tddstack;

import java.lang.reflect.Array;
import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.zip.DataFormatException;

public class TDDStackConfigurable {

	public static int capacity = 10;
	private int size = 0;
	private int[] contents = new int[capacity];

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {

		if (size == capacity) {
			throw new BufferOverflowException();
		}

		contents[size++] = i;
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return contents[--size];
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		for (int i = 0; i < capacity; i++) {
			contents[i] = 0;
		}
		size = 0;
	}

//	// inny sposób czyszczenia przez utworzenie nowego stosu
//	public void clear() {
//		contents = new int[MAX_CAPACITY];
//		size = 0;
//	}

	public int[] getContents() {
		return contents;
	}

//	public int getCapacity() {
//		return capacity;
//	}

	public void fillFullContents() {
		for (int i = 0; i < contents.length; i++) {
			push(i + 10);
		}
	}

	public void setCapacity(int capacity) {

		if (capacity < this.capacity) {
			System.out.println("Zmniejszyłeś stos, część danych została usunięta");
			size = capacity;
		}

		this.capacity = capacity;
		contents = Arrays.copyOf(contents, capacity);

	}

}
