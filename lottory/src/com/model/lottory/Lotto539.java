package com.model.lottory;

public class Lotto539  extends Lottory {

	@Override
	public void createBall() {
		this.createBall(39);
		
	}

	@Override
	protected int drawLimit() {
		return 5;
	}

}
