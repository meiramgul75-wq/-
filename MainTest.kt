package kz.nordpos

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class MainTest {
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
