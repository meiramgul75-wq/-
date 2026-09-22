package kz.nordpos

import kotlin.random.Random

/** Генерирует вымышленные имена в русском фэнтезийном звучании. */
class RussianNameGenerator : WorldNameGenerator {
    private val roots = listOf("Велор", "Зарин", "Крадор", "Люмар", "Мирол", "Равен", "Солдар", "Яромир")
    private val endings = listOf("ия", "ар", "ея", "он", "ель", "оград")

    override fun generateName(random: Random): String = roots.random(random) + endings.random(random)
}
