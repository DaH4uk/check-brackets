import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `should return false for random string`() {
        val testCase = "Hello, world!"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return true for valid string`() {
        val testCase = "((({{}})))()[][][{{}}]"

        assertTrue(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for invalid string`() {
        val testCase = "({)}]"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for string with unpaired opening brackets`() {
        val testCase = "({{[("

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for string with unpaired closing brackets`() {
        val testCase = "}}])"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for the empty string`() {
        val testCase = ""

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for string with unpaired brackets`() {
        val testCase = "({{[()}}])"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false one open string`() {
        val testCase = "{"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false one close string`() {
        val testCase = "}"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should return false for string with wrong order`() {
        val testCase = "({{[()]}}])"

        assertFalse(checkBrackets(testCase, openingToClosingBrackets))
    }

    @Test
    fun `should test performance`() {
        val n = 1_000_000
        val testCase = "(".repeat(n) + ")".repeat(n)

        val startTime = System.nanoTime()
        assertTrue(checkBrackets(testCase, openingToClosingBrackets))
        val endTime = System.nanoTime()
        println("Time: ${(endTime - startTime) / 1_000_000} ms")
    }
}
