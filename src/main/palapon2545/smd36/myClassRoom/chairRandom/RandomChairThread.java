package main.palapon2545.smd36.myClassRoom.chairRandom;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	String[] name = { "Not", "Tonkla", "Nut", "PunPun", "Poch", "Pond", "Ten", "Fifa", "Peem", "Pee", "Tonkhaw", "Pin",
			"Fah", "Kate", "Baitong", "Fortune", "Nam", "Gift", "Mew", "Beam", "Queen", "JingJang", "Ploy", "Oom",
			"Khawoat", "Junior", "Hall", "PhraePloy", "PairMaii" };

	public String beName(int intFromRandom) {
		String changeIntToName = "";
		changeIntToName = name[intFromRandom];
		return changeIntToName;
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		Date date = new Date();
		System.out.println("Start random at " + dateFormat.format(date) + String.format("%n"));
		File tempFile = new File("CRP_" + dateFormat.format(date) + ".log");
		try {
			FileWriter writer = new FileWriter(tempFile, true);
			writer.write("#Log from Chair Random Postion program!" + String.format("%n"));
			writer.write("#Time: " + dateFormat.format(date) + String.format("%n"));
			writer.write(
					"#Made by Palapon Soontornpas & Patiphat Mana-u-krid" + String.format("%n") + String.format("%n"));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int maxChairSize = gui.tmpButton.size();

		int list1[] = new int[maxChairSize]; // random order chair to complete
		int list2[] = new int[maxChairSize]; // random value of each chair

		randomList(list1, maxChairSize);
		randomList(list2, maxChairSize);

		for (int i = 0; i < maxChairSize; i++) {
			gui.tmpButton.get(i).setBackground(Color.LIGHT_GRAY);
			gui.tmpButton.get(i).setText("x");
		}

		for (int loopAllChair = 0; loopAllChair < maxChairSize; loopAllChair++) {

			int slotToChangeText = list1[loopAllChair];
			int numberOfcurChair = list2[loopAllChair];

			String text = beName(numberOfcurChair);
			Color color;

			int r = list2[loopAllChair];

			if (r <= 9) {
				color = Color.CYAN;
			} else {
				color = Color.PINK;
			}

			gui.tmpButton.get(slotToChangeText).setText("" + text);
			gui.tmpButton.get(slotToChangeText).setBackground(color);

			try {
				FileWriter writer = new FileWriter(tempFile, true);
				int chairNum = slotToChangeText + 1;
				String output = "chairAt " + chairNum + " = " + text + String.format("%n");
				System.out.print(output);
				writer.write(output);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int delay = 0; delay < 5; delay++) {
				for (int loopRandomAnimation = loopAllChair
						+ 1; loopRandomAnimation < maxChairSize; loopRandomAnimation++) {
					gui.tmpButton.get(list1[loopRandomAnimation]).setText("" + name[rnd.nextInt(name.length)]);
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