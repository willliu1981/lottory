package com.controller.main;

import com.model.lottory.Lottory;

public class Lottories<T> {

	public static <T extends Lottory> void shuffle(T lottory) {
		lottory.shuffle();
	}
}
