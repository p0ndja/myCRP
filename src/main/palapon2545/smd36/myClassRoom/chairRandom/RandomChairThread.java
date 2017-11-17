package main.palapon2545.smd36.myClassRoom.chairRandom;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RandomChairThread implements Runnable {
	private MainSM gui = null;

	Random rnd = new Random();

	Thread thread = null;

	boolean isRunning = false;

	public RandomChairThread(MainSM gui) {
		this.gui = gui;
		this.thread = new Thread(this);
		thread.start();
	}

	public String beName(int r) {
		String n = "";
		r = r + 1;

		if (r == 1) {
			n = "Not";
		} else if (r == 2) {
			n = "Tonkla";
		} else if (r == 3) {
			n = "Nut";
		} else if (r == 4) {
			n = "PunPun";
		} else if (r == 5) {
			n = "Poch";
		} else if (r == 6) {
			n = "Pond";
		} else if (r == 7) {
			n = "Ten";
		} else if (r == 8) {
			n = "Fifa";
		} else if (r == 9) {
			n = "Peem";
		} else if (r == 10) {
			n = "Pee";
		} else if (r == 11) {
			n = "Tonkhaw";
		} else if (r == 12) {
			n = "Pin";
		} else if (r == 13) {
			n = "Fah";
		} else if (r == 14) {
			n = "Kate";
		} else if (r == 15) {
			n = "Baitong";
		} else if (r == 16) {
			n = "Fortune";
		} else if (r == 17) {
			n = "Nam";
		} else if (r == 18) {
			n = "Gift";
		} else if (r == 19) {
			n = "Mew";
		} else if (r == 20) {
			n = "Beam";
		} else if (r == 21) {
			n = "Queen";
		} else if (r == 22) {
			n = "JingJung";
		} else if (r == 23) {
			n = "Ploy";
		} else if (r == 24) {
			n = "Oom";
		} else if (r == 25) {
			n = "Kaowoat";
		} else if (r == 26) {
			n = "Junior";
		} else if (r == 27) {
			n = "Hall";
		} else if (r == 28) {
			n = "Phraeploy";
		} else if (r == 29) {
			n = "PairMaii";
		}

		return n;
	}

	public void randomList(int list[], int maxChairSize) {
		int counter = 0;

		for (int i = 0; i < maxChairSize; i++) {
			list[i] = -1;
		}

		while (counter < maxChairSize) {

			int slot = rnd.nextInt(maxChairSize);

			if (list[slot] == -1) {
				list[slot] = counter;

				counter++;
			}
		}
	}

	public void run() {
		int maxChairSize = gui.tmpButton.size();

		int list1[] = new int[maxChairSize]; // random order chair to complete
		int list2[] = new int[maxChairSize]; // random value of each chair

		randomList(list1, maxChairSize);
		randomList(list2, maxChairSize);

		for (int i = 0; i < maxChairSize; i++) {
			gui.tmpButton.get(i).setBackground(Color.WHITE);
			gui.tmpButton.get(i).setText("EMPTY");
		}

		for (int loopAllChair = 0; loopAllChair < maxChairSize; loopAllChair++) {
			
			int slotToChangeText = list1[loopAllChair];
			int numberOfcurChair = list2[loopAllChair];

			String text = beName(numberOfcurChair);
			Color color;

			int r = list2[loopAllChair];

			if (r <= 10) {
				color = Color.CYAN;
			} else {
				color = Color.PINK;
			}

			gui.tmpButton.get(slotToChangeText).setText("" + text);
			gui.tmpButton.get(slotToChangeText).setBackground(color);

			for (int delay = 0; delay < 100; delay++) {
				for (int loopRandomAnimation = loopAllChair + 1; loopRandomAnimation < maxChairSize; loopRandomAnimation++) {

					gui.tmpButton.get(list1[loopRandomAnimation]).setText("" + rnd.nextInt(gui.tmpButton.size()));

				}

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < maxChairSize; j++) {
				gui.tmpButton.get(j).setForeground(Color.WHITE);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < maxChairSize; j++) {
				gui.tmpButton.get(j).setForeground(Color.BLACK);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isRunning = false;
	}

}