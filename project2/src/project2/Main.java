package project2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Initialize the rule engine
        RuleEngine ruleEngine = new RuleEngine();

        // Create the rule: "age > 30 AND department = 'Sales'"
        Node rule = ruleEngine.createRule();

        // Create user data (use HashMap for Java 8 compatibility)
        Map<String, Object> userData = new HashMap<>();
        userData.put("age", 18);              // Adding "age" to the map
        userData.put("department", "Sales");  // Adding "department" to the map

        // Retrieve the user's age from the userData map
        int age = (int) userData.get("age");

        // Evaluate the rule against the user data
        boolean isEligible = ruleEngine.evaluateRule(rule, userData);

        // Output the result and display the user's age
        System.out.println("User is eligible: " + isEligible);
        System.out.println("User's age: " + age);
    }
}
