package com.test.test1;

import java.util.ArrayList;
import java.util.List;

import com.lottory.model.BigLotto;
import com.lottory.model.Lottory;

public class Test {

	public static void main(String[] args) {
		List<Lottory.Ball> balls=new ArrayList<>();
		Lottory lot=new BigLotto() ;
		lot.createBall();
		
	lot.getBalls().stream().forEach(System.out::println);
		
		
	}

}

