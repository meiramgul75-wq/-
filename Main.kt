package kz.nordpos

fun main() {
    val english = EnglishNameGenerator().generateName()
    val russian = RussianNameGenerator().generateName()
    val kazakh = KazakhNameGenerator().generateName()

    println("Генератор имён вселенной DAIRN")
    println("-------------------------------")
    println("Английское: $english")
    println("Русское:    $russian")
    println("Казахское:  $kazakh")
}
