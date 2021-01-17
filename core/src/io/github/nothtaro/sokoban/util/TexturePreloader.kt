package io.github.nothtaro.sokoban.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import io.github.nothtaro.sokoban.stage.tile.TileType

object TexturePreloader {
    private lateinit var atlas:TextureAtlas

    fun initialize() {
        atlas = TextureAtlas(Gdx.files.internal("blockAtlas.atlas"))
    }

    fun loadTile(tileType: TileType):TextureRegion {
        return when(tileType) {
            TileType.BOX -> {
                atlas.findRegion("atlas0002")
            }
            TileType.WALL -> {
                atlas.findRegion("atlas0000")
            }
            TileType.FLOOR -> {
                atlas.findRegion("atlas0001")
            }
        }
    }

    fun dispose() {
        atlas.dispose()
    }
}