package com.example.collection.test;

import java.util.Arrays;

import com.example.sort.HeapSort;

public class HeapSortTest {

	public static void main(String[] args) {
		
		int[] arr = {59, 46, 32, 80, 14, 81, 95, 12, 17, 13,25};
		HeapSort heapSort = new HeapSort(arr);
		int[] result = heapSort.sort();
		System.out.println(Arrays.toString(result));

	}

}
