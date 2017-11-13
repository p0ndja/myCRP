package classCharRandom;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RandomChairThread implements Runnable {
	private Main gui = null;

	Random rnd = new Random();

	Thread thread = null;

	boolean isRunning = false;

	public RandomChairThread(Main gui) {
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

						for (int i = 0 ; i < tmp.size() ; i ++ ) {
							
							if (tmp.get(i) == value) {
								isInTheList = true;
							}
						}
						
					} while (isInTheList == true);
					
					
					tmp.add(Integer.valueOf(value));
				}
				
				try {
				for (int i = 0 ; i < tmp.size() ; i ++ ) {
					if (gui.btnChair[i] == null) {
						continue;
					}
					gui.tmpButton.get(i).setText("" + tmp.get(i));
					gui.tmpButton.get(i).setBackground(Color.GREEN);
					
					for (int k = 0 ; k < 20 ; k ++ ) {
					for (int j = i +1 ; j < tmp.size() ; j ++ ) {
						
					gui.tmpButton.get(j).setText("" + rnd.nextInt(gui.tmpButton.size()));
					
					}
					
					try {
						thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					for (int k = 0 ; k < 20 ; k ++ ) {
						for (int j = i +1 ; j < tmp.size() ; j ++ ) {
							
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
				
				}
				catch (NullPointerException ex) {
					ex.printStackTrace();
				}
				
				isRunning = false;
			

		
	}

}