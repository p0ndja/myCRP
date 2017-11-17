package main.palapon2545.smd36.myClassRoom.chairRandom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainSM extends JFrame implements ActionListener {
	private static final long serialVersionUID = 561811103320831759L;
	private JPanel contentPane;
	public final int chairSize = 32;
	public final int chairSizeX = 120;
	public final int chairSizeY = 100;
	private JButton btnChair[] = new JButton[chairSize];
	public ArrayList<JButton> tmpButton = new ArrayList<JButton>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSM frame = new MainSM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public MainSM() {

		setTitle("main.palapon2545.smd36.myClassRoom.chairRandom.MainSM.java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);

		JButton btnRandom = new JButton("\u0E2A\u0E38\u0E48\u0E21");
		btnRandom.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRandom.setBounds(530, 506, 200, 60);
		btnRandom.addActionListener(this);
		btnRandom.setBackground(Color.GREEN);
		btnRandom.setForeground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(btnRandom);

		JButton btnClose = new JButton("\u0E2D\u0E2D\u0E01");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(750, 506, 200, 60);
		btnClose.addActionListener(new CloseListener());
		btnClose.setBackground(Color.RED);
		contentPane.setLayout(null);
		contentPane.add(btnClose);

		JLabel label1 = new JLabel("Chair Random Position");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setBounds(10, 530, 507, 59);
		label1.setForeground(Color.WHITE);
		contentPane.add(label1);

		JLabel label = new JLabel(
				"\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E2A\u0E38\u0E48\u0E21\u0E17\u0E35\u0E48\u0E19\u0E31\u0E48\u0E07");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 40));
		label.setForeground(Color.WHITE);
		label.setBounds(10, 500, 507, 59);
		contentPane.add(label);

		JLabel lblPondja = new JLabel(
				"\u0E08\u0E31\u0E14\u0E17\u0E33\u0E42\u0E14\u0E22 Palapon Soontornas \u0E41\u0E25\u0E30 Patiphat Mana-u-krid");
		lblPondja.setHorizontalAlignment(SwingConstants.CENTER);
		lblPondja.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPondja.setBounds(10, 550, 1457, 59);
		lblPondja.setForeground(Color.WHITE);
		contentPane.add(lblPondja);

		for (int i = 0; i < chairSize; i++) {
			btnChair[i] = new JButton("\u0E40\u0E01\u0E49\u0E32\u0E2D\u0E35\u0E49");
			btnChair[i].setFont(new Font("Tahoma", Font.BOLD, 17));
			btnChair[i].setBackground(Color.WHITE);
			btnChair[i].setBounds(((i % 8) * chairSizeX) + ((i % 8) >= 4 ? 25 : 0), (i / 8) * (chairSizeY + 25),
					chairSizeX, chairSizeY);
			contentPane.add(btnChair[i]);
			switch (i) {
			case 23:
			case 30:
			case 31:
				// counter++;
				btnChair[i].setVisible(false);
				continue;
			default:
				tmpButton.add(btnChair[i]);
				break;
			}
			//btnChair[i].setText("num=" + (i + 1));
		}
	}
	
	private class CloseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		RandomChairThread chair = new RandomChairThread(this);
		chair.isRunning = true;
	}
}