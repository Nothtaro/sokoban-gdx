package io.github.nothtaro.sokoban.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.enums.TileType

object TextureInitializer {
    private lateinit var tileAtlas: TextureAtlas

    fun initialize() {
        tileAtlas = TextureAtlas(Gdx.files.internal("sprites/tile/TileAtlas.atlas"))
    }

    fun load(tileType: TileType):TextureRegion {
        return when(tileType) {
            TileType.WALL -> tileAtlas.findRegion("wallTop")
            TileType.WALLBOTTOM -> tileAtlas.findRegion("wallBottom")
            TileType.FLOOR -> tileAtlas.findRegion("floor")
            TileType.GOAL -> tileAtlas.findRegion("goal")
            TileType.VOID -> tileAtlas.findRegion("goal")
        }
    }

    fun load(entityType: EntityType):TextureRegion {
        return when(entityType) {
            EntityType.PLAYER -> TODO()
            EntityType.BOX -> tileAtlas.findRegion("box")
        }
    }

    fun dispose() {
        tileAtlas.dispose()
    }
}