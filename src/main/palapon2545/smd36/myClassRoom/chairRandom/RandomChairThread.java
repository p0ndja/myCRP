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

	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int value = 0;
		
		for (int k = 0; k < gui.tmpButton.size(); k++) {
			boolean isInTheList = false;
			do {
				isInTheList = false;
				value = rnd.nextInt(gui.tmpButton.size()) + 1;
				for (int i = 0; i < tmp.size(); i++) {
					if (tmp.get(i) == value) {
						isInTheList = true;
					}
				}
			} while (isInTheList == true);
			tmp.add(Integer.valueOf(value));
		}
		
		for (int j = 0; j < tmp.size(); j++) {
			gui.tmpButton.get(j).setBackground(Color.WHITE);
			gui.tmpButton.get(j).setText("EMPTY");
		}

		try {
			for (int i = 0; i < tmp.size(); i++) {
				if (gui.btnChair[i] == null) {
					continue;
				}
				// Checkname
				String n = "";
				Color c;
				int r = tmp.get(i);
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
				if (r <= 10) {
					c = Color.CYAN;
				} else {
					c = Color.PINK;
				}

				gui.tmpButton.get(i).setText("" + n);
				gui.tmpButton.get(i).setBackground(c);

				for (int k = 0; k < 20; k++) {
					for (int j = i + 1; j < tmp.size(); j++) {
						gui.tmpButton.get(j).setText("" + rnd.nextInt(gui.tmpButton.size()));
					}
					try {
						thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for (int k = 0; k < 20; k++) {
					for (int j = i + 1; j < tmp.size(); j++) {
						gui.tmpButton.get(j).setText("" + rnd.nextInt(gui.tmpButton.size()));
					}
					try {
						thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < tmp.size(); j++) {
				gui.tmpButton.get(j).setBackground(Color.WHITE);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < tmp.size(); j++) {
				gui.tmpButton.get(j).setBackground(Color.YELLOW);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < tmp.size(); j++) {
			gui.tmpButton.get(j).setBackground(Color.GREEN);
		}
		isRunning = false;
	}

}