package project2;

import java.util.Map;

public class RuleEngine {

    // Method to evaluate the rule AST against user data
    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node.getType().equals("operand")) {
            return evaluateCondition(node.getValue(), data);  // Evaluate condition (e.g., age > 30)
        } else if (node.getType().equals("operator")) {
            boolean leftResult = evaluateRule(node.getLeft(), data);
            boolean rightResult = evaluateRule(node.getRight(), data);

            if (node.getValue().equals("AND")) {
                return leftResult && rightResult;  // Return true if both left and right conditions are true
            } else if (node.getValue().equals("OR")) {
                return leftResult || rightResult;  // Return true if either left or right condition is true
            }
        }
        return false;
    }

    // Method to evaluate a single condition
    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        if (condition.contains("age >")) {
            int age = (int) data.get("age");
            int threshold = Integer.parseInt(condition.split(">")[1].trim());  // Extract the number from the condition
            return age > threshold;
        } else if (condition.contains("department =")) {
            String department = (String) data.get("department");
            String deptValue = condition.split("=")[1].trim().replace("'", "");
            return department.equals(deptValue);
        }
        return false;
    }

    // Method to create the AST (for the rule: age > 30 AND department = 'Sales')
    public Node createRule() {
        // Create leaf nodes (conditions)
        Node ageGreaterThan30 = new Node("operand", "age > 30");
        Node deptSales = new Node("operand", "department = 'Sales'");

        // Create AND node to combine conditions
        Node andNode = new Node("operator", "AND");
        andNode.setLeft(ageGreaterThan30);
        andNode.setRight(deptSales);

        return andNode;
    }
}
