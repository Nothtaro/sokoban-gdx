package io.github.nothtaro.sokoban.entity

enum class EntityType(val id:Int) {
    PLAYER(1),
    BOX(2),
    WALL(0);

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