package classCharRandom;

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

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;

	public final int chairSize = 32;
	public final int chairSizeX = 100;
	public final int chairSizeY = 100;
	public JButton btnChair[] = new JButton[chairSize];

	public ArrayList<JButton> tmpButton = new ArrayList<JButton>();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	
	public void actionPerformed(ActionEvent e) {
		RandomChairThread chair = new RandomChairThread(this);
		chair.isRunning = true;
	}
	
	public Main() {
		setTitle("classCharRandom2.classCharRandom.Main.java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		JButton btnRandom = new JButton("Random");
		btnRandom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRandom.setBounds(500, 506, 265, 59);
		btnRandom.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(btnRandom);
		
		JLabel label = new JLabel("\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E2A\u0E38\u0E48\u0E21\u0E17\u0E35\u0E48\u0E19\u0E31\u0E48\u0E07");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 40));
		label.setBounds(10, 496, 507, 59);
		contentPane.add(label);
		
		JLabel lblPondja = new JLabel("\u0E08\u0E31\u0E14\u0E17\u0E33\u0E42\u0E14\u0E22 PondJa \u0E41\u0E25\u0E30 DDLoveDew");
		lblPondja.setHorizontalAlignment(SwingConstants.CENTER);
		lblPondja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPondja.setBounds(10, 530, 507, 59);
		contentPane.add(lblPondja);

		for (int i = 0; i < chairSize; i++) {
			

			btnChair[i] = new JButton("EMPTY");
			btnChair[i].setFont(new Font("Tahoma", Font.BOLD, 17));
			btnChair[i].setBackground(Color.RED);
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

			// btnChair[i].setText("" + (i+1 ));

		}

	}
}