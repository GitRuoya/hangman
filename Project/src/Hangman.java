import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener
{
	Stack<String> stack = new Stack<String>();
	String puzzle;
	JLabel label = new JLabel();
	ArrayList<JLabel> letters = new ArrayList<JLabel>();
	int lives;
	JLabel livesLabel;

	public static void main(String[] args)
	{
		Hangman harry = new Hangman();
		harry.Word();
		harry.Guess();

	}

	public void Guess()
	{
		lives = 9;
		puzzle = stack.pop();
		JFrame frame = new JFrame();
		frame.addKeyListener(this);
		JPanel panel = new JPanel();
		livesLabel = new JLabel("" + lives);
		livesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		// panel.setLayout(new FlowLayout());
		// label = new JLabel(puzzle);
		// panel.add(label);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		letters.clear();
		for (int i = 0; i < puzzle.length(); i++)
		{
			letters.add(new JLabel("_"));
			panel.add(letters.get(i));
		}
		panel.add(livesLabel);
		frame.pack();
		frame.setVisible(true);
	}

	public void Word()
	{
		stack.push("syzygy");
		stack.push("integer");
		stack.push("language");
		stack.push("variable");
		stack.push("russ");
		stack.push("ruoya");
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// if (!stack.isEmpty())
		// {
		// puzzle = stack.pop();
		// label.setText(puzzle);
		// }
		if (puzzle.indexOf(arg0.getKeyChar()) != -1)
		{
			updateSpacesWithUserInput(arg0.getKeyChar());
			if (getCurrentAnswer().equals(puzzle))
			{
				JOptionPane.showMessageDialog(null, "Great Job!");
				Guess();
			}
		} else
		{
			lives--;
			livesLabel.setText("" + lives);	
			if (lives < 1)
			{
				playDeathKnell();
				for (int i = 0; i < puzzle.length(); i++)
				{
					letters.get(i).setText("" + puzzle.substring(i, i + 1));
				}
				JOptionPane.showMessageDialog(null, "You Lost!");
				Guess();
			}
		}
	}

	private String getCurrentAnswer()
	{
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : letters)
		{
			answer.append(textBox.getText());
		}
		return answer.toString();
	}
	
	public static void playDeathKnell() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new FileInputStream("src/death.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}


	private void updateSpacesWithUserInput(char keyChar)
	{
		for (int i = 0; i < puzzle.length(); i++)
		{
			if (puzzle.charAt(i) == keyChar)
			{
				letters.get(i).setText("" + keyChar);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{

	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{

	}
}
