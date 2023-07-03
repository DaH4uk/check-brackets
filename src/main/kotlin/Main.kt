import java.util.Stack

// moved the map from the function to make it more expandable
val openingToClosingBrackets = mapOf('{' to '}', '[' to ']', '(' to ')')

fun checkBrackets(inputString: String, openingToClosingBrackets: Map<Char, Char>): List<Triple<Int, Int, Char>> {
    // return empty list if string is empty
    if (inputString.isEmpty()) {
        return emptyList()
    }

    val openingBrackets = openingToClosingBrackets.keys
    val closingBrackets = openingToClosingBrackets.values

    val stack = Stack<Pair<Char, Int>>()
    val positions = mutableListOf<Triple<Int, Int, Char>>()

    for ((index, char) in inputString.withIndex()) {
        // optional checking if char is not a bracket at all
        if (!openingBrackets.contains(char) && !closingBrackets.contains(char)) {
            return emptyList()
        }

        // add opening bracket to stack
        if (openingBrackets.contains(char)) {
            stack.push(char to index)

            // check if closing bracket matches last opening bracket
        } else if (closingBrackets.contains(char)) {
            // return empty list if stack is empty
            if (stack.isEmpty()) {
                return emptyList()
            }
            val (last, start) = stack.pop()
            // return empty list if closing bracket doesn't match last opening bracket
            if (openingToClosingBrackets[last] != char) {
                return emptyList()
            }

            // add position of opening and closing brackets to the result list
            positions.add(Triple(start, index, last))
        }
    }

    // return empty list if stack is not empty
    if (stack.isNotEmpty()) {
        return emptyList()
    }

    return positions
}
