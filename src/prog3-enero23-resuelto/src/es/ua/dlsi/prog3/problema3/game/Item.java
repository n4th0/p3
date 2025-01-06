package es.ua.dlsi.prog3.problema3.game;

public class Item {
	private double value;
	
	public Item() {
		value=0.0;
	}
	
	public Item(double value) {
		if (value < 0.0) throw new RuntimeException("Items can't have negative values");
		this.value=value;
	}
	
	public Item(Item item) {
		this.value=item.value;
	}
	
	public double getValue() {
		return value;
	}
}
