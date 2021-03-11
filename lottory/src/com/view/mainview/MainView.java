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

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		LottoryManager manager=new LottoryManager();
		manager.init();
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setFont(new Font("新細明體", Font.PLAIN, 14));
		list.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Big Lotto", "Super Lotto", "Lotto 539"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		panel.add(list);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(textField);
		textField.setColumns(5);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setToolTipText("create lottory");
		panel.add(btnNewButton);
	}

}
