package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class Box(override var x:Int, override var y:Int, override var textureSize: Int) : Entity {
    private var easeX:Float = (textureSize * x).toFloat(); private var easeY:Float = (textureSize * y).toFloat()

    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),easeX,easeY,textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) {
        easeX += (0.25 * ((64 * x) - easeX)).toFloat()
        easeY += (0.25 * ((64 * y) - easeY)).toFloat()
    }

    override fun dispose() { }
}