package io.github.nothtaro.sokoban.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import io.github.nothtaro.sokoban.stage.tile.TileType

object TexturePreloader {
    private lateinit var atlas:TextureAtlas

    fun initialize() {
        atlas = TextureAtlas(Gdx.files.internal("sprites/tile/TileAtlas.atlas"))
    }

    fun loadTile(tileType: TileType):TextureRegion {
        return when(tileType) {
            TileType.BOX -> {
                atlas.findRegion("box")
            }
            TileType.WALL -> {
                atlas.findRegion("wallTop")
            }
            TileType.WALLBOTTOM -> {
                atlas.findRegion("wallBottom")
            }
            TileType.FLOOR -> {
                atlas.findRegion("floor")
            }
            TileType.GOAL -> {
                atlas.findRegion("goal")
            }
        }
    }

    fun dispose() {
        atlas.dispose()
    }
}