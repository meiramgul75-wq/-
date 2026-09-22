package kz.nordpos

import kotlin.random.Random

/** Контракт генератора вымышленных имён мира. */
interface WorldNameGenerator {
    fun generateName(random: Random = Random.Default): String
}
