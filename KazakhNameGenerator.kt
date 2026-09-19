package kz.nordpos

import kotlin.random.Random

/** Генерирует вымышленные имена в казахском фонетическом стиле. */
class KazakhNameGenerator : WorldNameGenerator {
    private enum class Harmony { FRONT, BACK }
    private data class NamePart(val text: String, val harmony: Harmony)

    private val roots = listOf(
        NamePart("Әлмер", Harmony.FRONT), NamePart("Ергез", Harmony.FRONT), NamePart("Көрен", Harmony.FRONT), NamePart("Меңір", Harmony.FRONT),
        NamePart("Өркеш", Harmony.FRONT), NamePart("Сезім", Harmony.FRONT), NamePart("Үркей", Harmony.FRONT), NamePart("Шегір", Harmony.FRONT),
        NamePart("Аймар", Harmony.BACK), NamePart("Бозан", Harmony.BACK), NamePart("Дарақ", Harmony.BACK), NamePart("Жайнар", Harmony.BACK),
        NamePart("Құмар", Harmony.BACK), NamePart("Мұнар", Harmony.BACK), NamePart("Саумар", Harmony.BACK), NamePart("Тұмар", Harmony.BACK)
    )
    private val endings = listOf(
        NamePart("ей", Harmony.FRONT), NamePart("ем", Harmony.FRONT), NamePart("ер", Harmony.FRONT), NamePart("ім", Harmony.FRONT),
        NamePart("ел", Harmony.FRONT), NamePart("өр", Harmony.FRONT), NamePart("ай", Harmony.BACK), NamePart("ақ", Harmony.BACK),
        NamePart("ар", Harmony.BACK), NamePart("ас", Harmony.BACK), NamePart("ұн", Harmony.BACK), NamePart("ық", Harmony.BACK)
    )

    override fun generateName(random: Random): String {
        val root = roots.random(random)
        val ending = endings.filter { it.harmony == root.harmony }.random(random)
        return root.text + ending.text
    }
}
