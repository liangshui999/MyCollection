package com.example.collection.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.exam.collection.Heap;

public class HeapTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		Heap heap = new Heap();
		assertEquals(0, heap.size());
		heap.add(11);
		assertEquals(1, heap.size());
		heap.add(10);
		heap.add(9);
		heap.add(8);
		heap.add(7);
		assertEquals(5, heap.size());
		//heap.print();
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMin() {
		Heap heap = new Heap();
		heap.add(15);
		heap.add(14);
		heap.add(13);
		heap.add(12);
		heap.add(11);
		heap.add(10);
		heap.add(9);
		heap.add(8);
		heap.add(7);
		heap.add(6);
		//heap.print();
	}

	@Test
	public void testRemoveMin() {
		Heap heap = new Heap();
		heap.add(15);
		heap.add(14);
		heap.add(13);
		heap.add(12);
		heap.add(11);
		heap.add(10);
		heap.add(9);
		heap.add(8);
		heap.add(7);
		heap.add(6);
		heap.removeMin();
		heap.removeMin();
		heap.print();
	}

}
