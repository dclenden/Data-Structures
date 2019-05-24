/*
* @author David W. Clendenning Jr.
*/
package week12;

public class Pokemon implements Comparable<Pokemon> {
	private String name;
	private int total;
	private int speed;
	
	public Pokemon() {
		
	}
	
	public Pokemon(String name, int total, int speed) {
		this.name = name;
		this.total = total;
		this.speed = speed;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return name + " (total=" + total + ", speed=" + speed +")";
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * 
	 * 
	 */
	@Override
	public int compareTo(Pokemon pokemon) {
		if (this.name.compareTo(pokemon.name) > 0) {
			return 1;
		} else if (this.name.compareTo(pokemon.name) < 0) {
			return -1;
		}
		return 0;
	}
	
	

}