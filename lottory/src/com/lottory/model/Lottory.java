package com.lottory.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Lottory {
	protected List<Ball> balls;
	protected List<Ball> pool;

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

}
