package learn.java.basic;

class Plant {
	private String name;
	Plant() {}
//	public Plant() {}
	public Plant(String name) { this.name = name; }
	public String getName() { return name; }
	public static void main(String[] args) {
		Plant p = new Plant();
	}
}

public class Tree {
	public void getFruit() {}
	public void dropLeaves() {}

}