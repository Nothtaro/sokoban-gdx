package io.github.nothtaro.sokoban

import com.badlogic.gdx.graphics.g2d.TextureRegion

enum class TileType(val id:Int) {
    WALL(0),
    FLOOR(1),
    BOX(2);

    companion object {
        fun getFromId(id:Int): TileType? {
            TileType.values().forEach {
                if(it.id == id) {
                    return it
                }
            }
            return null
        }
    }
}