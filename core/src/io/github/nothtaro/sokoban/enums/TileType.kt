package io.github.nothtaro.sokoban.enums

enum class TileType(val id:Int, val collidable:Boolean) {
    VOID(666,true),
    FLOOR(0,false),
    WALL(1,true),
    WALLBOTTOM(2,true),
    GOAL(3,false);

    companion object {
        fun fromID(id:Int): TileType? {
            return values().find { it.id == id }
        }
    }
}