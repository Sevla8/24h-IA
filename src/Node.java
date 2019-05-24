public class Node {
	private Cell cell;
	private Node rightNode;
	private Node leftNode;

	public Node(Cell cell, Node rightNode, Node leftNode) {
		this.cell = cell;
		this.rightNode = rightNode;
		this.leftNode = leftNode;
	}

	public Node(Cell cell) {
		this(cell, null, null);
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
