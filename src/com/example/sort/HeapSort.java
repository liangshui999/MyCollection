package com.example.sort;

import javax.swing.text.AsyncBoxView.ChildLocator;

/**
 * 我自己的堆排序
 * @author asus-cp
 *
 */
public class HeapSort {
	
	private int mSize;
	
	private int[] arr;
	
	
	public HeapSort(int[] arr) {
		super();
		this.arr = arr;
		this.mSize = arr.length;
	}
	
	public int[] sort(){
		int cl = arr.length / 2 - 1; //等同于（arr.lengh - 1 - 1）/2,最后一个元素的父节点
		for(; cl >= 0; cl--){
			adjustDown(cl);
		}
		for(int i = 0; i < arr.length; i++){
			removeMin();
		}
		
		int[] tempArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			tempArr[i] = arr[arr.length - 1 - i];
		}
		return tempArr;
	}


	/**
	 * 向下调整
	 */
	private void adjustDown(int i){
		int parent = i;
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;
		int minChild = 0;
		while(true){
			if(leftChild < mSize && rightChild < mSize){ //说明既有左孩子，又有右孩子
				if(arr[leftChild] < arr[rightChild]){
					minChild = leftChild;
				}else{
					minChild = rightChild;
				}
			}else if(leftChild < mSize){ //说明只有左孩子
				minChild = leftChild;
			}else{	//说明既无左孩子，也没有右孩子
				break;
			}
			
			if(arr[parent] > arr[minChild]){
				int temp = arr[parent];
			    arr[parent] = arr[minChild];
			    arr[minChild] = temp;
			}
		    parent = minChild;
		    leftChild = 2 * parent + 1;
			rightChild = 2 * parent + 2;
		}
	}
	
	
	/**
	 * 移除优先级最高的
	 */
	private void removeMin(){
		int temp = arr[0];
		arr[0] = arr[mSize - 1];
		arr[mSize - 1] = temp;
		mSize--;
		adjustDown(0);
	}
}
