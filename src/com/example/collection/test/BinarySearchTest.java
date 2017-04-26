package com.example.collection.test;

public class BinarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6};
		int result = search(arr, 2, 0, arr.length - 1);
		System.out.println(result);
	}
	
	
	/**
	 * 返回索引
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int search(int[] arr, int target, int start, int end){
		int index = -1;
		int center = (start + end) / 2;
		if(target > arr[center]){
			start = center + 1;
			index = search(arr, target, start, end);
		}else if(target < arr[center]){
			end = center - 1;
			index = search(arr, target, start, end);
		}else{
			index = center;
		}
		return index;
	}

}
