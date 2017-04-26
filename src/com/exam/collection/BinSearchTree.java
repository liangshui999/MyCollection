package com.exam.collection;

import java.awt.Robot;
import java.beans.DefaultPersistenceDelegate;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * 自定义的二叉搜索树
 * @author asus-cp
 *
 */
public class BinSearchTree<E> extends AbstractSet<E>{
	
	private Entry<E> root;
	
	private int size;
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		
		return new TreeIterator();
	}

	
	
	@Override
	public boolean contains(Object o) {
		if(root == null){
			return false;
		}
		Comparable<E> com = (Comparable<E>) o;
		Entry<E> temp = root;
		while(temp != null){
			if(com.compareTo(temp.element) == 0){
				return true;
			}else if(com.compareTo(temp.element) < 0){
				temp = temp.left;
			}else if(com.compareTo(temp.element) > 0){
				temp = temp.right;
			}
		}
		return false;
	}
	
	
	@Override
	public boolean add(E e) {
		Entry<E> entry = new Entry<E>(e);
		if(root == null){
			entry.parent =null;
			root = entry;
			size++;
			return true;
		}
		
		Comparable<E> com = (Comparable<E>) e;
		Entry<E> temp = root;
		while(temp != null){
			if(com.compareTo(temp.element) == 0){ //说明树里面已经有了这个元素，不容许再次插入
				return false;
			}else if(com.compareTo(temp.element) < 0){ //要插入的元素在temp的左边
				if(temp.left == null){
					temp.left = entry;
					entry.parent = temp;
					size++;
					return true;
				}else{
					temp = temp.left;
				}	
			}else if(com.compareTo(temp.element) > 0){ //要插入的元素在temp的右边
				if(temp.right == null){
					temp.right = entry;
					entry.parent = temp;
					size++;
					return true;
				}else{
					temp = temp.right;
				}
			}
		}
		return false;
		
	}
	
	
	@Override
	public boolean remove(Object o) {
		if(root == null){
			throw new NoSuchElementException("没有这个元素");
		}
		
		Comparable<E> com = (Comparable<E>) o;
		Entry<E> temp = root;
		while(temp != null){
			if(com.compareTo(temp.element) == 0){
				delete(temp);
				return true;
			}else if(com.compareTo(temp.element) < 0){
				temp = temp.left;
			}else if(com.compareTo(temp.element) > 0){
				temp = temp.right;
			}
		}
		return false;	
	}
	
	
	/**
	 * 删除某个元素
	 * @param o
	 * @return
	 */
	private void delete(Entry<E> entry) {
		if(entry.left == null && entry.right == null){ //是叶子结点的情况
			deleteEntryHaveNoChild(entry);
		}else if(entry.left != null && entry.right != null){ //既有左结点，又有右结点的情况
			Entry<E> behindE = getBehindEntry(entry);
			entry.element = behindE.element;
			deleteEntryHaveOnlyOneChild(behindE);
			
		}else{ //只有一个左结点或者只有一个右结点的情况
			deleteEntryHaveOnlyOneChild(entry);
		}
		
	}

	
	/**
	 * 删除只有一个孩子的结点
	 * @param entry
	 */
	private void deleteEntryHaveOnlyOneChild(Entry<E> entry) {
		if(entry.parent == null){
			if(entry.left != null){
				root = entry.left;
			}else{
				root = entry.right;
			}
		}else{
			if(entry.left != null){
				entry.parent.left = entry.left;
			}else{
				entry.parent.right = entry.right;
			}
		}
	}

	
	/**
	 * 删除叶子结点
	 * @param entry
	 */
	private void deleteEntryHaveNoChild(Entry<E> entry) {
		if(entry.parent == null){
			root = null;
		}else{
			if(entry.parent.left == entry){
				entry.parent.left = null;
			}else if(entry.parent.right == entry){
				entry.parent.right = null;
			}
		}
	}


	/**
	 * 获取后面的结点
	 * @param entry
	 * @return
	 */
	private Entry<E> getBehindEntry(Entry<E> entry) {
		Entry<E> temp;
		if(entry != null && entry.right != null){ //有右分支
			temp = entry.right;
			while(temp.left != null){
				temp = temp.left;
			}
			return temp;
		}else{ //没有右分支的情况
			if(entry == null){
				return null;
			}
			if(entry.parent == null){
				return null;
			}else{
				temp = entry;
				Entry<E> parent = temp.parent;
				while(parent != null && parent.right == temp){
					temp = parent;
					parent = temp.parent;
				}
				return parent;
			}
		}
	}


	public class TreeIterator implements Iterator<E>{
		
		private Entry<E> mNext;
		
		public TreeIterator(){
			if(root != null){
				mNext = root;
				while(mNext.left != null){
					mNext = mNext.left;
				}
			}
		}

		@Override
		public boolean hasNext() {
			if(getBehindEntry(mNext) == null){
				return false;
			}
			return true;
		}

		@Override
		public E next() {
			if(mNext == null){
				return null;
			}
			E e = mNext.element;
			mNext = getBehindEntry(mNext);
			return e;
		}
		
		@Override
		public void remove() {
			Entry<E> temp = mNext;
			mNext = getBehindEntry(mNext);
			BinSearchTree.this.remove(temp.element);
		}
		
	}
	
	
	private static class Entry<E>{
		
		E element;
		
		Entry<E> parent;
		
		Entry<E> left;
		
		Entry<E> right;
		
		public Entry(E ele){
			this.element = ele;
		}
	}
	
}
