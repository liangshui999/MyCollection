package com.exam.collection;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Collection<E>{
	
	private Entity mHead;
	
	private Entity mCurrent;
	
	public MyLinkedList() {
		mCurrent = mHead;
	}

	@Override
	public boolean add(E e) {
		Entity entity = new Entity();
		entity.ele = e;
		if(mCurrent == null){
			mHead = entity;
			mCurrent = entity;
		}else{
			mCurrent.next = entity;
			mCurrent = entity;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		Entity current = mHead;
		while(current != null){
			E currentEle = current.ele;
			if(currentEle == null){
				return false;
			}
			if(currentEle.equals(o)){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return mHead == null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyLinkedIterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		int count = 0;
		Entity current = mHead;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	protected class Entity{
		E ele;
		Entity next;
	}
	
	private class MyLinkedIterator implements Iterator<E>{
		
		private Entity mNext;
		
		public MyLinkedIterator() {
			mNext = mHead;
		}

		@Override
		public boolean hasNext() {
			if(mNext == null){
				return false;
			}
			return mNext.next != null;
		}

		@Override
		public E next() {
			E ele = mNext.ele;
			mNext = mNext.next;
			return ele;
		}
		
	}
}
