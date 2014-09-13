package arrayListPuzzles;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JokeCreator implements KeyListener
{
	// Add a bunch of jokes to an ArrayList. When the user presses the space
	// bar, show a random joke.
	JFrame frame = new JFrame();
	ArrayList<String> jokes = new ArrayList<String>(5);
	boolean done;
	
	public static void main(String[] args)
	{		
		new JokeCreator();
		
	}

	public JokeCreator()
	{
		jokes.add(0, "Bad jokes tend to be PUNishing!!");
		jokes.add(1, "I was going to make a fighting joke, but I forgot the PUNCHline!!");
		jokes.add(2, "I was going to make jokes for a living, but my friend said I'd make no CENTS!");
		jokes.add(3, "There are 10 people in this world: those that know binary and those that don't. -Teagan");
		jokes.add(4, "Grammer jokes are fun, but don't forget to PUNcuate!!");
		frame.setVisible(true);
		frame.addKeyListener(this);
		done = false;
		while(!done){
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("END!!!!!!!");
		System.exit(0);
	}

	public void sayJoke(){
		int randomIndex = (int) (Math.random() * jokes.size());
		JOptionPane.showMessageDialog(null, jokes.get(randomIndex));
	}
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		char typed = arg0.getKeyChar();
		if (typed == ' ')
		{
			this.sayJoke();
		} else if (typed == 'q'){
			done = true;
			System.out.println("END!");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
