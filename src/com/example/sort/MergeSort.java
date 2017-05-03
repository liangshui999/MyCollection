package com.example.sort;

import java.util.Arrays;

/**
	 * 归并排序，从小到大
	 * 归并排序算法一般需要三步
	 * 1. 左边排序
	 * 2. 右边排序
	 * 3. 合并
	 * 需要用到递归调用
	 * @author ahern88
	 */
	public class MergeSort {
	 
	    public int[] sort(int[] arrs){
	        if(arrs.length < 2){
	            return arrs;
	        }
	        int middle = arrs.length % 2 == 0 ? arrs.length / 2 : (arrs.length - 1) / 2;
	        int[] left = Arrays.copyOfRange(arrs, 0, middle);
	        int[] right = Arrays.copyOfRange(arrs, middle, arrs.length);
	        int[] lres = sort(left);
	        int[] rres = sort(right);
	        return merge(lres, rres);
	    }
	 
	    private int[] merge(int[] lres, int[] rres) {
	        int[]  res = new int[lres.length + rres.length];
	        int l = 0;
	        int r = 0;
	        int c = 0;
	        while(l < lres.length && r < rres.length){
	            if(lres[l] < rres[r]){
	                res[c++] = lres[l++];
	            } else {
	                res[c++] = rres[r++];
	            }
	        }
	        if(l == lres.length){
	            while(r < rres.length){
	                res[c++] = rres[r++];
	            }
	            return res;
	        }
	        if(r == rres.length){
	            while(l < lres.length){
	                res[c++] = lres[l++];
	            }
	            return res;
	        }
	        return res;
	    }
	     
	}


