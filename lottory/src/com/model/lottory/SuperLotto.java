package com.model.lottory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperLotto extends Lottory {
	protected List<Ball> secondBalls;
	protected Ball secondPool;

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

	@Override
	protected int drawLimit() {
		return 6;
	}

	@Override
	public Ball draw() {
		Ball ball = null;
		try {
			ball = super.draw();
		} catch (RuntimeException ex) {
			ball = this.secondPool = staticDraw(secondBalls);
		}
		return ball;
	}

	@Override
	public void reset() {
		super.reset();
		this.secondPool=null;
	}
	
	

}
