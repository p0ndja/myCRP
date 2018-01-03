package main.palapon2545.smd36.myClassRoom.chairRandom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
	public final int chairSizeX = 130;
	public final int chairSizeY = 100;
	private JButton btnChair[] = new JButton[chairSize];
	public ArrayList<JButton> tmpButton = new ArrayList<JButton>();
	public final String title = "main.palapon2545.smd36.myClassRoom.chairRandom.MainSM.java";
	public final int width = 1073;
	public final int height = 631;
	public final Color bgcolor = Color.BLACK;
	public final String randomButton = "\u0E2A\u0E38\u0E48\u0E21";
	public final String closeButton = "\u0E2D\u0E2D\u0E01";
	public final String mainText = "\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E2A\u0E38\u0E48\u0E21\u0E17\u0E35\u0E48\u0E19\u0E31\u0E48\u0E07 [4/1]";
	public final String subText = "Chair Random Position";
	public final String credit = "\u0E08\u0E31\u0E14\u0E17\u0E33\u0E42\u0E14\u0E22";

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
		setBounds(100, 100, width, height);
		announce("set gui border");
		announce(" width = " + width);
		announce(" height = " + height);
		announce("set background = " + bgcolor.toString());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(bgcolor);
		setContentPane(contentPane);

		JButton btnRandom = new JButton(randomButton);
		btnRandom.setFont(new Font("Cordia New", Font.BOLD, 56));
		btnRandom.setBounds(576, 489, 140, 100);
		btnRandom.addActionListener(this);
		btnRandom.setBackground(Color.GREEN);
		btnRandom.setForeground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(btnRandom);
		announce("add button '" + randomButton + "'");

		JButton btnClose = new JButton(closeButton);
		btnClose.setFont(new Font("Cordia New", Font.BOLD, 56));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(892, 489, 140, 100);
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

		JLabel label_1 = new JLabel(credit);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Cordia New", Font.BOLD, 44));
		label_1.setBounds(206, 371, 1457, 59);
		contentPane.add(label_1);
		announce("add credit head text '" + credit + "'");

		JLabel lblPond = new JLabel("Palapon Soontornpas (Pond)");
		lblPond.setHorizontalAlignment(SwingConstants.CENTER);
		lblPond.setFont(new Font("Cordia New", Font.BOLD, 28));
		lblPond.setBounds(206, 399, 1457, 59);
		lblPond.setForeground(Color.WHITE);
		contentPane.add(lblPond);
		announce("add credit text 'Palapon Soontornpas (Pond)'");

		JLabel lblDew = new JLabel("Patiphat Mana-u-krid (Dew)");
		lblDew.setHorizontalAlignment(SwingConstants.CENTER);
		lblDew.setForeground(Color.WHITE);
		lblDew.setFont(new Font("Cordia New", Font.BOLD, 28));
		lblDew.setBounds(206, 427, 1457, 59);
		contentPane.add(lblDew);
		announce("add credit text 'Patiphat Mana-u-krid (Dew)'");

		JButton button = new JButton("\u0E23\u0E35\u0E04\u0E48\u0E32");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Cordia New", Font.BOLD, 56));
		button.setBackground(Color.CYAN);
		button.setBounds(736, 489, 140, 100);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restartApplication();
			}
		});
		contentPane.add(button);
		
		announce("");
		for (int i = 0; i < chairSize; i++) {
			btnChair[i] = new JButton("");
			btnChair[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnChair[i].setBackground(Color.LIGHT_GRAY);
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
			int o;
			if (i < 24) {
				o = i + 1;
			} else {
				o = i;
			}
			btnChair[i].setText("" + o);
			announce("render chair " + o + " at " + "x=" + (((i % 8) * chairSizeX) + ((i % 8) >= 4 ? 25 : 0)) + " y="
					+ ((i / 8) * (chairSizeY + 25)));
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

	public void restartApplication() {
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		final File currentJar = new File("401chairRandom.jar");
		/* is it a jar file? */
		if (!currentJar.getName().endsWith(".jar"))
			return;
		/* Build command: java -jar application.jar */
		final ArrayList<String> command = new ArrayList<String>();
		command.add(javaBin);
		command.add("-jar");
		command.add(currentJar.getPath());
		final ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}