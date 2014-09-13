import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Lottery implements ActionListener
{
	JFrame rame = new JFrame();
	JPanel anel = new JPanel();
	JTextField extField = new JTextField(10);
	JTextField extField2 = new JTextField(10);
	JTextField extField3 = new JTextField(10);
	JButton utton = new JButton();
	public static void main(String[] args){
		Lottery lottery = new Lottery();
	}

	public Lottery(){
		rame.setVisible(true);
		rame.add(anel);
		anel.add(extField);
		anel.add(extField2);
		anel.add(extField3);
		utton.setText("Lotterize");
		anel.add(utton);
		rame.pack();
		utton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		int numberOfContestants = Integer.valueOf(extField.getText());
		//int yourTicket = (int)(Math.random() * (double)numberOfContestants);
		int theTicket = (int)(Math.random() * (double)numberOfContestants);
		int price = Integer.valueOf(extField2.getText());
		int numberOwned = Integer.parseInt(extField3.getText());
		String win;
		int[] myTickets = new int[numberOwned];
		int i = numberOwned;
		while(i > -1){
			int currentTicket = (int)(Math.random() * (double)numberOfContestants);
			boolean isUnique = true;
			for (int j = 0; j < myTickets.length; j++){
				if (myTickets[j] == currentTicket)
				{
					isUnique = false;
				}
			}
			if (isUnique){
				i++;
			}
		}
		myTickets[i] = (int)(Math.random() * (double)numberOfContestants); 
		if (myTickets[0] == theTicket){
			win = "won!";
		} else {
			win = "lost...";
		}
		JOptionPane.showMessageDialog(null, "The pot is $" + price * numberOfContestants +" and the winning ticket is " + theTicket + ". You " + win);
	}
}
