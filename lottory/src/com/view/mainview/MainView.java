package com.view.mainview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.main.LottoryManager;
import com.controller.viewcontrol.ShowNumberControl;
import com.model.lottory.BigLotto;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Dimension;

public class MainView extends JFrame {
	public static final String Card_BigLotto = "biglotto";
	public static final String Card_SuperLotto = "superlotto";
	public static final String Card_Lotto539 = "lotto539";
	public static final String Mapping_Parent = "mapping_parent";
	public static final String Mapping_Special = "mapping_special";
	public static final String Mapping_Second = "mapping_second";
	public static final String Mapping_Number1 = "mapping_number1";
	public static final String Mapping_Number2 = "mapping_number2";
	public static final String Mapping_Number3 = "mapping_number3";
	public static final String Mapping_Number4 = "mapping_number4";
	public static final String Mapping_Number5 = "mapping_number5";
	public static final String Mapping_Number6 = "mapping_number6";

	private JPanel contentPane;
	private JList list_LottoryType;
	private JPanel panel_card;
	private LottoryManager lottoryManager;
	private ShowNumberControl showNumberControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		lottoryManager = new LottoryManager(this);
		showNumberControl = new ShowNumberControl();
		lottoryManager.init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		list_LottoryType = new JList();
		list_LottoryType.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switch (list_LottoryType.getSelectedIndex()) {
				case 0:
					((CardLayout) panel_card.getLayout()).show(panel_card, Card_BigLotto);
					break;
				case 1:
					((CardLayout) panel_card.getLayout()).show(panel_card, Card_SuperLotto);
					break;
				case 2:
					((CardLayout) panel_card.getLayout()).show(panel_card, Card_Lotto539);
					break;
				default:
					break;
				}
			}
		});
		list_LottoryType.setFont(new Font("新細明體", Font.PLAIN, 14));
		list_LottoryType.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		list_LottoryType.setModel(new AbstractListModel() {
			String[] values = new String[] { "Big Lotto", "Super Lotto", "Lotto 539" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_LottoryType.setSelectedIndex(0);
		panel.add(list_LottoryType);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lottoryManager.start();
			}
		});
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lottoryManager.isStart()) {
					lottoryManager.reset();
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(btnNewButton_1);

		/*
		 * card panel
		 */
		panel_card = new JPanel();
		panel_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

			}
		});
		panel_card.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_card, BorderLayout.CENTER);
		panel_card.setLayout(new CardLayout(0, 0));

		/*
		 * big lotto panel
		 */
		JPanel panel_biglotto = new JPanel();
		panel_card.add(panel_biglotto, Card_BigLotto);
		panel_biglotto.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Big Lotto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_biglotto.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_biglotto.add(panel_1, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("__");
		lblNewLabel_3.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number1, lblNewLabel_3, lottoryManager.getLottory());
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("__");
		lblNewLabel_3_1.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number2, lblNewLabel_3_1, lottoryManager.getLottory());
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("__");
		lblNewLabel_3_2.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number3, lblNewLabel_3_2, lottoryManager.getLottory());
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("__");
		lblNewLabel_3_2_1.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number4, lblNewLabel_3_2_1, lottoryManager.getLottory());
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_3_2_2 = new JLabel("__");
		lblNewLabel_3_2_2.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number5, lblNewLabel_3_2_2, lottoryManager.getLottory());
		lblNewLabel_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_2.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_2_2);

		JLabel lblNewLabel_3_2_3 = new JLabel("__");
		lblNewLabel_3_2_3.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Number6, lblNewLabel_3_2_3, lottoryManager.getLottory());
		lblNewLabel_3_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_3.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_2_3);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(20, 10));
		panel_1.add(panel_2);

		JLabel lblNewLabel_3_2_3_1 = new JLabel("__");
		lblNewLabel_3_2_3_1.setPreferredSize(new Dimension(30, 20));
		showNumberControl.add(Mapping_Special, lblNewLabel_3_2_3_1, lottoryManager.getLottory());
		lblNewLabel_3_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_3_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_3_2_3_1);

		JPanel panel_superlotto = new JPanel();
		panel_card.add(panel_superlotto, Card_SuperLotto);
		panel_superlotto.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Super Lotto");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_superlotto.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel panel_lotto539 = new JPanel();
		panel_card.add(panel_lotto539, Card_Lotto539);
		panel_lotto539.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("Lotto 539");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_lotto539.add(lblNewLabel_2, BorderLayout.NORTH);
	}

	public LottoryManager getLottoryManager() {
		return lottoryManager;
	}

	public ShowNumberControl getShowNumberControl() {
		return showNumberControl;
	}

}
