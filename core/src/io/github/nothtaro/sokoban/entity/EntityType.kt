package io.github.nothtaro.sokoban.entity

enum class EntityType(val id:Int) {
    PLAYER(2),
    BOX(3),
    WALL(0),
    WALLBOTTOM(1);

    companion object {
        fun getFromId(id:Int): EntityType? {
            values().forEach {
                if(it.id == id) {
                    return it
                }
            }
            return null
        }
    }
}