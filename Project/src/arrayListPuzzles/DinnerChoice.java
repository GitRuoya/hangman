package arrayListPuzzles;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DinnerChoice
{
	public static void main(String[] args)
	{
		// STUFFF
		ArrayList<String> dinnerChoices = new ArrayList<String>(7);
		dinnerChoices.add(0, "rice");
		dinnerChoices.add(1, "mushroom soup");
		dinnerChoices.add(2, "spaghetti");
		dinnerChoices.add(3, "chocolate");
		dinnerChoices.add(4, "ice cream");
		dinnerChoices.add(5, "moldy cookie crumbs (#noMoss)");
		dinnerChoices.add(6, "absolutely nothing");
		int randomIndexOne = (int) (Math.random() * dinnerChoices.size());
		int randomIndexTwo = randomIndexOne;
		while (randomIndexTwo == randomIndexOne)
		{
			randomIndexTwo = (int) (Math.random() * dinnerChoices.size());
		}
		JOptionPane.showMessageDialog(null, "You should eat " + dinnerChoices.get(randomIndexOne) + " tonight! But if you REALLY don't feel like it, then you may eat " + dinnerChoices.get(randomIndexTwo) + " instead!");
		if (randomIndexOne == 3 || randomIndexTwo == 3){
			JOptionPane.showMessageDialog(null, "PSST! Pick chocolate! It's awesome!");
		}
	}
}
