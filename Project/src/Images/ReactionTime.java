package Images;


	// Copyright Wintriss Technical Schools 2013
	import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


	public class ReactionTime extends KeyAdapter {

		// 1. Make a JFrame variable and initialize it using "new JFrame()"
		JFrame frame = new JFrame();
		int points = 0;
		Date timeAtStart = new Date();
		HashMap<Integer,String> images = new HashMap<Integer, String>();
		private int imageIndex;
		private int tries = 0;
		
		private  void makeAlbum() {
			// 2. add 4 images which match keyboard keys like this: images.put(new Integer(KeyEvent.VK_UP), "image.jpg");
			images.put(new Integer(KeyEvent.VK_UP), "Unknown-1.jpeg");
			images.put(new Integer(KeyEvent.VK_DOWN), "unnamed.png");
			images.put(new Integer(KeyEvent.VK_LEFT), "Unknown-2.jpeg");
			images.put(new Integer(KeyEvent.VK_RIGHT), "Unknown.jpeg");
			// 3. call the method to show an image
			showImage();
		}

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			//11. increment tries by 1
			tries++;
			
			//12. if tries is greater than 9 (or however many you want)
			//13.		exit the program

			//14. if the keyCode matches the imageIndex
			if (keyCode == imageIndex){
				System.out.println( "Correcto!!!!!!!");
				points++;
			} else {
				System.out.println( "In-Correcto!!!!!!!");
			}
			//15.		tell them they got a point
			
			//9. dispose of the frame
			frame.dispose();
			if (tries > 14){
				Date timeAtEnd = new Date();
				int finalScore = points * 10 - (int)(timeAtEnd.getTime()-timeAtStart.getTime())/100;
				if (finalScore < 0){
					System.out.println("Horray! You got ... um... hehehe... *gulp* " + finalScore + " points! Not too good... shall I say...");
				} else {			
					System.out.println("Horray! You got " + finalScore + " points! That's huge!");
				}
				//System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
				System.exit(0);
			}
			//10. call the method to show an image
			showImage();
		}


		private void showImage() {
			//4. initialize your frame to a new JFrame()
			frame = new JFrame();

			//5. set the frame to visible
			frame.setVisible(true);
			frame.add(getNextRandomImage()); //6. rename to the name of your frame
			frame.setName("daFrame");
			// 7. set the size of the frame  
			frame.pack();
			// 8. add a key listener to the frame
			frame.addKeyListener(this);
		}

		private Component getNextRandomImage() {
			this.imageIndex = new Random().nextInt(4) + 37;
			return loadImage(images.get(imageIndex));
		}

		private JLabel loadImage(String fileName) {
			URL imageURL = getClass().getResource(fileName);
			Icon icon = new ImageIcon(imageURL);
			return new JLabel(icon);
		}



		public static void main(String[] args) throws Exception {
			JOptionPane.showMessageDialog(null, "Press the directions of the nyan cats as quickly as possible!");
			new ReactionTime().makeAlbum();
		}
	}

	/* 16. make a points variable to track the score. tell the user their score at the end.
	* 
	* 17. add a timer
	* ~~~ where the code starts running ~~~
	* Date timeAtStart = new Date();
	* 
	* ~~~ where the code ends ~~~
	* Date timeAtEnd = new Date();
	* System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
	* System.exit(0);
	*/



