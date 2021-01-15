package io.github.nothtaro.sokoban.ui

enum class FontType(val id:Int) {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    NINE(8);

    companion object {
        fun getFromId(id:Int): FontType? {
            values().forEach {
                if(it.id == id) {
                    return it
                }
            }
            return null
        }
    }
}