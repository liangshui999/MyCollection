package com.example.collection.test;

/**
 * 递归测试
 * @author asus-cp
 *
 */
public class RecursiveTest {

	public static void main(String[] args) {
		
		int n = 456;
		System.out.println(getBinaryString(n));
		
		System.out.println(Integer.toBinaryString(n));

	}
	
	public static String getBinaryString(int n){
		if(n == 1){
			return "" + 1;
		}else{
			int last = n % 2;
			return getBinaryString(n / 2) + "" + last;
		}
	}

}
