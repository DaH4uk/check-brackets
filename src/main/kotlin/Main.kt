import java.util.Stack

// moved the map from the function to make it more expandable
val openingToClosingBrackets = mapOf('{' to '}', '[' to ']', '(' to ')')

fun checkBrackets(inputString: String, openingToClosingBrackets: Map<Char, Char>): Boolean {
    val openingBrackets = openingToClosingBrackets.keys
    val closingBrackets = openingToClosingBrackets.values

    val stack = Stack<Char>()

    for (char in inputString) {
        // optional checking if char is not a bracket at all
        if (!openingBrackets.contains(char) && !closingBrackets.contains(char)) {
            return false
        }

        // add opening bracket to stack
        if (openingBrackets.contains(char)) {
            stack.push(char)

        // check if closing bracket matches last opening bracket
        } else if (closingBrackets.contains(char)) {
            // return false if stack is empty
            if (stack.isEmpty()) {
                return false
            }
            val last = stack.pop()
            // return false if closing bracket doesn't match last opening bracket
            if (openingToClosingBrackets[last] != char) {
                return false
            }
        }
    }

    // return false if stack is not empty
    return stack.isEmpty()
}
