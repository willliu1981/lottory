package com.lottory.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Lottory {
	protected List<Ball> balls;
	protected List<Ball> pool;
	
	public Lottory() {
		balls=new ArrayList<>();
	}
	
	
}

class Ball{
	private Integer number;
	private Integer priority;
	
	public Ball(Integer number,Integer priority) {
		this.number=number;
		this.priority=priority;
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getPriority() {
		return priority;
	}
	
	
	
}
