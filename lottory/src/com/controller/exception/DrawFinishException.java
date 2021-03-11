package com.controller.exception;

public class DrawFinishException extends RuntimeException {
	public DrawFinishException() {
		super("draw finish");
	}

	public DrawFinishException(String message) {
		super(message);
	}
	public DrawFinishException(int lastBallNumber) {
		super("draw finish:"+lastBallNumber);
	}
}
