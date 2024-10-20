package project2;

public class Node {
    private String type;   // "operator" (AND/OR) or "operand" (conditions like age > 30)
    private String value;  // The actual condition (for operands)
    private Node left;     // Left child node (for operators)
    private Node right;    // Right child node (for operators)

    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	
    // Getters and Setters for accessing and modifying the fields
}
