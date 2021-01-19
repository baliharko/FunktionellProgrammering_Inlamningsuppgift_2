package inl_2_kotlin

import java.lang.NullPointerException

val tomteMap = TomteTreeKotlin.allNodes.groupBy { it.name.toLowerCase() }

fun main() {

    fun getHierarchy(name: String, dir: String): List<Node> =
        if (dir.equals("ö", true))
            tomteMap[name]!![0].getSuperiorsList()
        else tomteMap[name]!![0].getSubordinatesList()

    var dir: String?

    while (true) {
        println("Vill du söka efter överordnade eller undersåtar? [ö/u]")
        dir = readLine()!!.trim()
        if (dir.equals("u", true) || dir.equals("ö", true))
            break
    }

    println("Ange vem du vill börja ifrån: [namn]")
    val name: String? = readLine()
    val outDir = if (dir.equals("u", true)) "undersåtar" else "överordnade"

    try {
        val tomtar = getHierarchy(name!!.toLowerCase().trim(), dir!!)

        if (tomtar.isEmpty())
            throw NullPointerException()

        println("${tomteMap[name.toLowerCase().trim()]!![0].name}s $outDir är:\n")
        tomtar.forEach { println(it.name) }

    } catch (e: NullPointerException) {
        println("$name har inga $outDir eller jobbar inte i tomteverkstaden.")
    }
}