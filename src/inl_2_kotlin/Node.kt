package inl_2_kotlin

class Node(val name: String) {

    var subordinates = mutableListOf<Node>()
    var superior: Node? = null

    private fun setParent(parent: Node) { superior = parent }

    fun addSubordinates(vararg children: Node) = children.forEach { it.setParent(this); this.subordinates.add(it) }

    fun getSubordinatesList(): List<Node> {

        fun getChild(acc: MutableList<Node>, child: Node): List<Node> {
            if (child.subordinates.isEmpty()) return acc
            else child.subordinates.forEach { getChild(acc, it); acc.add(it) }
            return acc
        }
        return getChild(mutableListOf(), this)
    }

    fun getSuperiorsList(): List<Node> {

        fun getSuperior(acc: MutableList<Node>, parent: Node?): List<Node> {
            if (parent == null) return acc
            else {
                getSuperior(acc, parent.superior)
                acc.add(parent)
            }
            return acc
        }
        return getSuperior(mutableListOf(), this.superior)
    }
}



