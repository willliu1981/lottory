package com.test.test1;

import com.controller.main.Lottories;
import com.model.lottory.Lottory;
import com.model.lottory.SuperLotto;

public class Test2 {

	public static void main(String[] args) {
		Lottory big = new SuperLotto();
		Lottories.shuffle(big);
	}

}
