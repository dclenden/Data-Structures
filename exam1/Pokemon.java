//David W. Clendenning Jr. - CIS211 - Exam 1
package exam1;
/* implementing PokemonInterface to have more abstract data*/
public class Pokemon implements PokemonInterface{
    private String name;
    private String type;
    private int healthPoints;
    private int attack;
    private int defense;
	/* basic constructors */
    public Pokemon() {
    	
    }
    
    public Pokemon(String name, String type, int healthPoints, int atk, int def) {
    	this.name = name;
    	this.type = type;
    	this.healthPoints = healthPoints;
    	this.attack = atk;
    	this.defense = def;
    }
    /* overrides toString() in order to have correct output for Pokemon Object*/
    @Override
	public String toString() {
    	return "Name: " + this.name + "\nType: " + this.type + "\nHP: " + this.healthPoints + "\n"
    			+ "Attack: " + this.attack + "\nDefense: " + this.defense + "\n";
    }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setType1(String type) {
		this.type = type;
	}
	public String getType1() {
		return this.type;
	}
	
	public void setHP(int hp) {
		this.healthPoints = hp;
	}
	public int getHP() {
		return this.healthPoints;
	}
	public void setAttack(int atk) {
		this.attack = atk;
	}
	public int getAttack() {
		return this.attack;
	}
	public void setDefense(int def) {
		this.defense = def;
	}
	public int getDefense() {
		return this.defense;
	}
}
