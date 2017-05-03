package com.example.sort;

import java.util.Arrays;

/**
 * 我自己写的归并排序算法
 * @author asus-cp
 *
 */
public class MergeSortMy {
	
	public int[] sort(int[] arr){	
		if(arr.length <= 1){
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}

	
	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int l = 0;
		int r = 0;
		int c = 0;
		while(l < left.length && r < right.length){
			if(left[l] < right[r]){
				result[c++] = left[l++];
			}else{
				result[c++] = right[r++];
			}
		}
		
		if(l == left.length){
			for(int j = r; j < right.length; j++){
				result[c++] = right[j];
			}
		}
		
		if(r == right.length){
			for(int j = l; j < left.length; j++){
				result[c++] = left[j];
			}
		}
		
		return result;
	}
}
