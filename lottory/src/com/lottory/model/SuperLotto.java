package com.lottory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperLotto extends Lottory {
	protected List<Ball> secondBalls;

	public SuperLotto() {
		super();
		this.secondBalls = new ArrayList<>();
	}

	@Override
	public void createBall() {
		this.createBall(38);
		staticCreateBall(secondBalls, 8);
	}

	public List<Ball> getSecondBalls() {
		return this.secondBalls;
	}

	@Override
	public void shuffle() {
		super.shuffle();
		Collections.shuffle(this.secondBalls);
	}

}
