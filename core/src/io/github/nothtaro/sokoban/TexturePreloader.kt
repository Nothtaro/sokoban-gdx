package io.github.nothtaro.sokoban

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

object TexturePreloader {
    lateinit var atlas:TextureAtlas

    fun initalize() {
        atlas = TextureAtlas(Gdx.files.internal("blockAtlas.atlas"))
    }

    fun loadTile(tileType: TileType):TextureRegion {
        var temp:TextureRegion
        when(tileType) {
            TileType.BOX -> {
                temp = atlas.findRegion("atlas0002")
            }
            TileType.WALL -> {
                temp = atlas.findRegion("atlas0000")
            }
            TileType.FLOOR -> {
                temp = atlas.findRegion("atlas0001")
            }
        }
        return temp
    }

    fun dispose() {
        atlas.dispose()
    }
}