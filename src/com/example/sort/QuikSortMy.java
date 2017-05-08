package com.example.sort;


public class QuikSortMy {
	
	/**
	 * 我这边是这样设计的，左边都小于等于key，右边大于key
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void sort(int[] arr, int low, int high){
		int start = low;
		int end = high;
		int key = arr[low];//key选择的是start，所以右边的先开始走
		
		while(start < end){
			
			//先从右边走起
			while(start < end && arr[end] >= key){
				end--;
			}
			if(arr[end] < key){
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			
			//再从左边走起
			while(start < end && arr[start] <= key){
				start++;
			}
			if(arr[start] > key){
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			
		}
		
		System.out.println("start = " + start + "....." + "end = " + end);
		
		//注意，下面的2个判断条件必须得加，否则就会出错
		if(start > low) sort(arr, low, start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end < high) sort(arr, end+1, high);//右边序列。从关键值索引+1到最后一个
	}

}
