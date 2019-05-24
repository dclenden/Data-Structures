//David W. Clendenning Jr. - Week 7
package week7;

public class Airplane {
	String airline;
	int flightNumber;

	public Airplane(String airline, int flightNumber) {
		this.airline = airline;
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	@Override
	public String toString() {
		return "Airplane [airline=" + airline + ", flightNumber=" + flightNumber + "]";
	}
	
}
