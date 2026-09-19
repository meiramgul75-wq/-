package kz.nordpos

import kotlin.random.Random

/** Generates fictional world names with an English fantasy sound. */
class EnglishNameGenerator : WorldNameGenerator {
    private val roots = listOf("Alder", "Bren", "Calen", "Damar", "Eldor", "Faryn", "Galen", "Thorne")
    private val endings = listOf("ia", "or", "en", "is", "ara", "une")

    override fun generateName(random: Random): String = roots.random(random) + endings.random(random)
}
