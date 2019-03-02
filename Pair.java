
public class Pair {
	/*
	 * Pair class to help store top three char values, takes a Char and an Integer Value
	 */
	
	private char item;
	private int value;
	
	public Pair(char item, int value) {
		this.setItem(item);
		this.setValue(value);
	}
	
	public char getItem() {
		return item;
	}

	public void setItem(char item) {
		this.item = item;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return "("+ getItem() + " ," + getValue() + ")";
	}
}
