package com.example.collection.test;

import java.util.Arrays;

import com.example.backTrace.BackTrack;
import com.example.backTrace.IPostionCheck;
import com.example.backTrace.PositionCheck;
import com.example.domain.Position;

public class BackTrackTest {

	public static void main(String[] args) {
		
		int[][] map = {
				{1,1,1,1,0,0},
				{1,0,0,1,1,0},
				{1,1,0,0,0,0},
				{1,1,1,1,1,1}
		};
		IPostionCheck postionCheck = new PositionCheck(map);
		BackTrack backTrack = new BackTrack(postionCheck);
		//从第一个位置开始回溯
		backTrack.tryToSolve(new Position(0, 0));
		
		printArray(map);
	}
	
	private static void printArray(int[][] map){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				System.out.print(map[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
	}

}
