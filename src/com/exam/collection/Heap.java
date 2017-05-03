package com.exam.collection;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 这是一个使用堆实现的优先级队列
 * @author asus-cp
 *
 */
public class Heap {
	
	private static final int INIT_SIZE = 11;
	
	private Object[] mHeap;
	
	private int mSize;
	
	public Heap(){
		mHeap = new Object[INIT_SIZE];
	}
	
	public int size(){
		return mSize;
	}
	
	public boolean isEmpty(){
		return mSize == 0;
	}
	
	public void add(Object e){
		if(mSize + 1 > mHeap.length){
			Object[] temp = mHeap;
			mHeap = new Object[2 * mHeap.length];
			System.arraycopy(temp, 0, mHeap, 0, temp.length);
		}
		mHeap[mSize] = e;
		mSize++;
		
		adjustUp();
		
	}
	
	/**
	 * 从size-1向上调整(注意对相等元素的处理)
	 */
	private void adjustUp() {
		int childIndex = mSize - 1;
		int parentIndex = (childIndex - 1) / 2;
		while(childIndex > 0 && parentIndex > 0){
			if(compare(mHeap[childIndex], mHeap[parentIndex]) >= 0){
				break;
			}
			Object temp = mHeap[parentIndex];
			mHeap[parentIndex] = mHeap[childIndex];
			mHeap[childIndex] = temp;
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
	}

	private int compare(Object object, Object object2) {
		Comparable<Object> com1 = (Comparable<Object>) object;
		Comparable<Object> com2 = (Comparable<Object>) object2;
		return com1.compareTo(com2);
	}

	/**
	 * 获取优先级最高的元素
	 * @return
	 */
	public Object getMin(){
		if(isEmpty()){
			throw new NoSuchElementException("堆为空...");
		}
		return mHeap[0];
	}
	
	/**
	 * 删除优先级最高的元素
	 * @return
	 */
	public Object removeMin(){
		if(isEmpty()){
			throw new NoSuchElementException("堆为空...");
		}
		Object result = mHeap[0];
		mHeap[0] = mHeap[mSize-1];
		mHeap[mSize - 1] = result;
		mSize--;
		
		//从根元素开始往下调整
		adjustDown(0);
		
		return result;
	}

	/**
	 * 从指定的元素开始往下调整(注意对相等元素的处理)
	 * @param i
	 */
	private void adjustDown(int i) {
		int parent = i;
		int child = 2 * parent + 1;
		while(parent < mSize && child < mSize){
			if(child < mSize - 1 && compare(mHeap[child], mHeap[child + 1]) > 0){ //选出2个孩子里面较小的一个
				child++;
			}
			if(compare(mHeap[child], mHeap[parent]) >= 0){
				break;
			}
			Object temp = mHeap[child];
			mHeap[child] = mHeap[parent];
			mHeap[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}	
	}
	
	public void print(){
		System.out.println(Arrays.toString(mHeap));
	}

}
