package io.github.nothtaro.sokoban.stage.tile

enum class TileType(val id:Int) {
    VOID(666),
    WALL(1),
    WALLBOTTOM(2),
    FLOOR(0),
    BOX(3),
    GOAL(4);

    companion object {
        fun getFromId(id:Int): TileType? {
            values().forEach {
                if(it.id == id) {
                    return it
                }
            }
            return null
        }
    }
}