package tddstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class StackTests {

	@Test
	public void newlyCreatedStackEmpty() {
		TDDStack s = new TDDStack();

		assertTrue(s.isEmpty());
	}

	@Test
	public void afterPushStacknoEmpty() {
		TDDStack s = new TDDStack();

		s.push(1);
		assertFalse(s.isEmpty());
	}

	@Test
	public void afterPushAnsPopStackEmpty() {
		TDDStack s = new TDDStack();

		s.push(1);
		s.pop();
		assertTrue(s.isEmpty());
	}

	@Test
	public void emptyStackThrowsOnPop() {
		TDDStack s = new TDDStack();

		assertThrows(EmptyStackException.class, () -> s.pop());

	}

	@Test
	public void popReturnsWhatWasPushed() {
		TDDStack s = new TDDStack();

		s.push(67);
		assertEquals(67, s.pop());
	}

	@Test
	public void stackNotEmptyWhenLessPopThanPush() {
		TDDStack s = new TDDStack();
		s.push(67);
		s.push(6);
		s.pop();

		assertFalse(s.isEmpty());
	}

	@Test
	public void lastPopReturnsFirstPushValue() {
		TDDStack s = new TDDStack();
		s.push(67);
		s.push(6);
		s.pop();
		assertEquals(67, s.pop());
	}

	@Test
	public void stackThrowsWhenCapacityExceeded() {
		TDDStack s = new TDDStack();

		assertThrows(BufferOverflowException.class, 
			() -> {
			for (int i = 0; i < TDDStack.MAX_CAPACITY + 1; ++i)
				s.push(i);
		});
	}

}
