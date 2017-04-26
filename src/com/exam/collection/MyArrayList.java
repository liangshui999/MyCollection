package com.exam.collection;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrayList {
	
	ArrayList<String> arrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(5);
		list1.add(9);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(9);
		list2.add(5);
		list2.add(5);
		
		System.out.println(add(list1, list2));
		
	}
	
	
	public static ArrayList<Integer> add(ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList<Integer> result = new ArrayList<>();
		int largeSize = list1.size() > list2.size() ? list1.size() : list2.size();
		int carry = 0;//需要进一的值
		for(int i = 0; i < largeSize; i++){
			int temp = getItem(list1, i) + getItem(list2, i) + carry;
			result.add(temp % 10);
			carry = temp / 10;
		}
		if(carry == 1){
			result.add(1);
		}
		Collections.reverse(result);
		return result;
	}
	
	/**
	 * i=0的时候返回个位，i=1的时候返回十位
	 * @param list
	 * @param i
	 * @return
	 */
	public static int getItem(ArrayList<Integer> list, int i){
		if(i >= list.size()){
			return 0;
		}
		return list.get(list.size() - i -1);
	}
		
}
