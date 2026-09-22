package kz.nordpos

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertTrue

class MainTest {
    @Test
    fun `main prints a name for every language`() {
        val output = ByteArrayOutputStream()
        val originalOut = System.out

        try {
            System.setOut(PrintStream(output))
            main()
        } finally {
            System.setOut(originalOut)
        }

        val text = output.toString(Charsets.UTF_8)
        assertContains(text, "Английское:")
        assertContains(text, "Русское:")
        assertContains(text, "Казахское:")
    }

    @Test
    fun `generated names use Kazakh letters and vowel harmony`() {
        val names = List(200) { KazakhNameGenerator().generateName(Random(it)) }
        val kazakhName = Regex("^[А-ЯӘҒҚҢӨҰҮҺІа-яәғқңөұүһі]+$")
        val frontVowels = setOf('ә', 'е', 'і', 'ө', 'ү')
        val backVowels = setOf('а', 'ы', 'о', 'ұ')

        assertTrue(names.all(kazakhName::matches))
        assertTrue(names.none { name -> name.first().lowercaseChar() == 'ң' })
        assertTrue(names.all { name ->
            val letters = name.lowercase().toSet()
            !(letters.any(frontVowels::contains) && letters.any(backVowels::contains))
        })
    }

    @Test
    fun `each language generator uses its own alphabet`() {
        val russianNames = List(100) { RussianNameGenerator().generateName(Random(it)) }
        val englishNames = List(100) { EnglishNameGenerator().generateName(Random(it)) }
        val russianName = Regex("^[А-Яа-я]+$")
        val englishName = Regex("^[A-Za-z]+$")

        assertTrue(russianNames.all(russianName::matches))
        assertTrue(englishNames.all(englishName::matches))
    }
}
