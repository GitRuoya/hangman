import java.util.ArrayList;


public class LearningArrayLists
{

	public static ArrayList<String> createArrayList()
	{
		// TODO Auto-generated method stub
		ArrayList<String> learner = new ArrayList<String>(10);
		return learner;
	}

	public static void addToArrayList(ArrayList testList, String string)
	{
		// TODO Auto-generated method stub
		testList.add(string);
	}

	public static int getNumberOfItems(ArrayList testList)
	{
		// TODO Auto-generated method stub
		return testList.size();
	}

	public static Object getItem(ArrayList testList, int i)
	{
		// TODO Auto-generated method stub
		return testList.get(i);
	}

	public static String iterateOver(ArrayList testList)
	{
		// TODO Auto-generated method stub
		StringBuilder finalString = new StringBuilder();
		for(Object s: testList){
			finalString.append(s);
		}
		return finalString.toString();
	}

	public static Object findItemOnList(ArrayList testList, String string)
	{
		// TODO Auto-generated method stub
		return testList.lastIndexOf(string);
	}

	public static void replaceItem(ArrayList testList, int i, String string)
	{
		// TODO Auto-generated method stub
		testList.set(i, string);
	}

	public static void insertItem(ArrayList testList, int i, String string)
	{
		// TODO Auto-generated method stub
		testList.add(i, string);
	}

	public static ArrayList<Integer> createTypedArrayList()
	{
		// TODO Auto-generated method stub
		return new ArrayList<Integer>();
	}

	public static Integer addAllInteger(ArrayList<Integer> testList)
	{
		// TODO Auto-generated method stub
		Integer sum = 0;
		for (Integer i: testList){
			sum+=i;
		}
		return sum;
	}

	public static ArrayList<String> createStringTypedArrayList()
	{
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

	public static String addAllString(ArrayList<String> testList)
	{
		// TODO Auto-generated method stub
		StringBuilder total = new StringBuilder();
		for (String s: testList){
			total.append(s);
		}
		return total.toString();
	}

}
