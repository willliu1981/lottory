package com.controller.exception;

public class MaxLimitException extends RuntimeException {
	public MaxLimitException() {
		super("exceed max limit");
	}

	public MaxLimitException(String message) {
		super(message);
	}
	public MaxLimitException(int max) {
		super("exceed max limit:"+max);
	}
}
