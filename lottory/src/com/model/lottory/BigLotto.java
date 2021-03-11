package com.model.lottory;

import com.controller.exception.DrawFinishException;
import com.model.lottory.Lottory.Ball;

public class BigLotto extends Lottory {
	private Ball specialBall;

	@Override
	public void createBall() {
		this.createBall(49);
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
			ball = specialBall = staticSimpleDraw(this.balls);
			throw new DrawFinishException(ball.getNumber());
		}
		return ball;
	}

	public Ball getSpecialBall() {
		return specialBall;
	}

}
