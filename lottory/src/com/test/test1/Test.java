package com.test.test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.lottory.model.BigLotto;
import com.lottory.model.Lottory;
import com.lottory.model.Lottory.Ball;
import com.lottory.model.SuperLotto;

public class Test {

	public static void main(String[] args) {
		List<Lottory.Ball> balls = new ArrayList<>();
		Lottory lot = new SuperLotto();
		lot.createBall();

		((SuperLotto) lot).getSecondBalls().stream().forEach(System.out::println);
		lot.shuffle();
		((SuperLotto) lot).getSecondBalls().stream().forEach(System.out::println);

		System.out.println("draw: " + lot.draw());
		System.out.println("draw: " + lot.draw());
		System.out.println("draw: " + lot.draw());
		System.out.println("draw: " + lot.draw());
		System.out.println("draw: " + lot.draw());
		System.out.println("draw: " + lot.draw());
		((SuperLotto) lot).getBalls().stream().sorted((x1, x2) -> x1.getNumber() - x2.getNumber()).forEach(x -> {
			System.out.print(" " + x);
		});

	}

}
