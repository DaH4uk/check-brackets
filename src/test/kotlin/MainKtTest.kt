import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @org.junit.jupiter.api.Test
    fun `should return false for random string`() {
        val testCase = "Hello, world!"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @org.junit.jupiter.api.Test
    fun `should return true for valid string`() {
        val testCase = "((({{}})))()[][][{{}}]"

        assertTrue(checkBrackets(testCase, openingToClosingBrackets))
    }

    @org.junit.jupiter.api.Test
    fun `should return false for invalid string`() {
        val testCase = "({)}]"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @org.junit.jupiter.api.Test
    fun `should return false for string with unpaired opening brackets`() {
        val testCase = "({{[("

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @org.junit.jupiter.api.Test
    fun `should return false for string with unpaired closing brackets`() {
        val testCase = "}}])"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }
}
