package cz.upce.fei.janacek.main.model

data class Complex(
    val real: Int,
    val complex: Int
) {
    override fun toString(): String {
        return "$real + {$complex}i"
    }
}
