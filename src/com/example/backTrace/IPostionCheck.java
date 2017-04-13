package com.example.backTrace;

import java.util.Iterator;

import com.example.domain.Position;

public interface IPostionCheck {
	
	/**
	 * 判断某个点是否有效
	 * @param position
	 * @return
	 */
	boolean isVaild(Position position);
	
	/**
	 * 用于遍历某个点后面直接挨着它的点,如果是按照上下左右4个方向搜索的话，则有4个点
	 * @param position
	 * @return
	 */
	Iterator<Position> iterator(Position position);
	
	/**
	 * 判断某个点是否是目标
	 * @param position
	 * @return
	 */
	boolean isHit(Position position);
	
	/**
	 * 将某个点添加到记录里面去
	 * @param position
	 */
	void record(Position position);
	
	/**
	 * 将尝试之后不通的点进行标记
	 * @param position
	 */
	void undo(Position position);
}
