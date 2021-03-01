import Flore.Vegetal;

public class Emplacement {
	private Vegetal veg;
	
	//accesseur / Getter
	public Vegetal getVeg() {
		return veg;
	}
	
	public Emplacement(Vegetal veg) {
		this.veg = veg;
	}
	
	@Override
	public String toString() {
		return veg.toString();
	}
}
