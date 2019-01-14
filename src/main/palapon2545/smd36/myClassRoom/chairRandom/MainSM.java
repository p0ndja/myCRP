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
	public final int chairSize = RandomChairThread.name.length;
	public final int chairSizeX = 130;
	public final int chairSizeY = 100;
	private JButton btnChair[] = new JButton[chairSize];
	public ArrayList<JButton> tmpButton = new ArrayList<JButton>();
	public final String title = "main.palapon2545.smd36.myClassRoom.chairRandom.MainSM.java";
	public final Color bgcolor = Color.BLACK;
	public final String randomButton = "\u0E2A\u0E38\u0E48\u0E21";
	public final String closeButton = "\u0E2D\u0E2D\u0E01";
	public final String mainText = "\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E2A\u0E38\u0E48\u0E21\u0E17\u0E35\u0E48\u0E19\u0E31\u0E48\u0E07 [5/1]";
	public final String subText = "Chair Random Position";

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

	public static void announce(String m) {
		System.out.print(m + String.format("%n"));
	}

	public MainSM() {
		announce("running program . . .");
		setTitle(title);
		announce("set title = " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 631);
		announce("set background = " + bgcolor.toString());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(bgcolor);
		setContentPane(contentPane);

		JButton btnRandom = new JButton(randomButton);
		btnRandom.setFont(new Font("Cordia New", Font.BOLD, 56));
		btnRandom.setBounds(576, 489, 129, 100);
		btnRandom.addActionListener(this);
		btnRandom.setBackground(Color.GREEN);
		btnRandom.setForeground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(btnRandom);
		announce("add button '" + randomButton + "'");

		JButton btnClose = new JButton(closeButton);
		btnClose.setFont(new Font("Cordia New", Font.BOLD, 56));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(715, 489, 129, 100);
		btnClose.addActionListener(new CloseListener());
		btnClose.setBackground(Color.RED);
		contentPane.setLayout(null);
		contentPane.add(btnClose);
		announce("add button '" + closeButton + "'");

		JLabel label = new JLabel(mainText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Cordia New", Font.BOLD, 60));
		label.setForeground(Color.WHITE);
		label.setBounds(10, 500, 507, 59);
		contentPane.add(label);
		announce("add text '" + mainText + "'");

		JLabel label1 = new JLabel(subText);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Cordia New", Font.PLAIN, 40));
		label1.setBounds(10, 530, 507, 59);
		label1.setForeground(Color.WHITE);
		contentPane.add(label1);
		announce("add text '" + subText + "'");
		announce("");
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int o = 0; o < 7; o++) {
				btnChair[count] = new JButton("");
				btnChair[count].setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnChair[count].setBackground(Color.LIGHT_GRAY);
				btnChair[count].setBounds(o * chairSizeX, i * chairSizeY + (i * 25), chairSizeX, chairSizeY);
				contentPane.add(btnChair[count]);
				tmpButton.add(btnChair[count]);
				count++;
			}
		}
		announce("rendered " + tmpButton.size() + " chairs.");
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