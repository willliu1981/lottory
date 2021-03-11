package com.controller.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.controller.exception.DrawFinishException;
import com.model.lottory.BigLotto;
import com.model.lottory.Lotto539;
import com.model.lottory.Lottory;
import com.model.lottory.SuperLotto;
import com.view.mainview.MainView;

public class LottoryManager {
	private static Lottory masterBigLotto = new BigLotto();
	private static Lottory masterSuperLotto = new SuperLotto();
	private static Lottory masterLotto539 = new Lotto539();
	private static List<Lottory> customerBigLottos = new ArrayList<>();
	private static List<Lottory> customerSuperLottos = new ArrayList<>();
	private static List<Lottory> customerLotto539s = new ArrayList<>();
	private boolean isStart=false;

	private static JFrame mainFrame;

	public LottoryManager(JFrame frame) {
		LottoryManager.mainFrame = frame;
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
		if(this.isStart) {
			return ;
		}else {
			this.isStart=true;
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (Math.random() > 0.12) {
					return;
				}
				Lottory.Ball ball = null;
				try {
					ball = drawBigLotto();
				} catch (DrawFinishException ex) {
					System.out.println(ex.getMessage());
					try {
						((MainView) mainFrame).getShowNumberControl().showNumber((x1, x2) -> {
							((JLabel) x1.get(MainView.Mapping_Special))
									.setText(((BigLotto) x2.get(MainView.Mapping_Special)).getSpecialBall().toString());
							;
						});
					} catch (Exception exx) {
						System.out.println(exx.getMessage());
					}
					this.cancel();
					isStart=false;
				}
				((MainView) mainFrame).getShowNumberControl().showNumber((x1, x2) -> {
					String str = "";
					List<Lottory.Ball> pool = null;
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number1)).getPool()).size() <= 0 ? "__"
							: pool.get(0).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number1)).setText(str);
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number2)).getPool()).size() <= 1 ? "__"
							: pool.get(1).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number2)).setText(str);
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number3)).getPool()).size() <= 2 ? "__"
							: pool.get(2).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number3)).setText(str);
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number4)).getPool()).size() <= 3 ? "__"
							: pool.get(3).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number4)).setText(str);
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number5)).getPool()).size() <= 4 ? "__"
							: pool.get(4).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number5)).setText(str);
					str = (pool = ((BigLotto) x2.get(MainView.Mapping_Number6)).getPool()).size() <= 5 ? "__"
							: pool.get(5).getNumber().toString();
					((JLabel) x1.get(MainView.Mapping_Number6)).setText(str);
				});
			}
		}, 1000, 100);
	}

	public void reset() {
		this.masterBigLotto.reset();
		((MainView) mainFrame).getShowNumberControl().showNumber((x1, x2) -> {
			((JLabel) x1.get(MainView.Mapping_Number1)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Number2)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Number3)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Number4)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Number5)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Number6)).setText("__");
			((JLabel) x1.get(MainView.Mapping_Special)).setText("__");
		});
	}

	public Lottory.Ball drawBigLotto() {
		return masterBigLotto.draw();
	}

	public Lottory getLottory() {
		return LottoryManager.masterBigLotto;
	}

	public boolean isStart() {
		return isStart;
	}
	
	

}
