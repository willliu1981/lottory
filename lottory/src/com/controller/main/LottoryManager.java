package com.controller.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.controller.exception.DrawFinishException;
import com.model.lottory.BigLotto;
import com.model.lottory.Lotto539;
import com.model.lottory.Lottory;
import com.model.lottory.SuperLotto;

public class LottoryManager {
	private static Lottory masterBigLotto = new BigLotto();
	private static Lottory masterSuperLotto = new SuperLotto();
	private static Lottory masterLotto539 = new Lotto539();
	private static List<Lottory> customerBigLottos = new ArrayList<>();
	private static List<Lottory> customerSuperLottos = new ArrayList<>();
	private static List<Lottory> customerLotto539s = new ArrayList<>();

	private static JFrame mainFrame;

	public LottoryManager(JFrame frame) {
		this.mainFrame = frame;
	}

	public void init() {
		masterBigLotto.createBall();
		masterSuperLotto.createBall();
		masterLotto539.createBall();
		Lottories.shuffle(masterBigLotto);
		Lottories.shuffle(masterSuperLotto);
		Lottories.shuffle(masterLotto539);
	}

	public void start() {
		while (true) {
			Lottory.Ball ball = null;
			try {
				Thread.sleep((int) (Math.random() * 500));
				ball = drawBigLotto();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (DrawFinishException ex) {
				System.out.println(ex.getMessage());
				break;
			}
		}
	}

	public Lottory.Ball drawBigLotto() {
		return masterBigLotto.draw();
	}

}
