package io.github.nothtaro.sokoban.stage.tile

enum class TileType(val id:Int) {
    WALL(0),
    WALLBOTTOM(1),
    FLOOR(2),
    BOX(3);

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