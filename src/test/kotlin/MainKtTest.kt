import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `should return empty list for random string`() {
        val testCase = "Hello, world!"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return positions for valid string`() {
        val testCase = "((({{}})))()[][][{{}}]"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        val expectedPositions = listOf(
            Triple(4, 5, '{'),
            Triple(3, 6, '{'),
            Triple(2, 7, '('),
            Triple(1, 8, '('),
            Triple(0, 9, '('),
            Triple(10, 11, '('),
            Triple(12, 13, '['),
            Triple(14, 15, '['),
            Triple(18, 19, '{'),
            Triple(17, 20, '{'),
            Triple(16, 21, '[')
        )
        assertTrue(positions.isNotEmpty())
        assertEquals(expectedPositions, positions)
    }

    @Test
    fun `should return empty list for invalid string`() {
        val testCase = "({)}]"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list for string with unpaired opening brackets`() {
        val testCase = "({{[("

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list for string with unpaired closing brackets`() {
        val testCase = "}}])"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list for the empty string`() {
        val testCase = ""

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list for string with unpaired brackets`() {
        val testCase = "({{[()}}])"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list one open string`() {
        val testCase = "{"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list one close string`() {
        val testCase = "}"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should return empty list for string with wrong order`() {
        val testCase = "({{[()]}}])"

        val positions = checkBrackets(testCase, openingToClosingBrackets)

        assertTrue(positions.isEmpty())
    }

    @Test
    fun `should test performance`() {
        val n = 1_000_000
        val testCase = "(".repeat(n) + ")".repeat(n)

        val startTime = System.nanoTime()
        checkBrackets(testCase, openingToClosingBrackets)
        val endTime = System.nanoTime()
        println("Time: ${(endTime - startTime) / 1_000_000} ms")
    }
}
