package com.example.backTrace;

import java.util.Iterator;

import com.example.domain.Position;

public class PositionCheck implements IPostionCheck {
	
	/**
	 * 地图
	 */
	private int[][] mMap;
	
	private static final int SUCCESS = 9;
	
	private static final int FALIUR = 2;
	
	public PositionCheck(int[][] map) {
		this.mMap = map;
	}
	

	@Override
	public boolean isVaild(Position position) {
		int row = position.getRow();
		int colum = position.getColum();
		if((row >= 0 && row <= mMap.length - 1) && (colum >= 0 && colum <= mMap[0].length - 1)
				&& (mMap[row][colum] == 1)){
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Position> iterator(Position position) {
		return new MyIterator(position);
	}

	@Override
	public boolean isHit(Position position) {
		int row = position.getRow();
		int colum = position.getColum();
		if((row == mMap.length - 1) && (colum == mMap[0].length - 1)){
			System.out.println("击中了" + row + "," + colum);
			return true;
		}
		return false;
	}

	@Override
	public void record(Position position) {
		int row = position.getRow();
		int colum = position.getColum();
		mMap[row][colum] = SUCCESS;
	}

	@Override
	public void undo(Position position) {
		int row = position.getRow();
		int colum = position.getColum();
		mMap[row][colum] = FALIUR;
	}
	
	private class MyIterator implements Iterator<Position>{
		
		private int mCount;
		
		private Position mPosition;
		
		public MyIterator(Position mPosition) {
			super();
			this.mPosition = mPosition;
		}

		@Override
		public boolean hasNext() {
			return mCount < 4;
		}
		
		/**
		 * 这个地方的搜索策略是：北东南西的搜索策略
		 */
		@Override
		public Position next() {
			int row = mPosition.getRow();
			int colum = mPosition.getColum();
			switch (mCount) {
			case 0:
				row = row - 1;
				break;
			case 1:
				colum = colum + 1;
				break;
			case 2:
				row = row + 1;
				break;
			case 3:
				colum = colum - 1;
				break;
			default:
				break;
			}
			mCount++;
			return new Position(row, colum);
		}
		
	}

}
