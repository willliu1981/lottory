package com.model.lottory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.controller.exception.MaxLimitException;

public abstract class Lottory {
	protected List<Ball> balls;
	protected List<Ball> pool;

	/*
	 * class Ball is a Ball
	 */
	public static class Ball {
		private Integer number;

		public Ball(Integer number) {
			this.number = number;
		}

		public Integer getNumber() {
			return number;
		}

		public String toString() {
			return "" + this.number;
		}
	}

	public Lottory() {
		balls = new ArrayList<>();
		this.pool = new ArrayList<>();
	}

	public abstract void createBall();

	protected static void staticCreateBall(List<Ball> balls, int count) {
		int idx = 0;
		while (idx < count) {
			balls.add(new Ball(++idx));
		}
	}

	protected void createBall(int count) {
		staticCreateBall(this.balls, count);
	}

	public List<Ball> getBalls() {
		return this.balls;
	}

	public void shuffle() {
		Collections.shuffle(this.balls);
	}

	public Ball draw() {
		if (this.pool.size() >= this.drawLimit()) {
			throw new MaxLimitException(this.drawLimit());
		} else {
			this.pool.add(this.balls.get(0));
			return this.balls.remove(0);
		}
	}

	// max limit
	protected int drawLimit() {
		return this.balls.size();
	}

	public List<Ball> getPool() {
		return pool;
	}

}