//David W. Clendenning Jr. - CIS211 - week 4-5
package week4;
/* implementing PokemonInterface to have more abstract data*/
public class Pokemon implements PokemonInterface{
    private String name;
    private String type;
    private int healthPoints;
	/* basic constructors */
    public Pokemon() {
    	
    }
    
    public Pokemon(String name, String type, int healthPoints) {
    	this.name = name;
    	this.type = type;
    	this.healthPoints = healthPoints;
    }
    /* overrides toString() in order to have correct output for Pokemon Object*/
    @Override
	public String toString() {
    	return "[Name: " + this.name + ", Type: " + this.type + ", HP: " + this.healthPoints + "]";
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
}
