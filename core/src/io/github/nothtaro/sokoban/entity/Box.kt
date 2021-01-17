package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class Box(override var position: Point, override var textureSize: Int) : Entity {
    private var easeX:Float = (textureSize * position.x).toFloat(); private var easeY:Float = (textureSize * position.y).toFloat()

    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),easeX,easeY,textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) {
        easeX += (0.25 * ((64 * position.x) - easeX)).toFloat()
        easeY += (0.25 * ((64 * position.y) - easeY)).toFloat()
    }

    override fun dispose() { }
}