package com.example.collection.test;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random(800);
		for(int i = 0; i < 2; i++){
			System.out.println(random.nextInt());
		}

	}

}
