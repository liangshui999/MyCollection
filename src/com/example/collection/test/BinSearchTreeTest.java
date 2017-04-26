package com.example.collection.test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.exam.collection.BinSearchTree;
import com.exam.collection.BinSearchTree.TreeIterator;

public class BinSearchTreeTest {

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
		BinSearchTree<Integer> tree = new BinSearchTree<>();
		
		assertEquals(0, tree.size());
		
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(7);
		assertEquals(5, tree.size());
		
		//测试加重复元素
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(7);
		assertEquals(5, tree.size());
		
		
		tree.add(10);
		assertEquals(6, tree.size());
		
	}

	@Test
	public void testIterator() {
		BinSearchTree<Integer> tree = new BinSearchTree<>();
		/*BinSearchTree.TreeIterator iterator = (TreeIterator) tree.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(iterator.next());*/
		
		
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(7);
		BinSearchTree.TreeIterator iterator = (TreeIterator) tree.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(iterator.next());
	}

	@Test
	public void testContainsObject() {
		BinSearchTree<Integer> tree = new BinSearchTree<>();
		assertEquals(false, tree.contains(5));
		
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(7);
		assertEquals(true, tree.contains(3));
		assertEquals(true, tree.contains(5));
		assertEquals(true, tree.contains(7));
		assertEquals(true, tree.contains(8));
		assertEquals(true, tree.contains(9));
	}

	@Test
	public void testAddE() {
		
	}

	@Test(expected=NoSuchElementException.class)
	public void testRemoveObject() {
		BinSearchTree<Integer> tree = new BinSearchTree<>();
		assertEquals(false, tree.remove(5));
		
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(8);
		tree.add(7);
		assertEquals(true, tree.remove(5));
		assertEquals(4, tree.size());
		
		tree.remove(3);
		tree.remove(3);
		tree.remove(3);
		assertEquals(3, tree.size());
		
		tree.remove(9);
		assertEquals(2, tree.size());
		
		assertEquals(false, tree.remove(10));
		assertEquals(false, tree.remove(99));
	}

}
