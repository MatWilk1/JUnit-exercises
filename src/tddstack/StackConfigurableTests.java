package tddstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class StackConfigurableTests {

	@AfterEach
	public void tearDown() throws Exception {
		TDDStackConfigurable.capacity = 10;
	}
	
	@Test
	public void newlyCreatedStackEmpty() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		assertTrue(s.isEmpty());
	}

	@Test
	public void afterPushStacknoEmpty() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		s.push(1);
		assertFalse(s.isEmpty());
	}

	@Test
	public void afterPushAnsPopStackEmpty() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		s.push(1);
		s.pop();
		assertTrue(s.isEmpty());
	}

	@Test
	public void emptyStackThrowsOnPop() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		assertThrows(EmptyStackException.class, () -> s.pop());

	}

	@Test
	public void popReturnsWhatWasPushed() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		s.push(67);
		assertEquals(67, s.pop());
	}

	@Test
	public void stackNotEmptyWhenLessPopThanPush() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.push(67);
		s.push(6);
		s.pop();

		assertFalse(s.isEmpty());
	}

	@Test
	public void lastPopReturnsFirstPushValue() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.push(67);
		s.push(6);
		s.pop();
		assertEquals(67, s.pop());
	}

	@Test
	public void stackThrowsWhenCapacityExceeded() {
		TDDStackConfigurable s = new TDDStackConfigurable();

		assertThrows(BufferOverflowException.class, 
			() -> {
			for (int i = 0; i < TDDStackConfigurable.capacity + 1; ++i)
				s.push(i);
		});
	}
	
	@Test
	public void stackGetSizeTest() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.push(2);
		s.push(12);
		s.push(45);
		
		assertEquals(3, s.getSize());
		
	}
	
	@Test
	public void stackFillFullContentsFirst() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		assertEquals(10, s.getContents()[0]);
	}
	
	@Test
	public void stackFillFullContentsMiddle() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		assertEquals(14, s.getContents()[4]);
	}
	
	@Test
	public void stackFillFullContentsLast() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		assertEquals(19, s.getContents()[TDDStackConfigurable.capacity - 1]);
	}
	
	
	@Test
	public void stackClearSize() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.clear();
		assertEquals(0, s.getSize());
	}
	
	@Test
	public void stackClearFirst() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.clear();
		assertEquals(0, s.getContents()[0]);
	}
	
	@Test
	public void stackClearMiddle() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.clear();
		assertEquals(0, s.getContents()[4]);
	}
	
	@Test
	public void stackClearLast() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.clear();
		assertEquals(0, s.getContents()[TDDStackConfigurable.capacity - 1]);
	}
	
	@Test
	public void stackIncreaseLengthTest() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(15);
		
		assertEquals(15, s.getContents().length);
		
	}
	
	@Test
	public void stackIncreaseFirstTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(15);
		
		assertEquals(10, s.getContents()[0]);
		
	}
	
	@Test
	public void stackIncreaseMiddleTest() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(15);
		
		assertEquals(17, s.getContents()[7]);
		
	}
	
	@Test
	public void stackIncreaseLastTest() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(15);
		
		assertEquals(0, s.getContents()[s.getContents().length-1]);
		
	}
	
	@Test
	public void stackDecreaseLengthTest() {
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(5);
		
		assertEquals(5, s.getContents().length);
		
	}
	
	@Test
	public void stackDecreaseFirstTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(5);
		
		assertEquals(10, s.getContents()[0]);
		
	}
	
	@Test
	public void stackDecreaseMiddleTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(5);
		
		assertEquals(12, s.getContents()[2]);
		
	}
	
	@Test
	public void stackDecreaseLastTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(5);
		
		assertEquals(14, s.getContents()[s.getContents().length-1]);
		
	}
	
	@Test
	public void stackIncreaseSizeValueTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(15);
		s.getSize();

		assertEquals(10, s.getSize());
		
	}
	
	@Test
	public void stackDecreaseSizeValueTest(){
		TDDStackConfigurable s = new TDDStackConfigurable();
		s.fillFullContents();
		s.setCapacity(5);
		s.getSize();

		assertEquals(5, s.getSize());
		
	}

}
