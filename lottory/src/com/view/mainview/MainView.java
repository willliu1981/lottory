package com.view.mainview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.main.LottoryManager;
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

public class MainView extends JFrame {
	private static final String Card_BigLotto = "biglotto";
	private static final String Card_SuperLotto = "superlotto";
	private static final String Card_Lotto539 = "lotto539";

	private JPanel contentPane;
	private JList list_LottoryType;
	private JPanel panel_card;

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
		LottoryManager manager = new LottoryManager();
		manager.init();

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
					((CardLayout)panel_card.getLayout()).show(panel_card, Card_BigLotto);
					break;
				case 1:
					((CardLayout)panel_card.getLayout()).show(panel_card, Card_SuperLotto);
					break;
				case 2:
					((CardLayout)panel_card.getLayout()).show(panel_card, Card_Lotto539);
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(btnNewButton);

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

		JPanel panel_biglotto = new JPanel();
		panel_card.add(panel_biglotto, Card_BigLotto);
		panel_biglotto.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Big Lotto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_biglotto.add(lblNewLabel, BorderLayout.NORTH);

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
}
