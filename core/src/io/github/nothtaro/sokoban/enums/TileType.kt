package io.github.nothtaro.sokoban.enums

enum class TileType(val id:Int) {
    VOID(666),
    FLOOR(0),
    WALL(1),
    WALLBOTTOM(2),
    GOAL(3);

    companion object {
        fun fromID(id:Int): TileType? {
            return TileType.values().find { it.id == id }
        }
    }
}