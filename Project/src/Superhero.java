
public class Superhero
{
	String name;
	String superPower;
	boolean evil;
	public Superhero(String name, String superPower){
		this.name = name;
		this.superPower = superPower;
	}
	public Superhero(String name, String superPower, boolean evil){
		this.name = name;
		this.superPower = superPower;
		this.evil = evil;
	}
	public String getName(){
		return name;
	}
	public String getSuperPower(){
		return superPower;
	}
	public boolean isEvil(){
		return evil;
	}
}
