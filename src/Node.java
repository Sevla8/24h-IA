public class Node {
	private Cell cell;
	private int weight;
	private Node rightNode;
	private Node leftNode;

	public Node(Cell cell, int weight, Node rightNode, Node leftNode) {
		this.cell = cell;
		this.weight = weight;
		this.rightNode = rightNode;
		this.leftNode = leftNode;
	}

	public Node(Cell cell, int weight) {
		this(cell, weight, null, null);
	}

	public int getCell() {
		return this.cell;
	}
	public Node getRightNode() {
		return this.rightNode;
	}
	public Node getLeftNode() {
		return this.leftNode;
	}
}
