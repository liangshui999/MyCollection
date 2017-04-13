package com.example.backTrace;

import java.util.Iterator;

import com.example.domain.Position;

/**
 * 回溯算法的核心类
 * @author asus-cp
 *
 */
public class BackTrack {
	
	private IPostionCheck mApplication;
	
	public BackTrack(IPostionCheck mApplication) {
		super();
		this.mApplication = mApplication;
	}

	/**
	 * 判断某个点后面的路是否是通的,也可以说是某个点到目标点的路是否是通的
	 * @param position
	 * @return
	 */
	public boolean tryToSolve(Position position){
		
		boolean success = false;
		//这个迭代器用于遍历这个点后面的所有点（是直接挨着它的），如果可以进行上下左右4个方向搜索的话，就是4个点
		Iterator<Position> iterator= mApplication.iterator(position);
		while(! success && iterator.hasNext()){
			//从后面紧挨着它的4个点里面选择一个,第一次循环的时候，肯定是选择最优先的方向,比如是按照上下左右的话，
			//则第一次是上面的点
			Position pos = iterator.next();
			//System.out.println(pos.getRow()+ "," + pos.getColum());
			if(mApplication.isVaild(pos)){
				mApplication.record(position);
				//后面紧挨着它的点，正好是目标点
				if(mApplication.isHit(pos)){
					System.out.println("isHit");
					success = true;
				}else{
					//如果返回true说明后面紧挨着它的点虽然不是目标点，但是后面紧挨着它的点到目标点的路是通的
					success = tryToSolve(pos);
					if(! success){
						mApplication.undo(position);
					}
				}
			}
			
		}
		return success;
	}	
}
