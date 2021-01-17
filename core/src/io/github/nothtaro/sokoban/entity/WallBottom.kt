package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.state.Direction
import io.github.nothtaro.sokoban.util.Point
import io.github.nothtaro.sokoban.util.TexturePreloader

class WallBottom(override var position: Point, override var textureSize: Int) : Entity {
    override var direction: Direction = Direction.NORTH

    override fun getEntityType() : EntityType {
        return EntityType.WALL
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.WALLBOTTOM),(textureSize * position.x).toFloat(),(textureSize * position.y).toFloat(),textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) { }

    override fun dispose() { }
}