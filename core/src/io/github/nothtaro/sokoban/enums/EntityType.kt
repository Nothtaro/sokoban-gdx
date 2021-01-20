package io.github.nothtaro.sokoban.enums

enum class EntityType(val id:Int) {
    PLAYER(0),
    BOX(1);

    companion object {
        fun fromID(id:Int): EntityType? {
            return values().find { it.id == id }
        }
    }
}