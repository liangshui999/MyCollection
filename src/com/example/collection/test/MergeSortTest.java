package com.example.collection.test;

import java.util.Arrays;
import java.util.Random;

import com.example.sort.MergeSort;
import com.example.sort.MergeSortMy;

public class MergeSortTest {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		//MergeSort mergeSort = new MergeSort();
		MergeSortMy mergeSort = new MergeSortMy();
		int[] arr = new int[1024];
		for(int i = 0; i < arr.length; i++){
			arr[i] = random.nextInt(100000);
		}
		long time = System.currentTimeMillis();
		int[] result = mergeSort.sort(arr);
		System.out.println("时间：" + (System.currentTimeMillis() - time));
		System.out.println(Arrays.toString(result));

	}

}
