package com.exam.collection;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	
	private MyLinkedList<Integer> itList;

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		itList = new MyLinkedList<>();
	}

	@Test
	public void testAdd() {
		itList.add(1);
		itList.add(2);
		itList.add(3);
		assertEquals(3, itList.size());
		
	}

	@Test
	public void testContains() {
		itList.add(5);
		assertTrue(itList.contains(5));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(itList.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, itList.size());
	}
	
	@Test
	public void testIterator(){
		itList.add(1);
		itList.add(2);
		itList.add(3);
		itList.add(4);
		itList.add(5);
		Iterator<Integer> iterator = itList.iterator();
		int i = 1;
		while(iterator.hasNext()){
			int a1 = iterator.next();
			assertEquals(i, a1);
			i++;
		}
		
	}

}
