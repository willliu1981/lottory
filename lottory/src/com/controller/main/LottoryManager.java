package com.controller.main;

import java.util.ArrayList;
import java.util.List;

import com.model.lottory.BigLotto;
import com.model.lottory.Lotto539;
import com.model.lottory.Lottory;
import com.model.lottory.SuperLotto;

public class LottoryManager {
	public static Lottory masterBigLotto = new BigLotto();
	public static Lottory masterSuperLotto = new SuperLotto();
	public static Lottory masterLotto539 = new Lotto539();
	public static List<Lottory> customerBigLottos = new ArrayList<>();
	public static List<Lottory> customerSuperLottos = new ArrayList<>();
	public static List<Lottory> customerLotto539s = new ArrayList<>();

	public void init() {
		Lottories.shuffle(masterBigLotto);
		Lottories.shuffle(masterSuperLotto);
		Lottories.shuffle(masterLotto539);
	}

}
