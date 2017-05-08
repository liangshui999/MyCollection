package com.example.collection.test;

import java.util.Arrays;
import java.util.Random;

import com.example.sort.QuikSort;
import com.example.sort.QuikSortMy;

public class QuickSortTest {

	public static void main(String[] args) {
		QuikSortMy sortMy = new QuikSortMy();
		int[] arr = new int[10];
		Random random = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = random.nextInt(1000);
		}
		sortMy.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
