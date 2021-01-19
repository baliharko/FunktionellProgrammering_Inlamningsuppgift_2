package inl_2_kotlin

data class TomteTreeKotlin(val name: String) {

    companion object {

        val tomten = Node("Tomten")
        val glader = Node("Glader")
        val butter = Node("Butter")
        val tröger = Node("Tröger")
        val trötter = Node("Trötter")
        val blyger = Node("Blyger")
        val rådjuret = Node("Rådjuret")
        val nyckelpigan = Node("Nyckelpigan")
        val haren = Node("Haren")
        val räven = Node("Räven")
        val myran = Node("Myran")
        val gråsuggan = Node("Gråsuggan")
        val bladlusen = Node("Bladlusen")
        val skumtomten = Node("Skumtomten")
        val dammråttan = Node("Dammråttan")

        init {
            tomten.addSubordinates(glader, butter)
            glader.addSubordinates(tröger, trötter, blyger)
            trötter.addSubordinates(skumtomten)
            skumtomten.addSubordinates(dammråttan)
            butter.addSubordinates(rådjuret, nyckelpigan, haren, räven)
            räven.addSubordinates(gråsuggan, myran)
            myran.addSubordinates(bladlusen)
        }

        val allNodes: List<Node>
            get() = listOf(
                tomten,
                glader,
                butter,
                tröger,
                trötter,
                blyger,
                rådjuret,
                nyckelpigan,
                haren,
                räven,
                myran,
                gråsuggan,
                bladlusen,
                skumtomten,
                dammråttan
            )
    }
}