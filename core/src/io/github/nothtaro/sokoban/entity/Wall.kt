package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class Wall(override var position: Point, override var textureSize: Int) : Entity {
    override fun getEntityType() : EntityType {
        return EntityType.WALL
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.WALL),(textureSize * position.x).toFloat(),(textureSize * position.y).toFloat(),textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) { }

    override fun dispose() { }
}