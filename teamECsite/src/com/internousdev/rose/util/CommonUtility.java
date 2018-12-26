package com.internousdev.rose.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtility {
	public String getRamdomValue() {
		String value="";
		double d;
		for(int i=1; i<=16; i++) {
			d=Math.random() * 10;
			value=value+((int)d);
		}
		return value;
	}

	public String[] parseArrayList(String s) {
		return s.split(", ",0);
	}

	public <E> List<List<E>>  devideList(List<E> list, int size){
		if (list == null || list.isEmpty() || size <= 0) {
			return null;
		}
		// 必要なページ数を計算
		int block = list.size() / size + (list.size() % size > 0 ? 1 : 0 );
		// "block"の数だけ、"size"で指定した容量のリストの箱を作成
		List<List<E>> devidedList = new ArrayList<List<E>>(block);
		for (int i = 0; i < block; i ++) {
			int start = i * size;//  各ブロックの初めのリスト
			int end = Math.min(start + size, list.size());// 各ブロックの終わりのリスト
			// 各ブロックに商品リストを挿入
			devidedList.add(new ArrayList<E>(list.subList(start, end)));
		}
		// List<List<E>>型で分けられたブロックを返す
		return devidedList;
	}
}
